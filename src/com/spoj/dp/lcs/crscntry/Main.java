package com.spoj.dp.lcs.crscntry;

import java.util.*;
import java.io.*;

class Main {
    public static void main(String[] args) throws java.lang.Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        String s = null;
        int res = 0;
        int[] a = null;
        int[] b = null;
        boolean flag = true;
        while(t != 0){
            while(true){
                s = br.readLine();
                if(s.length() == 1 && Integer.parseInt(s) == 0)
                    break;
                if(flag) {
                    res = 0;
                    String[] str = s.split(" ");
                    int n = str.length;
                    a = new int[n - 1];
                    for (int i = 0; i < n - 1; ++i) {
                        a[i] = Integer.parseInt(str[i]);
                    }
                    flag = false;
                }
                else{
                    String[] str = s.split(" ");
                    int m = str.length;
                    b = new int[m-1];
                    for(int i=0; i<m-1; ++i)
                        b[i] = Integer.parseInt(str[i]);
                    //System.out.println(Arrays.toString(a) + " " + Arrays.toString(b));
                    int[][] dp = new int[a.length+1][b.length+1];
                    for(int i=0; i<=a.length; ++i){
                        for(int j=0; j<=b.length; ++j){
                            if(i==0 || j==0 ) dp[i][j] = 0;
                            else if(a[i-1] == b[j-1]) dp[i][j] = 1 + dp[i-1][j-1];
                            else dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
                        }
                    }
                    res = Math.max(res, dp[a.length][b.length]);
                }

            }
            if(Integer.parseInt(s) == 0){
                if(!flag) System.out.println(res);
                flag = true;
                t--;
            }
        }
    }
}
