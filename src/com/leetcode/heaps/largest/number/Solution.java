package com.leetcode.heaps.largest.number;

import java.util.*;

public class Solution {
    public String largestNumber(int[] nums) {
        if (nums == null || nums.length == 0) return "";
        PriorityQueue<String> pq = new PriorityQueue<>((a, b) -> {
            int n = a.length();
            int m = b.length();
            int i = 0;
            while (i < Math.min(m, n) && a.charAt(i) == b.charAt(i)) i++;
            if (i == Math.min(m, n)) {
                if (m == n) return b.charAt(i - 1) - a.charAt(i - 1);
                if (i == n) return b.charAt(i) - a.charAt(n - 1);
                else return b.charAt(m - 1) - a.charAt(i);
            } else {
                return b.charAt(i) - a.charAt(i);
            }
        });
        for (int x : nums) pq.offer(Integer.toString(x));
        System.out.println(pq.toString());  
        StringBuilder sb = new StringBuilder();
        while (!pq.isEmpty()) sb.append(pq.poll());
        return sb.toString();
    }

    public static void main(String[] args) {
        int[] nums = {1, 1, 1};
        Solution s = new Solution();
        System.out.println(s.largestNumber(nums));
    }
}
