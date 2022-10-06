import java.util.Arrays;
import java.util.LinkedList;
import java.util.Random;

public class Graph {

    LinkedList<Integer>[] graph;
    boolean directed;

    public Graph(int N){
        this(N, false);
    }
    public Graph(int N, boolean directed){
        graph = new LinkedList[N];
        this.directed = directed;

        for (int i = 0; i < graph.length; i++){
            graph[i] = new LinkedList<>();
        }
    }

    public int size(){
        return graph.length;
    }

    public boolean isDirected(){
        return directed;
    }

    public boolean hasEdge(int v, int u){
        if(validVertex(v) || validVertex(u)){
            System.out.println("Vertex not valid");
            System.exit(1);
        }
        return graph[v].contains(u);
    }

    public LinkedList neighbours(int v){
        if(validVertex(v)){
            System.out.println("Vertex not valid");
            System.exit(1);
        }
        return graph[v];

    }

    public void addEdge(int v, int u){
        if(validVertex(v) || validVertex(u)){
            System.out.println("Vertex not valid");
            System.exit(1);
        }
        graph[v].add(u);
        if(!directed) {
            graph[u].add(v);
        }
    }

    private boolean validVertex(int v){
        return ((v < 0) || (v > size()));
    }

    // public void removeEdge() ???

    public int degree(int v){
        if(validVertex(v)){
            System.out.println("Vertex not valid");
            System.exit(1);
        }
        return graph[v].size();
    }

    @Override
    public String toString() {
        return "Graph{" +
                "graph=" + Arrays.toString(graph) +
                '}';
    }

    public static void main(String[] args) {
        Graph g = new Graph(100, false);
        Random r = new Random();


        for(int i = 0; i < 100; i++){
            int v = r.nextInt(100);
            int u = r.nextInt(100);
            g.addEdge(v, u);
        }

        System.out.println(g);

        System.out.println("Has edge: (1,0)? " + g.hasEdge(1,0));

        System.out.print("Neighbours of 0: ");
        LinkedList<Integer> n = g.neighbours(0);
        for (int v : n) {
            System.out.print(v + ",");
        }
        System.out.println();

        System.out.println("degree 0: " + g.degree(0));

    }
}
