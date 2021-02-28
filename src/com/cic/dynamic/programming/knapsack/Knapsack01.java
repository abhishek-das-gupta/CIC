package com.cic.dynamic.programming.knapsack;

public class Knapsack01 {
    public static int bottomUp(int[] values, int[] weights, int maxWeight){
        int[][] dp = new int[values.length+1][maxWeight+1];

        for(int i=0; i<=maxWeight; i++){
            dp[0][i] = 0;
        }

        for(int i=0; i<=values.length; i++){
            dp[i][0] = 0;
        }

        for(int object=1; object<=values.length; object++){
            for(int weight=1; weight<=maxWeight; weight++){
                int withoutThisObject = dp[object-1][weight];
                int withThisObject = weight - weights[object-1] < 0 ? 0 : dp[object-1][weight-weights[object-1]] + values[object-1];
                dp[object][weight] = Math.max(withoutThisObject, withThisObject);
            }
        }
        return dp[values.length][maxWeight];
    }


    public static void main(String args[]) {
        int[] values = new int[]{60,50,70,30};
        int[] weights = new int[]{5,3,4,2};

        int maxWeight = 5;

        System.out.println(bottomUp(values,weights,maxWeight));
    }
}
