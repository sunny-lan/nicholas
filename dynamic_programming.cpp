#include <bits/stdc++.h>

using namespace std;

int answers[138];

vector<int> coins;

int best(int value){
    if(answers[value]!=-1) // already calculated
        return answers[value];

    if(value==0)return 0;
    if(value<0) return INT_MAX;

    // get minimum over all possible combinations
    int answer = INT_MAX;
    for(int firstCoin:coins){
        answer=min(answer, 1 + best(value - firstCoin));
    }

    answers[value] = answer; // store answer to reuse later

    return answer;
}

int main(){
    memset(answers, -1, sizeof answers);

}