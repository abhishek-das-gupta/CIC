package com.spoj.dp.lcs.ioiopalin;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        String s = br.readLine();
        int[][] dp = new int[n+1][n+1];
        for(int i=0; i<=n; ++i){
            for(int j=0; j<=n; j++){
                if(i==0 || j==0) dp[i][j] = 0;
                else if(s.charAt(i-1) == s.charAt(n-j)) dp[i][j] = 1 + dp[i-1][j-1];
                else dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
            }
        }
        System.out.println(n-dp[n][n]);
    }
}
