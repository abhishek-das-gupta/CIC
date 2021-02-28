package com.leetcode.contest.weekly.string.matching.in.an.array;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

class Solution {
    public static List<String> stringMatching(String[] words) {
        int n = words.length;
        List<String> res= new ArrayList<>();
        Set<String> set = new HashSet<>();
        for(int i=0; i<n; ++i){
            String s1 = words[i];
            for(int j=0; j<n; ++j){
                if(j==i) continue;
                String s2 = words[j];
                if(s1.length() >= s2.length() && !set.contains(s2) && s1.contains(s2)){
                    set.add(s2);
                }
            }
        }
        res.addAll(set);
        return res;
    }
    public static void main(String[] args){
        String[] words = {"mass","as","hero","superhero"};
        System.out.println(Solution.stringMatching(words));
    }
}