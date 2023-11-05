#include <bits/stdc++.h>

using namespace std;

typedef long long ll;
using pii=pair<int,int>;
using pll=pair<ll,ll>;

vector<pll> intervals;

void gen_intervals(ll a, ll b, int depth){
    ll len=b-a;

    if(len<=1 || depth==0)
    {
        intervals.push_back({a,b});
        return;
    }

    ll sublen=len/3;
    gen_intervals(a, a+sublen, depth-1);
    gen_intervals(b-sublen, b, depth-1);
}

bool valid(ll a, ll b, ll x){
    
    ll len=b-a;
    if(len==1)return true;

    ll sublen=len/3;
    ll mid1=a+sublen, mid2 = b-sublen;

    if(x<=mid1)return valid(a, mid1, x);
    if(x>=mid2)return valid(mid2, b, x);
    return false;
}

int main(){
    ll n; cin >>n;
    ll m=1;
    int j=0;
    ll step=n;
    while(step%3==0){
        j++;
        step/=3;
        m*=3;
    }
    int k=j-1;

    gen_intervals(0, m, 16);

    //check intervals
    for(pll interval :intervals){
        printf("%ld %ld\n",interval);
        for(ll i=interval.first;i<=interval.second;i++){
            if(valid(0,m,i))
                cout << i*step << endl;
        }
    }
}