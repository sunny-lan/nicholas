import java.io.*;
import java.util.*;

// a) count number of components in a graph
// b) practice dijkstras, inefficient first
// c) CCC 23 S3

public class DFS {
    // n m
    // 1 2
    // 5 6
    // ...

    int readInt(){

    }


    static ArrayList<ArrayList<Integer>> graph = new ArrayList<>();

    static boolean[] visited = new boolean[n];

    boolean dfs(int currentNode, int prevNode = -1){
        if(visited[currentNode])
            return true;

        for(int neighbor:graph.get(currentNode))
        {
            if(neighbor == prevNode)
                continue;

            if(dfs(neighbor, currentNode))
                return true;
        }           

        return false;
    }
    

    public static void main(String[] args) {
        // Adjacency matrix
        boolean matrix [][] = new boolean[n][n];

        for(int i=0;i<m;i++){
            int a=readInt();
            int b=readInt();

            matrix[a-1][b-1] =true;
            matrix[b-1][a-1] =true;
            
        }

        // Adjacency list
        for(int i=0;i<n;i++)
            graph.add(new ArrayList<>());

         for(int i=0;i<m;i++){
            int a=readInt();
            int b=readInt();

            graph.get(a).add(b);
            graph.get(b).add(a);
        }

        boolean isTree = dfs(0);

    }
}    