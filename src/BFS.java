import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class BFS {
    Graph g;
    int root;

    public BFS(Graph g, int root){
        this.g = g;
        this.root = root;
    }

    public List<Integer> search(){
        List visited = new ArrayList(g.size());


        return visited;
    }


    public static void main(String[] args) {
        Graph g = new Graph(20);
        Random r = new Random();

        for(int i = 0; i < 40; i++){
            int v = r.nextInt(20);
            int u = r.nextInt(20);
            g.addEdge(v, u);
        }

        BFS bfs = new BFS(g, r.nextInt(20));

        List<Integer> visited = bfs.search();

        for(Integer i : visited){
            System.out.print(visited + ", ");
        }
    }
}
