public class GridPaths {

    int N,M;
    boolean[][] is_blocked = new boolean[N][M];
    int[][] ways = new int[N][M];

   int paths(int r, int c){
    if(ways[r][c]!= -1) return ways[r][c];
    
    if(r==0 && c==0) return 1;
    if(is_blocked[r][c] == true) return 0;

    int ans= paths(r-1,c) + paths(r,c-1);

        ways[r][c]=ans;
        return ans;

   }

   // Question 1:
   // Given a directed graph, find the number of paths from A to B. It has no loops.
   // use dynamic programming

   // Question 2:
   // Given a directed graph, find the shortest path from A to B

   // Question 3:
   // You have list of courses, each course has prerequisites
   // A, B, C, D, ...

   // A -> B, C
   // D -> E, F
   // B -> D

   // There is a list of questions, can I take x before y?
   // X Y
   // ...
   // ...

}
