#include <bits/stdc++.h>

using namespace std;

typedef long long ll;
using pii=pair<int,int>;

struct edge{
    int u;
    int v;
    int l,c;
};


vector<edge> edges;
vector<vector<edge>> adj;

ll dijkstra(int src, int dst){
    int n=adj.size();

    set<pair<ll, int>> du;
    du.insert({0L, src});
    vector<ll> best(n, 1e13L);
    best[src] = 0;

    vector<bool> done(n, false);

    while(!du.empty()){
        auto elem = du.begin();
        ll dist = elem->first;
        int node = elem->second;
        du.erase(elem);
        
        if(done[node]) continue;

        done[node] = true;

        if(node == dst)
            break;

        for(edge& neigh : adj[node]) {
            if(done[neigh.v]) continue;

            ll cost = neigh.l + dist;
            if(cost < best[neigh.v]){
                du.erase({best[neigh.v], neigh.v});
                best[neigh.v] = cost;
                du.insert({best[neigh.v], neigh.v});
            }
        }
    }

    return best[dst];
}

bool cmp(const edge&a, const edge&b){
    pii a_,b_;
    a_={a.l,a.c};
    b_={b.l,b.c};
    return a_<b_;
}

int main(){
    int n,m;cin>>n>>m;
    adj = vector<vector<edge>>(n);

    for(int i=0;i<m;i++){
        
        
        edge e;
        cin>>e.u>>e.v>>e.l>>e.c;
        e.u--;
        e.v--;

        edges.push_back(e);

    }

    sort(edges.begin(), edges.end(), cmp);
    vector<edge> tmp;
    set<pii> bestEdge;
    for(edge e:edges){
        pii sortedEdge= {e.u,e.v};
        if(sortedEdge.first>sortedEdge.second)swap(sortedEdge.first, sortedEdge.second);
        if(bestEdge.count(sortedEdge)>0)continue;;
        bestEdge.insert(sortedEdge);
        tmp.push_back(e);
    }
    edges=tmp;
        


    ll total = 0;
    for(edge e:edges){
        auto dist = dijkstra(e.u, e.v);
        if(dist > e.l) {
            total += e.c;
            adj[e.u].push_back(e);
            swap(e.u, e.v);
            adj[e.u].push_back(e);
        }
    }

    cout << total << endl;
}