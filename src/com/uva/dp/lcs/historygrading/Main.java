package com.uva.dp.lcs.historygrading;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s;
        int[] s1 = null;
        int n = 0;
        while(true){
            s = br.readLine();
            if(s == null) break;
            if(s.length() <= 2){
                n = Integer.parseInt(s);
                s1 = new int[n];
                String[] str = br.readLine().split(" ");
                Map<Integer,Integer> rank1 = new HashMap<>();
                for(int i=0; i<n; i++) {
                    rank1.put(i+1, Integer.parseInt(str[i])-1);
                }
                for(int i=1; i<=n; ++i){
                    s1[rank1.get(i)] = i;
                }
            }
            else{
                int[] s2 = new int[n];
                String[] str = s.split(" ");
                Map<Integer,Integer> rank2 = new HashMap<>();
                for(int i=0; i<n; i++){
                    rank2.put(i+1, Integer.parseInt(str[i])-1);
                }
                for(int i=1; i<=n; ++i)
                    s2[rank2.get(i)] = i;
                int[][] dp = new int[n+1][n+1];
                for(int i=0; i<=n; ++i){
                    for(int j=0; j<=n; ++j){
                        if(i==0 || j==0) dp[i][j] = 0;
                        else if(s1[i-1] == s2[j-1]) dp[i][j] = 1 + dp[i-1][j-1];
                        else dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
                    }
                }
                System.out.println(dp[n][n]);
            }
        }
        
    }
}
