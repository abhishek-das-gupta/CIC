package com.spoj.dp.lcs.adfruits;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s;
        while((s = br.readLine()) != null){
            String s1 = s.split(" ")[0];
            String s2 = s.split(" ")[1];

            int m = s1.length();
            int n = s2.length();

            int[][] dp = new int[m+1][n+1];
            for(int i=0; i<=m; ++i){
                for(int j=0; j<=n; ++j){
                    if(i==0) dp[i][j] = j;
                    else if(j==0) dp[i][j] = i;
                    else if(s1.charAt(i-1) == s2.charAt(j-1)) dp[i][j] = 1+dp[i-1][j-1];
                    else dp[i][j] = 1 + Math.min(dp[i-1][j], dp[i][j-1]);
                }
            }
            int l = dp[m][n];
            int i=m,j=n;
            StringBuilder sb = new StringBuilder();
            while(i > 0 && j > 0){
                if(s1.charAt(i-1) == s2.charAt(j-1)){
                    sb.insert(0,s1.charAt(i-1));
                    i--;j--;
                }
                else if(dp[i-1][j] < dp[i][j-1]){
                    sb.insert(0,s1.charAt(i-1));
                    i--;
                }
                else{
                    sb.insert(0, s2.charAt(j-1));
                    j--;
                }
            }
            while(i > 0){
                sb.insert(0,s1.charAt(i-1));
                i--;
            }
            while(j > 0){
                sb.insert(0,s2.charAt(j-1));
                j--;
            }
            System.out.println(sb.toString());
        }
    }
}
