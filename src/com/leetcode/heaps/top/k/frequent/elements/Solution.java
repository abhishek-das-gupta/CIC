package com.leetcode.heaps.top.k.frequent.elements;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Solution {
    public List<Integer> topKFrequent(int[] nums, int k) {
        List<Integer> listOfKFrequentElements = new ArrayList<>(k);
        if(nums == null || nums.length == 0){
            return listOfKFrequentElements;
        }
        Map<Integer,Integer> freq = new HashMap<>();
        List<List<Integer>> bucket = new ArrayList<>();
        for(int i=0; i<=nums.length; i++){
            bucket.add(i,null);
        }

        for(int num : nums){
            int count  = freq.getOrDefault(num, 0);
            freq.put(num, count+1);
        }

        for(Map.Entry<Integer,Integer> entry : freq.entrySet()){
            if(bucket.get(entry.getValue()) == null){
                List<Integer> sameFrequencyList = new ArrayList<>();
                sameFrequencyList.add(entry.getKey());

                bucket.set(entry.getValue(), new ArrayList<>(sameFrequencyList));
            }
            else{
                List<Integer> sameFrequencyList = bucket.get(entry.getValue());
                sameFrequencyList.add(entry.getKey());
            }
        }

        System.out.println(bucket.toString());


         for(int i=bucket.size()-1; i>0 && listOfKFrequentElements.size() <k; i--){
             if(bucket.get(i) != null){
                 listOfKFrequentElements.addAll(bucket.get(i));
             }

         }

        return listOfKFrequentElements;


    }

    public static void main(String[] args){
        Solution sol = new Solution();
        int[] nums = {1,1,1,2,2,3};
        int k = 2;
        System.out.println(sol.topKFrequent(nums,k));
    }

}
