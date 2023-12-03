public class DisjointSet {
    int N=1000;
    int[] P=new int[N];

    void init(){
        for(int i=0;i<N;i++)
            P[i]=i;
    }

    int find(int i){
        if(P[i]==i) return i;
        P[i] = find(P[i]); // Shortcut
        return P[i];
    }

    void join(int x, int y){
        P[find(x)]=find(y);
    }

    boolean is_connected(int x, int y){
        return find(x)==find(y);
    }
}
