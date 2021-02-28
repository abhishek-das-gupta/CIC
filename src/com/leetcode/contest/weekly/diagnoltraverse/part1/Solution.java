package com.leetcode.contest.weekly.diagnoltraverse.part1;

import java.util.Arrays;

class Solution {
    public static int[] findDiagonalOrder(int[][] nums) {
        if(nums == null || nums.length == 0 || nums[0].length == 0)
            return new int[0];
        int m = nums.length;
        int n = nums[0].length;
        int[] res = new int[m*n];
        if(m == 1){
            return nums[0];
        }else if(n == 1){
            for(int i=0; i<m; ++i)
                res[i] = nums[i][1];
            return res;
        }
        int i=0;
        int j=0;
        boolean down = false;
        int idx = 0;
        while(idx < m*n){
            res[idx++] = nums[i][j];
            if(!down && (i == 0 || j == n-1)){
                if(j < n-1){
                    j++;
                    res[idx++] = nums[i][j];
                }else if(j == n-1){
                    i++;
                    if(i < m) {
                        res[idx++] = nums[i][j];
                    }
                }
                down = true;
            }else if(down && (j == 0 || i == m-1)){
                if(j >0 && j < n-1){
                    j++;
                    res[idx++] = nums[i][j];
                }else if(j == 0){
                    i++;
                    if(i < m) {
                        res[idx++] = nums[i][j];
                    }
                }
                down = false;
            }

            if(down){
                i++;
                j--;
            }else{
                i--;
                j++;
            }
        }
        return res;

    }
    public static void main(String[] args){
        int[][] nums = {{1,2,3,4,5},{6,7,8,9,10}};
        System.out.println(Arrays.toString(Solution.findDiagonalOrder(nums)));
    }
}