package com.leetcode.two.pointer.three.sum;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {
    public static List<List<Integer>> threeSum(int[] nums){
        List<List<Integer>> res= new ArrayList<>();
        int n=nums.length;
        Arrays.sort(nums);
        for(int i=0; i<n; i++){
            if(i >0 && nums[i]==nums[i-1]){
                continue;
            }
            int start = i+1;
            int end = n-1;

            while(start < end){
                if(nums[start] + nums[end] == -nums[i]){
                    res.add(Arrays.asList(-nums[i],nums[start],nums[end]));
                    start++;
                    end--;

                    while(start < end && nums[start]==nums[start-1]){
                        start++;
                    }
                    while(start < end && nums[end] == nums[end+1]){
                        end--;
                    }
                }
                else if(nums[start] + nums[end] > -nums[i]){
                    end--;
                }
                else{
                    start++;
                }
            }
        }
        return res;
    }

    public static void main(String[] args){
        int[] nums = {-1, 0, 1, 2, -1, -4};
        System.out.println(Solution.threeSum(nums));
    }
}
