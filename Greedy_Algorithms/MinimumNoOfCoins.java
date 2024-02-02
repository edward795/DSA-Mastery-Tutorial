package Greedy_Algorithms;

import java.util.Arrays;
import java.util.Collections;

public class MinimumNoOfCoins{
    public static void main(String[] args) {
        Integer[] coins=new Integer[]{10,5,2,1};
        System.out.println("Minimum no of coins of the above denomination required to give the above amount is : "+minCoins(coins, 4, 50));
    }

    //TC : O(n)
    static int minCoins(Integer[] coins,int n,int amount){
        Arrays.sort(coins,Collections.reverseOrder());
        int res=0;
        for(int i=0;i<n;i++){
            if(coins[i]<=amount){
                int c=(int)Math.floor(amount/coins[i]);
                res+=c;
                amount-=c*coins[i];
            }

            if(amount==0) break;
        }

        return res;
    }
}