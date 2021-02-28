package com.leetcode.arrays.next.permutation;

public class Solution {
    public static void nextPermutation(int[] nums){
        int n = nums.length;
        if(n==1){
            return;
        }
        if(n==2){
            if(nums[0] == nums[1]){
                return;
            }
        }

        int i = n-1;
        int j = i-1;

        while(j>=0 && nums[j] >= nums[i]){
            j--;i--;
        }
        if(j<0){
            reverse(0,nums);
            return;
        }
        int nextDex = -1;
        for(int k=n-1; k>j; k--){
            if(nums[k] > nums[j]){
                nextDex = k;
                break;
            }
        }
        int temp = nums[nextDex];
        nums[nextDex] = nums[j];
        nums[j] = temp;

        reverse(i,nums);

    }
    private static void reverse(int l, int[] nums){
        int r = nums.length-1;
        while(l < r){
            int temp = nums[l];
            nums[l++] = nums[r];
            nums[r--] = temp;
        }
    }

    public static void main(String[] args){
        int[] nums = {5,1,1};
        Solution.nextPermutation(nums);
    }
}
