package com.spoj.dp.knapsack.subadiv;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class Main {
    public static void main(String[] args) throws IOException{
        int INF = 801;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        while(t-- != 0){
            String s = br.readLine();
            int o = Integer.parseInt(s.split(" ")[0]);
            int n = Integer.parseInt(s.split(" ")[1]);
            int m = Integer.parseInt(br.readLine());
            int[][] nums = new int[m][3];
            for(int i=0; i<m; ++i){
                s = br.readLine();
                nums[i][0] = Integer.parseInt(s.split(" ")[0]);
                nums[i][1] = Integer.parseInt(s.split(" ")[1]);
                nums[i][2] = Integer.parseInt(s.split(" ")[2]);
            }
            int[][][] dp = new int[m+1][o+1][n+1];
            for(int i=0; i<=m; ++i){
                for(int j=0; j<=o; ++j){
                    for(int k=0; k<=n; ++k){
                        if(j==0 && k == 0)
                            dp[i][j][k] = 0;
                        else if(i==0)
                            dp[i][j][k] = INF;
                        else
                            dp[i][j][k] = Math.min(nums[i-1][2] + dp[i-1][Math.max(0,j-nums[i-1][0])][Math.max(0,k-nums[i-1][1])],
                                    dp[i-1][j][k]);
                    }
                }
            }
            System.out.println(dp[m][o][n]);
        }
    }
}
