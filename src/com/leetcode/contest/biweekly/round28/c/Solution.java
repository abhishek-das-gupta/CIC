package com.leetcode.contest.biweekly.round28.c;

import java.util.Arrays;

class Solution {
    public static int minSumOfLengths(int[] a, int target) {
        int n = a.length;
        int[] cum = new int[n+1];
        for(int i = 0;i < n;i++)cum[i+1] = cum[i] + a[i];
        int t = 0;
        int[][] all = new int[n][];
        int p = 0;
        for(int i = 0;i < n;i++){
            while(t < n && cum[t] - cum[i] < target)t++;
            if(cum[t] - cum[i] == target){
                all[p++] = new int[]{i, t};
            }
        }
        all = Arrays.copyOf(all, p);

        int q = p-1;
        int minlen = 99999999;
        int ans = 99999999;
        for(int i = p-1;i >= 0;i--){
            while(all[i][1] <= all[q][0]){
                minlen = Math.min(minlen, all[q][1] - all[q][0]);
                q--;
            }
            ans = Math.min(ans, all[i][1] - all[i][0] + minlen);
        }
        if(ans <= n){
            return ans;
        }else{
            return -1;
        }
    }

    public static void main(String[] args) {
        int[] arr = {3,2,2,4,3};
        int target = 3;
        System.out.println(Solution.minSumOfLengths(arr,target));
    }
}