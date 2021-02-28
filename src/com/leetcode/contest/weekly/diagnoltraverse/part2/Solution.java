package com.leetcode.contest.weekly.diagnoltraverse.part2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution {
    public static int[] findDiagonalOrder(List<List<Integer>> nums) {
        int n = nums.size();
        int m = nums.get(0).size();
        List<Integer> res = new ArrayList<>();
        for (int i = 0; i < n; ++i) {
            int j = i;
            int k = 0;
            while (j >= 0 && k < m) {
                List<Integer> curr = nums.get(j);
                if (k >= curr.size()) {
                    j--;k++;
                    continue;
                }
                int val = curr.get(k);
                res.add(val);
                j--;
                k++;
            }
        }
        List<Integer> last = nums.get(n - 1);
        for(int i = 1; i < last.size(); ++i) {
            int j = n-1;
            int k = i;
            while (j >= 0) {
                List<Integer> curr = nums.get(j);
                if (k >= curr.size()){
                    j--;k++;
                    continue;
                }
                int val = curr.get(k);
                res.add(val);
                j--;
                k++;
            }
        }
        int[] arr = new int[res.size()];
        for (int i = 0; i < res.size(); ++i)
            arr[i] = res.get(i);
        return arr;

    }
    public static void main(String[] args){
        List<List<Integer>> nums = new ArrayList<>();
//        nums.add(new ArrayList<>(Arrays.asList(1,2,3,4,5)));
//        nums.add(new ArrayList<>(Arrays.asList(6,7)));
//        nums.add(new ArrayList<>(Arrays.asList(8)));
//        nums.add(new ArrayList<>(Arrays.asList(9,10,11)));
//        nums.add(new ArrayList<>(Arrays.asList(12,13,14,15,16)));

        nums.add(new ArrayList<>(Arrays.asList(6)));
        nums.add(new ArrayList<>(Arrays.asList(8)));
        nums.add(new ArrayList<>(Arrays.asList(6,1,6,16)));
        System.out.println(Arrays.toString(Solution.findDiagonalOrder(nums)));
    }
}