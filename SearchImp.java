import java.util.LinkedList;
import java.util.Queue;
import CITS2200.Graph;
import CITS2200.Search;

public class SearchImp implements Search {

    public int[] getConnectedTree(Graph g, int startVertex) {

        int[][] adj = g.getEdgeMatrix();
        int numVertices = g.getNumberOfVertices();
        int root = startVertex;

        int[] parent = new int[numVertices];
        for (int i = 0; i < parent.length; i++) {
            parent[i] = -1;
        }


        Queue q = new LinkedList<Integer>();

        boolean[] visited = new boolean[numVertices];
        for (int i = 0; i < numVertices; i++) {
            visited[i] = false;
        }

        q.add(root);

        while (!q.isEmpty()) {
            int x = (int) q.remove();

            if (!visited[x]) {
                visited[x] = true;

                for (int i = 0; i < numVertices; i++) {
                    if (adj[x][i] == 1 && (!visited[i])) {
                        parent[i] = x;
                        visited[i] = true;
                        q.add(i);
                    }
                }
            }
        }
        return parent;
    }

    public int[] getDistances(Graph g, int startVertex) {
        int[][] adj = g.getEdgeMatrix();
        int numVertices = g.getNumberOfVertices();
        int root = startVertex;
        
        int[] dist = new int[numVertices];
        
        Queue q = new LinkedList<Integer>();

        boolean[] visited = new boolean[numVertices];
        for (int i = 0; i < numVertices; i++) {
            visited[i] = false;
        }

        q.add(root);

        while (!q.isEmpty()) {
            int x = (int) q.remove();

            if (!visited[x]) {
                visited[x] = true;              
               for (int i = 0; i < numVertices; i++) {
                    if (adj[x][i] == 1 && (!visited[i])) {
                        q.add(i);
                        visited[i] = true;
                        dist[x] = dist[i] + 1;
                    }
              }
           }
        }
        return dist;
    }

    public int[][] getTimes(Graph g, int startVertex) {
        int[][] p = null;
        return p;
    }
}
