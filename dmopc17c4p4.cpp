#include <bits/stdc++.h>
using namespace std;

int main(){
    int n;cin>>n;
    vector<int> not_robbed;
    for(int i=1;i<=n;i++)
        not_robbed.push_back(i);
    
    vector<int> blocked;
    vector<int> rob_order;
    for(int i=0;i<n;i++){
        int cop;cin>> cop;
        blocked.push_back(cop);

        if(not_robbed.back() != cop){
            rob_order.push_back(not_robbed.back());
            not_robbed.pop_back();
        }else if(not_robbed.size()>=2 && not_robbed[not_robbed.size() - 2] != cop) {
            rob_order.push_back(not_robbed[not_robbed.size() - 2]);
            not_robbed.erase(not_robbed.end() - 2);
        }
    }

    if(!not_robbed.empty()){
        int last = not_robbed.back();
        rob_order.push_back(last);
                
        for(int i=0;i<n;i++){
            if(blocked[i] != last){
                swap(rob_order.back(), rob_order[i]);
                break;
            }
        }

        if(rob_order.back()==last){
            cout << -1 << endl;
            return 0;
        }
    }

    for(int bank:rob_order)
        cout << bank <<" ";
    cout << endl;
}