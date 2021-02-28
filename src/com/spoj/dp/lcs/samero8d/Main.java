package com.spoj.dp.lcs.samero8d;

import java.io.BufferedReader;
import java.io.InputStreamReader;

class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        while(true){
            int K = Integer.parseInt(br.readLine());
            if(K == 0) break;
            String s1 = br.readLine(); int m = s1.length();
            String s2 = br.readLine(); int n = s2.length();
            int[][] dp = new int[m+1][n+1];

            for(int i=0; i<=m; ++i){
                for(int j=0; j<=n; ++j){
                    if(i==0 || j==0) dp[i][j] = 0;
                    else{
                        int k = 1;
                        while(i-k >=0 && j-k >=0 && s1.charAt(i-k) == s2.charAt(j-k)){
                            if(k>=K){
                                dp[i][j] = Math.max(dp[i][j], k+dp[i-k][j-k]);
                            }
                            k++;
                        }
                        dp[i][j] = Math.max(dp[i][j], dp[i-1][j]);
                        dp[i][j] = Math.max(dp[i][j], dp[i][j-1]);
                    }
                }
            }
            System.out.println(dp[m][n]);
        }
    }

}
