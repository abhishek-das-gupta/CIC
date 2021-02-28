package com.uva.dp.knapsack.luggage;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());

        while(t-- != 0){
            int S = 0;
            String[] str = br.readLine().split(" ");
            List<Integer> v = new ArrayList<>();
            for(int i=0; i<str.length; ++i) {
                v.add(Integer.parseInt(str[i]));
                S += v.get(v.size()-1);
            }
            int m = v.size();
            int[][] dp = new int[m+1][S+1];
            for(int i=0; i<=m; ++i){
                for(int j=0; j<=S/2; ++j){
                    if(i==0)
                        dp[i][j] = 0;
                    else if(j==0)
                        dp[i][j] = 0;
                    else
                        dp[i][j] = Math.max(j-v.get(i-1) >= 0? v.get(i-1)+dp[i-1][j-v.get(i-1)] : 0, dp[i-1][j]);
                }
            }
            int diff = S - 2*dp[m][S/2];
            if(diff == 0){
                System.out.println("YES");
            }else{
                System.out.println("NO");
            }
        }
    }
}
