package com.leetcode.backtracking.permutation.sequence;

import java.util.ArrayList;
import java.util.List;

class Solution {
    public String getPermutation(int n, int k) {
        if(n == 0){
            return "0";
        }
        String result = "";
        result = explore(0, n, k, new ArrayList<>(), result);
        return result;
    }

    private String explore(int currentIndex, int n, int k, List<Integer> partialList, String result){

        if(currentIndex == n){
            if(k == 0){
                for(int i=0; i<partialList.size(); i++){
                    result += Integer.toString(partialList.get(i));
                }
                return result;
            }
            else{
                return "";
            }
        }


        /**Choices*/
        for(int i=1; i<=n; i++){

            int aVal = i;
            if(!partialList.contains(aVal)){
                partialList.add(aVal);
                result = explore(currentIndex+1, n,k-1, partialList, result);
                if(result.length() != 0){
                    return result;
                }
                else{
                    partialList.remove(partialList.size()-1);
                }
            }
        }
        return "";
    }


    public static void main(String[] args){
        int n=3;
        int k=3;
        Solution s = new Solution();
        System.out.println(s.getPermutation(n,k));
    }
}