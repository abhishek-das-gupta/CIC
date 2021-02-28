package com.leetcode.contest.weekly.paint.house.iii;

import java.util.*;

class Solution {
    Map<String,Integer> dp = new HashMap<>();
    public int minCost(int[] h, int[][] cost, int m, int n, int target) {
        int val = dfs(0,0,0,h,cost,m,n,target);
        return val >= 10001 ? -1 : val;
    }
    private int dfs(int cur, int nei, int prevColor, int[] h,int[][] co,int m, int n, int target){
        if(nei > target){
            return 10001;
        }
        if(cur == m){
            return nei == target ? 0 : 10001;
        }
        if(dp.containsKey(cur+"-"+nei+"-"+prevColor)){
            return dp.get(cur+"-"+nei+"-"+prevColor);
        }

        int val = 10001;
        if(h[cur] != 0){
            val = Math.min(val, dfs(cur+1,(prevColor == h[cur]? nei : nei+1),h[cur],h,co,m,n,target));
        }
        else{
            for(int i=1; i<=n; ++i){
                val = Math.min(val, co[cur][i-1] + dfs(cur+1,(prevColor == i ? nei:nei+1),i,h,co,m,n,target));
            }
        }
        dp.put(cur+"-"+nei+"-"+prevColor, val);
        return val;

    }

    public static void main(String[] args) {
        int[] h = {0,0,0,0,0};
        int[][] co = {{1,10},{10,1},{1,10},{10,1},{1,10}};
        int m = 5;
        int n = 2;
        int target = 5;

        Solution s = new Solution();
        System.out.println(s.minCost(h,co,m,n,target));
    }
}