package com.leetcode.contest.biweekly.kthLexographicalStringOfAllHappyNumbers;

class Solution {
    char[] arr = {'a','b','c'};
    int K = 0;
    String res = "";
    public String getHappyString(int n, int k) {
        K = k ;
        return dfs(new StringBuilder(""),0,n) ? res : "";
    }
    private boolean dfs(StringBuilder sb, int curr,int n){
        if(curr == n){
            K--;
            if(K==0){
                res = sb.toString();
                return true;
            }else{
                return false;
            }
        }

        for(int j=0; j<3; ++j){
            if(curr >0 && sb.charAt(sb.length()-1) == arr[j])
                continue;
            sb.append(arr[j]);
            if(dfs(sb,curr+1,n))
                return true;
            sb.deleteCharAt(sb.length()-1);
        }
        return false;
    }
    public static void main(String[] args){
        Solution s = new Solution();
        System.out.println(s.getHappyString(1,3));
    }
}