package com.leetcode.sort.bucket.sort.top.K.frequent.elements;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Solution {
    public static List<Integer> topKFrequent(int[] nums, int k) {
        int n = nums.length;
        List<Integer>[] bucket = new List[n+1];
        Map<Integer,Integer> mp = new HashMap<>();
        List<Integer> res = new ArrayList<>();

        for(int num : nums){
            mp.put(num, mp.getOrDefault(num,0)+1);
        }

        for(int key : mp.keySet()){
            int freq = mp.get(key);

            if(bucket[freq] == null){
                bucket[freq] = new ArrayList<Integer>();
            }
            bucket[freq].add(key);
        }
        int m = bucket.length;
//        for(int i=0; i<m; ++i){
//            System.out.println(bucket[i].toString());
//        }
        for(int i=m-1; i>=0 ; --i){
            if(bucket[i] != null){
                for(int j=0; j<bucket[i].size() && res.size() < k; ++j){
                    res.add(bucket[i].get(j));
                }
            }
        }
        return res;
    }
    public static void main(String[] args){
        int[] nums = {4,1,-1,2,-1,2,3};
        Solution.topKFrequent(nums,2);
    }
}
