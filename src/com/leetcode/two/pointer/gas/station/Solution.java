package com.leetcode.two.pointer.gas.station;

public class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int n = gas.length;
        for (int i = 0; i < n; ++i) {
            int j = (i + 1) % n;
            int tank = gas[i];
            while (true) {
                int idx = (j - 1 + n) % n;
                tank -=cost[idx];
                if (tank < 0) {
                    break;
                }
                if (j == i) return i;
                tank += gas[j];
                j = (j + 1) % n;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] gas = {1,2,3,4,5};
        int[] cost = {3,4,5,1,2};
        Solution s = new Solution();
        System.out.println(s.canCompleteCircuit(gas, cost));
    }


}
