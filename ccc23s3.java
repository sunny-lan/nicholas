import java.io.*;
import java.util.*;
public class ccc23s3 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer in;
    
    public static void main(String[] args) throws IOException {
        
        Random r = new Random();

        double N=readInt(); //rows 
        double M=readInt(); //columns 
        int R=readInt(); //rows req 
        int C=readInt(); //columns req 
    
        char[][]poster = new char [(int)N][(int)M];
        char[][]poster2= new char [(int)M][(int)N];
        
      if(R == N && C == M || (R != N && R != 0 && C != M && C != 0)){
        for(int i=0;i<R;i++){
            for(int j=0;j<M;j++){
                 poster[i][j] = 'a';
                 
            }
        }
        int left=(int)(N-R);
        for(int i=0;i<left;i++){
            for(int j=0;j<C;j++){                
                poster[(int)(N-i-1)][j] = 'a';
               
            }
            for(int k=C;k<M;k++){
                poster[(int)(N-i-1)][k] = 'b';
               
            }
        }
        for(int i=0;i<N;i++){
            for(int j=0;j<M;j++){
                System.out.print(poster[i][j]);
            }
            System.out.println();
        }
      }
       
       else if(R==0 && C==0){
           for(int i=0;i<N;i++){
            for(int j=0;j<M;j++){
               
                poster[i][j]=(char)(r.nextInt('z'-'a') + 'a');
                if(j>=1){
                if(poster[i][j]==poster[i][j-1] && poster[i][j-1]!='z'){
                    poster[i][j]++;
                }
                }
            }
            
        }
         for(int i=0;i<N;i++){
            for(int j=0;j<M;j++){
                System.out.print(poster[i][j]);
            }
            System.out.println();
        }
       }
    
       
       else if(R==0){ // No rows are palindromes, 
            for(int i=0;i<N;i++){
            for(int j=0;j<M-1;j++){
                 poster[i][j] = 'a';
                 
            }
            poster[i][(int)M-1]='b';
            for(int k=C;k<M;k++){
                poster[(int)N-1][k]++;
            }
        }
        for(int i=0;i<N;i++){
            for(int j=0;j<M;j++){
                System.out.print(poster[i][j]);
            }
            System.out.println();
          }
        }
        
        else if(R==(int)N){
            if( M%2==C%2){
           for(int i=0;i<N;i++){
            for(int j=0;j<M-1;j++){
                 poster[i][j] = 'a';
        }
           }
           
           for(int k=0;k<(M-C)/2;k++){
               poster[0][k]++;
               poster[0][(int)M-k-1]++;
           }
           for(int i=0;i<N;i++){
            for(int j=0;j<M;j++){
                System.out.print(poster[i][j]);
            }
            System.out.println();
        }
        }
        
            else if( M%2==1 && C%2==0 ){
            for(int i=0;i<R;i++){
              for(int j=0;j<M;j++){
                 poster[i][j] = 'a';
                 
            }
        }
        for(int k=0;k<((M-C)/2)-1;k++){
               poster[0][k]++;
               poster[0][(int)M-k-1]++;
           }
          poster[0][(int)M/2]++; 
          for(int i=0;i<N;i++){
            for(int j=0;j<M;j++){
                System.out.print(poster[i][j]);
            }
            System.out.println();
        }
            
        
        }else{
            System.out.println("IMPOSSIBLE");
        }
        }else if(C==0){
            for(int i=0;i<M;i++){
            for(int j=0;j<N-1;j++){
                 poster2[i][j] = 'a';
                 
            }
            poster2[i][(int)N-1]='b';
            for(int k=R;k<N;k++){
                poster2[(int)M-1][k]++;
            }
        }
        
        
        for(int i=0;i<N;i++){
            for(int j=0;j<M;j++){
                System.out.print(poster2[j][i]);
            }
            System.out.println();
        }
        
        }else if(C==(int)M){ 
             
            if(N%2==R%2){
           for(int i=0;i<M;i++){
            for(int j=0;j<N;j++){
                 poster2[i][j] = 'a';
              }
           }
           
           for(int k=0;k<(N-R)/2;k++){
               poster2[0][k]++;
               poster2[0][(int)N-k-1]++;
           }
           for(int i=0;i<N;i++){
            for(int j=0;j<M;j++){
                System.out.print(poster2[j][i]);
            }
            System.out.println();
        }
        }
        
            else if( N%2==1 && R%2==1 ){
            for(int i=0;i<C;i++){
              for(int j=0;j<N;j++){
                 poster2[i][j] = 'a';
                 
            }
        }
        for(int k=0;k<((N-R));k++){
               poster2[0][k]++;
               poster2[0][(int)N-k-1]++;
           }
          poster[0][(int)N/2]++; 
          for(int i=0;i<N;i++){
            for(int j=0;j<M;j++){
                System.out.print(poster2[j][i]);
            }
            System.out.println();
        }
       
            
            }   
             else{
            System.out.println("IMPOSSIBLE");
        }
        }else{
            System.out.println("IMPOSSIBLE");
        }
        
        
    }
    static String next() throws IOException {
        while (in == null || !in.hasMoreTokens())
            in = new StringTokenizer(br.readLine());
        return in.nextToken();
    }
 
    static long readLong() throws IOException {
        return Long.parseLong(next());
    }
 
    static int readInt() throws IOException {
        return Integer.parseInt(next());
    }
 
    static double readDouble() throws IOException {
        return Double.parseDouble(next());
    }
 
    static char readChar() throws IOException {
        return next().charAt(0);
    }
 
    static String readLine() throws IOException {
        return br.readLine();
    }
}
