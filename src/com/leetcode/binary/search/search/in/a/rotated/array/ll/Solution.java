package com.leetcode.binary.search.search.in.a.rotated.array.ll;

class Solution {
    public static boolean search(int[] nums, int target) {
        if(nums==null || nums.length==0){
            return false;
        }
        int l = 0;
        int r = nums.length-1;

        while(l <= r){
            int mid = l + (r-l)/2;
            if(nums[mid] == target){
                return true;
            }
            if(nums[l] == nums[mid] && nums[mid] == nums[r]){
                ++l;
                --r;
            }
            else if(nums[mid] > nums[l]){
                if(nums[l] <= target && target < nums[mid]){
                    r = mid-1;
                }
                else{
                    l = mid+1;
                }
            }
            else{
                if(nums[mid] < target && target <= nums[r]){
                    l = mid+1;
                }
                else{
                    r = mid-1;
                }
            }
        }
        return false;
    }

    public static void main(String[] args){
        int[] nums = {2,5,6,0,0,1,2};
        int target = 6;
        System.out.println(Solution.search(nums,target));
    }
}