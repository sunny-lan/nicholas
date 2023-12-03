import java.util.function.*;

public class BinarySearch {
    public static int lower_bound(int N, Predicate<Integer> function){
        int lo=0;
        int hi=N;
        while(lo<hi){
            int guess=(lo+hi)/2;
            if(function.test(guess)==true)
                hi=guess;
            else
                lo=guess+1;
        }

        return lo;
    }

    public static void main(String[] args) {
        // Search for first Integer X within [0, 14] that X*X>=14
        int result = lower_bound(14, (x)-> x*x>=14);

        double x = 14;
        double lo =0, hi=x;
        double ans;
        //1/(2^32)
        for(int i=0;i<32;i++){
            double guess = (hi+lo)/2.0;
            if(guess*guess==x) {
                ans=guess;
                break;
                // 7*7 > 14
            }else if(guess*guess>x){
                // hi = 7 lo = 0
                hi=guess;
            }else{
                lo=guess;
            }
            
        }
    }

    // HW:
    // 1) https://dmoj.ca/problem/dmopc17c4p4
    // 2) https://dmoj.ca/problem/ds2
    // 3) Binary search: We 2 sticks of length N and M
    //    Find the maximum square we can make by cutting these sticks up (only integer length)
    //    4 4
    //    2 2 2 2 -> size 2
    // 4) Dynamic programming: How many strings of length N can be make
    //    Using letters A-Z where we cannot have 3 same letters in a row
    // 5) https://dmoj.ca/problem/year2018p3
}
