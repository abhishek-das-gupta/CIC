package com.leetcode.contest.weekly.avoid.flood;

import java.util.*;

class Solution {
    public int[] avoidFlood(int[] arr) {
        int n = arr.length;
        int[] ans = new int[n];
        Map<Integer,Integer> mp = new HashMap<>();
        for(int x : arr){
            if(x == 0) continue;
            mp.put(x, mp.getOrDefault(x,0)+1);
        }

        PriorityQueue<Integer> pq = new PriorityQueue<>((a,b) -> {
            if(mp.get(a) != mp.get(b)){
                return mp.get(b) - mp.get(a);
            }else{
                return mp.get(a) - mp.get(b);
            }
        });
        for(int x : mp.keySet()) {
            pq.offer(x);
        }
        System.out.println(mp.toString() + " " + pq.toString());


        Set<Integer> set = new HashSet<>();
        for(int i=0; i<n; ++i){
            if(arr[i] > 0){
                if(set.contains(arr[i]))
                    return new int[0];
                ans[i] = -1;
                set.add(arr[i]);
            }
            else{
                if(set.isEmpty()) {
                    ans[i] = 1;
                    continue;
                }
                int cur = pq.poll();
                set.remove(cur);
                mp.put(cur, mp.get(cur)-1);
                if(mp.get(cur) == 0) mp.remove(cur);
                else pq.offer(cur);
                ans[i] = cur;
            }
        }
        return ans;
    }
    public  static void main(String[] args){
        Solution sol = new Solution();
        System.out.println(Arrays.toString(sol.avoidFlood(new int[]{1,2,0,2,3,0,1})));
    }
}