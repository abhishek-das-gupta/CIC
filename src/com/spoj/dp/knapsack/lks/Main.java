package com.spoj.dp.knapsack.lks;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] str = br.readLine().split(" ");
        int n = Integer.parseInt(str[0]);
        int m = Integer.parseInt(str[1]);
        List<int[]> vii = new ArrayList<>(m);
        for(int i=0; i<m; ++i){
            str = br.readLine().split(" ");
            int v = Integer.parseInt(str[0]);
            int w = Integer.parseInt(str[1]);
            vii.add(new int[]{v,w});
        }
        int[][] dp = new int[2][n+1];
        int i=0;
        while(i < m){
            int j=0;
            if(i % 2 != 0){
                while(j <= n) {
                    if (vii.get(i)[1] <= j) {
                        dp[1][j] = Math.max(vii.get(i)[0] + dp[0][j - vii.get(i)[1]], dp[0][j]);
                    } else {
                        dp[1][j] = dp[0][j];
                    }
                    j++;
                }
            }else{
                while(j <= n) {
                    if (vii.get(i)[1] <= j) {
                        dp[0][j] = Math.max(vii.get(i)[0] + dp[1][j - vii.get(i)[1]], dp[1][j]);
                    } else {
                        dp[0][j] = dp[1][j];
                    }
                    j++;
                }
            }
            i++;
        }
        if(i % 2 == 0)
            System.out.println(dp[1][n]);
        else
            System.out.println(dp[0][n]);
    }
}
