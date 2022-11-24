import java.util.*;

public class Prim {
    Graph g;

    public Prim(Graph g) {
        this.g = g;
    }

    public Graph mst() {
        //int i = 0;
        //LinkedList<LinkedList<Edge>> v = new LinkedList<>();
        Integer[] C = new Integer[g.size()];
        Integer[] E = new Integer[g.size()];
        Comparator<Edge> w_o = new Edge.WeightOrder();
        PriorityQueue<Edge> Q = new PriorityQueue<>(w_o);
        ArrayList<Integer> visited = new ArrayList<Integer>();
        Edge[] ordered_edge = new Edge[g.countEdges()];
        //QuickUnionUFWeighting set = new QuickUnionUFWeighting(g.size());
        Graph mst = new Graph(g.size(), g.isDirected());
        for (LinkedList<Edge> e_list : g.getGraph()) {
            Q.addAll(e_list);
        }

        for (int i = 0; i < g.size(); i++) {
            C[i] = Integer.MAX_VALUE;
            E[i] = null;
        }

        while (!Q.isEmpty()) {
            Edge current = Q.poll();
            int v = current.from();
            //mst.addEdge(v, current.to(), current.weight());
            visited.add(v);
            for (Edge x : g.neighbours(v)) {
                int z = x.to();
                if (C[z] > x.weight() && !visited.contains(z)) {
                    C[z] = x.weight();
                    E[z] = v;
                }
            }
        }

        for (int i = 0; i < E.length; i++) {
            if (E[i] == null) {
                continue;
            }
            if (!mst.hasEdge(i, E[i])) {
                mst.addEdge(i, E[i], C[i]);
            }
        }
        return mst;
    }
}
/*
    Associate with each vertex v of the graph a number C[v] (the cheapest cost of a connection to v) and an edge E[v] (the edge providing that cheapest connection).
    To initialize these values, set all values of C[v] to +∞ and set each E[v] to a special flag value indicating that there is no edge connecting v to earlier vertices.
    Initialize an empty forest F and a set Q of vertices that have not yet been included in F (initially, all vertices).
    Repeat the following steps until Q is empty:
        Find and remove a vertex v from Q having the minimum possible value of C[v]
        Add v to F
        Loop over the edges vw connecting v to other vertices w. For each such edge, if w still belongs to Q and vw has smaller weight than C[w], perform the following steps:
            Set C[w] to the cost of edge vw
            Set E[w] to point to edge vw.
    Return F
 */