import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;

public class BFS {
    Graph g;
    int root;

    public BFS(Graph g, int root) {
        this.g = g;
        this.root = root;
    }

    public List<Integer> search(){
        boolean [] visited = new boolean[g.size()];
        ArrayList<Integer> reach = new ArrayList<>();

        List<Integer> q = new LinkedList<>();
        visited[root] = true;
        q.add(root);

        while (!(q.isEmpty())){
            int v = q.remove(0);
            reach.add(v);

            for(Edge e : g.neighbours(v)){
                int u = e.to();
                if(!visited[u]){
                    visited[u] = true;
                    q.add(u);
                }
            }
        }
        return reach;
    }

    public static void main(String[] args) {
        Graph g = new Graph(20);
        Random r = new Random();

        for(int i = 0; i < 40; i++){
            int v = r.nextInt(20);
            int u = r.nextInt(20);
            int w = r.nextInt(100);
            g.addEdge(v, u, w);
        }

        BFS bfs = new BFS(g, r.nextInt(20));

        List<Integer> visited = bfs.search();

        System.out.print(visited);

    }
}
