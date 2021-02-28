package com.atcoder.contest167.c;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static int res = Integer.MAX_VALUE;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] str = br.readLine().split(" ");
        int n = Integer.parseInt(str[0]);
        int m = Integer.parseInt(str[1]);
        int x = Integer.parseInt(str[2]);
        int[] nums = new int[m];
        int[][] books = new int[n][m+1];
        for(int i=0; i<n; ++i) {
            str = br.readLine().split(" ");
            for (int j = 0; j <= m; j++) {
                books[i][j] = Integer.parseInt(str[j]);
            }
        }
        dfs(0,0,nums,books,n,m,x);
        if(res == 2147483647){
            System.out.println(-1);
        }else{
            System.out.println(res);
        }
    }
    public static void dfs(int idx, int cost,int[] nums, int[][] books, int n, int m, int x){
        if(idx == n){
            boolean ok = true;
            for(int i=0; i<m; ++i){
                if(nums[i] < x){
                    ok =false;
                    break;
                }
            }
            if(ok){
               res = Math.min(res, cost);
            }
            return;
        }
        cost += books[idx][0];
        for(int i=1; i<=m; ++i){
            nums[i-1] += books[idx][i];
        }
        dfs(idx+1,cost,nums,books,n,m,x);
        cost -= books[idx][0];
        for(int i=1; i<=m; ++i){
            nums[i-1] -= books[idx][i];
        }
        dfs(idx+1,cost,nums,books,n,m,x);
    }
}
