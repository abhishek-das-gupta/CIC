package com.leetcode.two.pointer.three.sum.closest;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution {
    public static int threeSumClosest(int[] nums, int target) {
        int diff = Integer.MAX_VALUE;
        int sum = 0;
        int n = nums.length;
        Arrays.sort(nums);

        for(int i=0; i<n-1; i++){
            if(i>0 && nums[i]==nums[i-1]){
                continue;
            }
            int start = i+1;
            int end = n-1;

            while(start < end){
                int currSum = nums[start] + nums[end] + nums[i];
                int currDiff = Math.abs(target-currSum);

                if(diff > currDiff){
                    diff = currDiff;
                    sum = currSum;
                }

                if(currSum == target){
                    return target;
                }
                else if(currSum > target){
                    end--;
                }
                else{
                    start++;
                }
            }

        }
        return sum;
    }
    public static void main(String[] args){
        int[] nums = {-1, 2, 1, -4};
        System.out.println(Solution.threeSumClosest(nums,1));
    }
}