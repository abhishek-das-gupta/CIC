package com.leetcode.contest.weekly.prob5454;

import java.util.*;

class Solution {
    public static int findLeastNumOfUniqueInts(int[] arr, int k) {
        Map<Integer,Integer> mp = new HashMap<>();
        Set<Integer> set = new HashSet<>();
        for(int x : arr) {
            mp.put(x, mp.getOrDefault(x,0)+1);
        }
        set  = mp.keySet();
        PriorityQueue<Integer> pq = new PriorityQueue<>((a,b) -> mp.get(a)-mp.get(b));

        for(int key : mp.keySet()) pq.offer(key);

        System.out.println(pq.toString() + " " + set.toString() + " "+ k) ;
        while(!pq.isEmpty() && k > 0){
            int cur = pq.poll();
            if(mp.get(cur) <= k) {
                k -= mp.get(cur);
                mp.remove(cur);
                set.remove(cur);
            }
            else{
                System.out.println(mp.containsKey(cur));
                mp.put(cur, mp.get(cur)-k);
                pq.offer(cur);
                k = 0;
            }
            System.out.println(pq.toString() + " " + set.toString() + " " + k);
        }
        return set.size();
    }

    public static void main(String[] args) {
        int[] arr = {4,3,1,1,3,3,2};
        int k =3;
        Solution.findLeastNumOfUniqueInts(arr,k);
    }
}