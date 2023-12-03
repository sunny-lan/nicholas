import java.util.*;

public class BellmanFord {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the number of vertices: ");
        int vertices = scanner.nextInt();

        List<List<Edge>> adjacencyList = new ArrayList<>();
        for (int i = 0; i < vertices; i++) {
            adjacencyList.add(new ArrayList<>());
        }
        System.out.println("Enter the directed edges (source directed to destination) and edge values (-1 to stop):");
        while (true) {
            int source = scanner.nextInt();
            if (source == -1) {
                break;
            }
            int destination = scanner.nextInt();
            int edgeValue = scanner.nextInt();
            adjacencyList.get(source).add(new Edge(destination, edgeValue));
        }

  
        System.out.print("Enter the source vertex: ");
        int source = scanner.nextInt();
        System.out.print("Enter the destination vertex: ");
        int destination = scanner.nextInt();

        int shortestPath = shortest(adjacencyList, source, destination);
        System.out.println("Shortest path from " + source + " to " + destination + ": " + shortestPath);
    }

    private static int shortest(List<List<Edge>> adjacencyList, int source, int destination) {
        int[] distance = new int[adjacencyList.size()];
        Arrays.fill(distance, Integer.MAX_VALUE);
        distance[source] = 0;

        for (int i = 0; i < adjacencyList.size() - 1; i++) {
            for (int u = 0; u < adjacencyList.size(); u++) {
                for (Edge edge : adjacencyList.get(u)) {
                    if (distance[u] != Integer.MAX_VALUE && distance[u] + edge.value < distance[edge.destination]) {
                        distance[edge.destination] = distance[u] + edge.value;
                    }
                }
            }
        }
        for (int u = 0; u < adjacencyList.size(); u++) {
            for (Edge edge : adjacencyList.get(u)) {
                if (distance[u] != Integer.MAX_VALUE && distance[u] + edge.value < distance[edge.destination]) {
                    System.out.println("Graph contains a negative cycle. No shortest path exists.");
                    return -1;
                }
            }
        }
        return distance[destination];
    }
    static class Edge {
        int destination;
        int value;
        public Edge(int destination, int value) {
            this.destination = destination;
            this.value = value;
        }
    }
}