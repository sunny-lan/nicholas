#include <bits/stdc++.h>

using namespace std;

int main() {
    int n,m,r,c;cin>>n>>m>>r>>c;
    
    
    
    if(n==r && m==c){
        string s(m, 'a');
        for(int i=0;i<r;i++)
        cout << s<<endl;
    }else if(r<=n-1 &&m>1  && c<=m-1 &&n>1){
        
        cout << 'c' << string(m-c-1, 'b') << string(c, 'a') << endl;
        
        
        for(int i=1;i<n-r;i++){
            cout << 'b' << string(m-1, 'a') <<endl;
        }
        
        for(int i=0;i<r;i++)
            cout << string(m,'a')<<endl;
            
    }else if(r==n && (m%2==1 || c%2==0) && n>1){
        for(int i=0;i<n-1;i++)
            cout << string(m, 'a') <<endl;
        
        cout << string(c/2, 'a') 
        << string(m/2 - c/2, 'b') ;
        
        if(m%2==1)
            cout <<( (c%2==1)?'a':'b' );
            
        cout << string(m/2 - c/2, 'b') 
        << string(c/2, 'a') <<endl;
    }else if(m==c && (n%2==1 || r%2==0) && m>1){
        
        for(int i=0;i<r/2;i++)
            cout << string(m, 'a')  << endl;
            
        for(int i=0;i<n/2 - r/2;i++)
            cout << string(m-1, 'a') << 'b' << endl;
            
        if(n%2==1)
        cout << string(m-1, 'a') << ((r%2==1)?'a':'b' ) << endl;
        
        for(int i=0;i<n/2 - r/2;i++)
            cout << string(m-1, 'a') << 'b' << endl;
            
        for(int i=0;i<r/2;i++)
            cout << string(m, 'a')  << endl;
    }else{
        cout << "IMPOSSIBLE" <<endl;
    }
    return 0;
}
