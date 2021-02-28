package com.spoj.dp.knapsack.party;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        while(true) {
            String s = br.readLine();
            String[] str = s.split(" ");
            int n = Integer.parseInt(str[0]);
            int m = Integer.parseInt(str[1]);
            if(n==0 && m ==0) break;
            int[] fun = new int[m];
            int[] cost = new int[m];
            for (int i = 0; i < m; ++i) {
                String s1 = br.readLine();
                cost[i] = Integer.parseInt(s1.split(" ")[0]);
                fun[i] = Integer.parseInt(s1.split(" ")[1]);
            }
            int[][] dp = new int[m + 1][n + 1];
            for (int i = 0; i <= m; ++i) {
                for (int j = 0; j <= n; ++j) {
                    if (i == 0)
                        dp[i][j] = 0;
                    else if (j == 0)
                        dp[i][j] = 0;
                    else if (j - cost[i - 1] < 0)
                        dp[i][j] = dp[i - 1][j];
                    else
                        dp[i][j] = Math.max(fun[i - 1] + dp[i - 1][j - cost[i - 1]], dp[i - 1][j]);
                }
            }
            int fun1 = dp[m][n];
            int fee = 0;
            for(int i=0; i<=n; ++i){
                if(dp[m][i] == fun1){
                    fee = i;
                    break;
                }
            }
            System.out.println(fee + " " + fun1);
        }
    }
}
