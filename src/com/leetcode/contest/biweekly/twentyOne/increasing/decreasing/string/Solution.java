package com.leetcode.contest.biweekly.twentyOne.increasing.decreasing.string;

import java.util.Arrays;

class Solution {
    public String sortString(String s) {
        int n = s.length();
        char[] c = s.toCharArray();
        Arrays.sort(c);
        s = new String(c);
        StringBuilder sb = new StringBuilder(s);
        StringBuilder res = new StringBuilder();

        while(sb.length() != 0){
            sortSmall(sb,res);
            sortLarge(sb,res);
        }
        return res.toString();
    }
    private void sortSmall(StringBuilder sb,StringBuilder res){
        char nextSmall = '#';
        int i=0;

        while(i < sb.length()){
            if(nextSmall != sb.charAt(i)){
                nextSmall = sb.charAt(i);
                res.append(nextSmall);
                sb.deleteCharAt(i);
            }
            else{
                i++;
            }
        }
        System.out.println(sb.toString() + " " + res.toString());
    }

    private void sortLarge(StringBuilder sb, StringBuilder res){
        char nextLarge = '#';
        int i = sb.length()-1;

        while(i >= 0){
            if(nextLarge != sb.charAt(i)){
                nextLarge = sb.charAt(i);
                res.append(nextLarge);
                sb.deleteCharAt(i);
            }
            i--;
        }
        System.out.println(sb.toString() + " " + res.toString());
    }

    public static void main(String[] args){
        Solution sol = new Solution();
        System.out.println(sol.sortString("leetcode"));
    }

}