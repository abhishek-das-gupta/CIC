package com.leetcode.sliding.window.minimum.size.subarray.sum;

public class Solution {
    public int minSubArrayLen(int s, int[] nums) {
        if(nums == null || nums.length == 0){
            return 0;
        }

        int slow = 0;
        int fast = 0;

        int windowSum = 0;

        int len= Integer.MAX_VALUE;
        int minSum = Integer.MAX_VALUE;

        while(fast < nums.length){
            windowSum += nums[fast];
            //System.out.println(windowSum);

            while(windowSum >= s){
                if(len > fast-slow+1){
                    len = fast-slow+1;
                    minSum = windowSum;
                }

                windowSum -= nums[slow];
                //System.out.println(windowSum);
                slow++;
            }
            fast++;
        }
        //System.out.println(fast + " " + slow + " " + minSum);

        return minSum >= s ? len : 0;
    }

    public static void main(String[] args){
        int s = 15;
        int[] nums = {5,1,3,5,10,7,4,9,2,8};

        Solution sol = new Solution();
        System.out.println(sol.minSubArrayLen(s,nums));

    }
}
