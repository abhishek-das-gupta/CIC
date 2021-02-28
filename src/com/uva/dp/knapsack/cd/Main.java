package com.uva.dp.knapsack.cd;

import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s;
        while((s = br.readLine()) != null){
            String[] str = s.split(" ");
            int n = Integer.parseInt(str[0]);
            int m = Integer.parseInt(str[1]);
            int[] nums = new int[m];
            for(int i=0; i<m; ++i)
                nums[i] = Integer.parseInt(str[i+2]);
            int[][] dp = new int[m+1][n+1];
            for(int i=0; i<=m; ++i){
                for(int j=0; j<=n; ++j){
                    if(i==0)
                        dp[i][j] = j;
                    else if(j==0)
                        dp[i][j] = 0;
                    else
                        dp[i][j] = Math.min(j-nums[i-1] >=0 ? dp[i-1][j-nums[i-1]]: n+1, dp[i-1][j]);
                }
            }
            int i=m,j=n,sum=0;
            List<Integer> v = new ArrayList<>();
            while(i >0 && j>0){
                if(j-nums[i-1] >=0 && dp[i-1][j-nums[i-1]] <= dp[i-1][j]){
                    sum += nums[i-1];
                    v.add(0, nums[i-1]);
                    j -= nums[i-1];
                    i--;
                }else{
                    i--;
                }
            }
            for(int x : v)
                System.out.print(x +" ");
            System.out.println("sum:"+sum);
        }
    }
}
