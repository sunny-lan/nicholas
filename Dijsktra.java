import java.util.*;

public class DijkstraBruteForce {

    class Edge {
        public int neighbor;
        public int weight;
    }

    class Candidate implements Comparable<Candidate> {
        public int node;
        public int dist;

        public Candidate(int node, int dist) {
            this.node=node;
            this.dist=dist;
        }

        @Override
        public int compareTo(DijkstraBruteForce.Candidate o) {
            return Integer.compare(dist, o.dist);
        }
    }

    public static void dijkstra(ArrayList<ArrayList<Edge>> graph, int source) {
        int numVertices = graph.size();
        int[] dist = new int[numVertices];
        boolean[] visited = new boolean[numVertices];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[source] = 0;
        //visited[source] = true;

        PriorityQueue<Candidate> candidates = new PriorityQueue<>();
        candidates.add(new Candidate(source, 0));

     
        for (int i = 0; i < numVertices; i++) {
            int minDist = Integer.MAX_VALUE;
            int minVertex = -1;

        
            Candidate next = candidates.remove();
            if(visited[next.node])
                continue;

            minDist = next.dist;
            minVertex = next.node;

            // Mark the selected vertex as visited
            visited[minVertex] = true;

            // Update distances for adjacent vertices
            for (Edge edge : graph.get(minVertex)) {
                int v = edge.neighbor;
                int weight = edge.weight;

                if (!visited[v]) {
                    int newDist = dist[minVertex] + weight;
                    if (newDist < dist[v]) {
                        dist[v] = newDist;
                        candidates.add(new Candidate(v, newDist));
                    }
                }
            }
        }

        for (int i = 0; i < numVertices; i++) {
            System.out.println("Shortest distance from " + source + " to " + i + ": " + dist[i]);
        }
    }

    public static void main(String[] args) {
        
        int source = 0;

        dijkstra(graph, source);
    }
}