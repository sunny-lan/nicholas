import java.util.*;

public class CountPathsDP {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the number of vertices: ");
        int vertices = scanner.nextInt();

        List<List<Integer>> adjacencyList = new ArrayList<>();
        for (int i = 0; i < vertices; i++) {
            adjacencyList.add(new ArrayList<>());
        }

    
        System.out.println("Enter the directed edges (-1 to stop):");
        while (true) {
            int source = scanner.nextInt();
            if (source == -1) {
                break;
            }
            int destination = scanner.nextInt();

            adjacencyList.get(source).add(destination);
        }

        System.out.print("Enter the source vertex: ");
        int source = scanner.nextInt();
        System.out.print("Enter the destination vertex: ");
        int destination = scanner.nextInt();

        int ways = countPaths(adjacencyList, source, destination);
        System.out.println("There are "+ways+" ways to get from your source to destination");
    }

    private static int countPaths(List<List<Integer>> adjacencyList, int source, int destination) {
        int[] dp = new int[adjacencyList.size()];
        Arrays.fill(dp, -1);
        return countPathsHelper(adjacencyList, source, destination, dp);
    }
    private static int countPathsHelper(List<List<Integer>> adjacencyList, int current, int destination, int[] dp) {
        if (current == destination) {
            return 1;
        }
        if (dp[current] != -1) {
            return dp[current];
        }
        int ways = 0;
        for (int next : adjacencyList.get(current)) {
            ways += countPathsHelper(adjacencyList, next, destination, dp);
        }
        dp[current] = ways;
        return ways;
    }
}