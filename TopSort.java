import java.io.*;
import java.util.*;
public class TopSort {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer in;
    
    public static void main(String[] args) throws IOException {
    System.out.println("Number of courses?");
    int N=readInt();
    
    ArrayList<Integer>[]edges=new ArrayList[N+1];
    for(int i=1;i<=N;i++)edges[i]=new ArrayList<>();
    int[]ind=new int[N+1];
    for(int i=1;i<=N;i++){
        System.out.println("How many prerequisites for this course?");
        int x=readInt();
        if(x!=0) System.out.print("Enter in the prerequisites:");
        
        for(int j=0;j<x;j++){
            
            int y=readInt();
            edges[y].add(i);
            
        }
        ind[i]=x;
    }
    Queue<Integer>q=new ArrayDeque<>();
    int []courses=new int[N];
    
    for(int i=1;i<=N;i++)if(ind[i]==0)q.add(i);
    int a=0;
    while(!q.isEmpty()){
        int cur=q.poll();
        courses[a]=cur;
        a++;
        for(int node:edges[cur]){
            ind[node]--;
            if(ind[node]==0)q.add(node);
        }
        
    }
    
    
    System.out.println("How many prompts do you have?");
    int prompt=readInt();
   
    for(int i=0;i<prompt;i++){
        int course1=readInt();
        int course2=readInt();
        int j=-1;
        int compare=-1;
        int finalc=0;
        int finalj=0;
         boolean psb=false;
        while(psb==false){
            if(course1==courses[0])psb=true;
            
             compare++;
            j++;
            if (courses[j]==course1){
                finalj=j;
                
                psb=true;
            }
            if(courses[j]==course2){
                finalc=compare;
                
                psb=true;
            }
            
        }
        if(course1 == courses[0]){
            System.out.println("It is possible");
        }
        else if(finalj>finalc){
            System.out.println("It is possible");
        }else{
            System.out.println("It is not possible");
        }
        
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