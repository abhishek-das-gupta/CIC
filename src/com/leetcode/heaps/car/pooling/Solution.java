package com.leetcode.heaps.car.pooling;

import java.util.*;

public class Solution {
    public boolean carPooling(int[][] trips, int capacity) {
        if(trips == null || trips.length == 0) return false;
        int n = trips.length;
        Arrays.sort(trips, (int[] a, int[] b) -> a[1] - b[1]);
        PriorityQueue<int[]> pq = new PriorityQueue<>((int[] a, int[] b) -> a[1]-b[1]);
        for(int i=0; i < n; ++i) {
            int cap = trips[i][0], low = trips[i][1], high = trips[i][2];
            while(capacity - cap < 0) {
                if(pq.isEmpty()) return false;
                while (!pq.isEmpty()) {
                    int[] pair = pq.peek();
                    if (pair[1] > low) break;
                    capacity += pair[0];
                    pq.poll();
                }
                if (capacity - cap < 0) return false;
            }
            capacity -= cap;
            pq.offer(new int[]{cap, high});
        }
        return capacity >= 0;
    }

    public static void main(String[] args) {
        int[][] trips = {{3,2,7}, {3,7,9}, {8,3,9}};
        int capacity = 11;
        Solution s = new Solution();
        System.out.println(s.carPooling(trips, capacity));
    }
}
