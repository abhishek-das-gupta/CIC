package com.leetcode.dynamic.programming.longest.palindromic.substring;

import java.util.Arrays;

public class Solution {

    public static String longestPalindrome(String s) {
        /**1. O(n) complexity*/
        int n = s.length();
        int[] res = new int[]{0,0};
        for(int i=0; i<n; i++){
            getPalindrome(s,i,i,res);
            getPalindrome(s,i,i+1,res);
        }
        return s.substring(res[0],res[0]+res[1]);

    }
    private static void getPalindrome(String s, int start, int end, int[] res){
        while(start >=0 && end < s.length() && s.charAt(start) == s.charAt(end)){
            start--;
            end++;
        }
        if(end-start-1 > res[1]){
            res[0] = start+1;
            res[1] = end-start-1;
        }
    }

    public static void main(String[] args){
        String s = "babad";
        System.out.println(Solution.longestPalindrome(s));
    }

}
