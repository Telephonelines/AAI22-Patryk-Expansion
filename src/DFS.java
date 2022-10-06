import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;



public class DFS {
    Graph g;
    int root;

    public DFS(Graph g, int root){
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

            for(int u : g.neighbours(v)){
                if(!visited[u]){
                    visited[u] = true;
                    q.add(0,u);
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
            g.addEdge(v, u);
        }

        BFS bfs = new BFS(g, r.nextInt(20));

        List<Integer> visited = bfs.search();

        System.out.print(visited);

    }
}
