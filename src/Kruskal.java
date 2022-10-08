import java.util.Arrays;
import java.util.LinkedList;

public class Kruskal {
    Graph g;

    public Kruskal(Graph g) {
        this.g = g;
    }

    public Graph mst() {
        QuickUnionUFWeighting set = new QuickUnionUFWeighting(g.size());
        int i = 0;
        Edge[] ordered_edge = new Edge[g.countEdges()];
        System.out.println(g.countEdges());
        Graph mst = new Graph(g.size(), g.isDirected());
        for (LinkedList<Edge> e_list : g.getGraph()) {
            for (Edge e : e_list) {
                ordered_edge[i++] = e;
            }
        }
        // Sort the edges by weight
        for (Edge e : ordered_edge) {
            Arrays.sort(ordered_edge, e.WEIGHT_ORDER);
        }
        // Create the MST graph
        for (Edge e : ordered_edge) {
            if (set.find(e.from()) != set.find(e.to())) {
                mst.addEdge(e.from(), e.to(), e.weight());
                set.union(e.from(), e.to());
            }
        }
        return mst;
    }
}
