public class Graph {
    LinkedList<Edge>[] graph;
    boolean directed;
    static int count = 0;

    public Graph(int N) {
        this(N, false);
    }
    public Graph(int N, boolean directed) {
        graph = new LinkedList[N];
        this.directed = directed;

        for (int i = 0; i < graph.length; i++) {
            graph[i] = new LinkedList<>();
        }
    }

    public int size() {
        return graph.length;
    }

    public boolean isDirected() {
        return directed;
    }

    public boolean hasEdge(int v, int u) {
        if(validVertex(v) || validVertex(u)){
            System.out.println("Vertex not valid");
            System.exit(1);
        }
        for (LinkedList<Edge> e_list : graph) {
            for (Edge e : e_list) {
                if(e.from() == v && e.to() == u) {
                    return true;
                }
            }
        }
        return false;
    }

    public Iterable<Edge> neighbours(int v) {
        if(validVertex(v)){
            System.out.println("Vertex not valid");
            System.exit(1);
        }
        return graph[v];
    }

    public int degree(int v) {
        if(validVertex(v)){
            System.out.println("Vertex not valid");
            System.exit(1);
        }
        return graph[v].size();
    }

    public void removeEdge(int v, int u) {
        if(validVertex(v) || validVertex(u)){
            System.out.println("Vertex not valid");
            System.exit(1);
        }
        if(!hasEdge(v,u)) {
            System.out.println("Edge not valid");
            System.exit(1);
        }
        for (LinkedList<Edge> e_list : graph) {
            // Collections remove... cool thing!
            e_list.removeIf(e -> (e.from() == v && e.to() == u ) || (!isDirected() && (e.to() == v && e.from() == u)));
        }
        if (!isDirected()) {
            count--;
        }
        count--;
    }

    public void addEdge(int v, int u, int weight) {
        if(validVertex(v) || validVertex(u)){
            System.out.println("Vertex not valid");
            System.exit(1);
        }
        graph[v].add(new Edge(v, u, weight));
        if (!isDirected()) {
            graph[u].add(new Edge(u, v, weight));
            count++;
        }
        count++;
    }

    public boolean validVertex(int v) {
        return ((v < 0) && (v > size()));
    }

    @Override
    public String toString() {
        return "Graph{" +
                "graph=" + Arrays.toString(graph) +
                '}';
    }

    public LinkedList<Edge>[] getGraph() {
        return graph;
    }

    public int countEdges() {
        return count;
    }
    
    public static void main(String[] args) {
        Graph g = new Graph(100, false);
        Random r = new Random();


        for(int i = 0; i < 100; i++){
            int v = r.nextInt(100);
            int u = r.nextInt(100);
            int w = r.nextInt(100);
            g.addEdge(v, u, w);
        }

        System.out.println(g);

        System.out.println("Has edge: (1,0)? " + g.hasEdge(1,0));

        System.out.print("Neighbours of 0: ");
        for (Edge e : g.neighbours(0)) {
            System.out.println(e);
        }
        System.out.println();

        System.out.println("degree 0: " + g.degree(0));
    }
}
