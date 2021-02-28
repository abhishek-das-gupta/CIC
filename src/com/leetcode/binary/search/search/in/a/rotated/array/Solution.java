package com.leetcode.binary.search.search.in.a.rotated.array;

class Solution {
    public int search(int[] nums, int target) {
        if(nums == null || nums.length==0){
            return -1;
        }
        int l =0;
        int r = nums.length-1;
        while(l < r){
            int mid = l + (r-l)/2;
            if(nums[mid] > nums[r]){
                l = mid+1;
            }
            else{
                r = mid;
            }
        }
        int minDex = l;
        l = 0;
        r = nums.length-1;
        if(nums[minDex] >= target && target <= nums[r]){
            l = minDex;
        }
        else{
            r = minDex-1;
        }

        while(l <= r){
            int mid = l + (r-l)/2;
            if(nums[mid] == target){
                return mid;
            }
            else if(nums[mid] > target){
                r = mid-1;
            }
            else{
                l = mid+1;
            }
        }
        return -1;

    }

    public static void main(String[] args){
        int[] nums = {4,5,6,7,0,1,2};
        Solution s = new Solution();
        System.out.println(s.search(nums,0));
    }

}