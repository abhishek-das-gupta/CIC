package com.leetcode.contest.biweekly.min.insertions;

import java.util.*;

class Solution {
    public int minInsertions(String s) {
        int n = s.length();
        Stack<Integer> stk = new Stack<>();
        StringBuilder sb = new StringBuilder(s);

        for(int i=0; i<sb.length(); ) {
            char c = sb.charAt(i);
            if(c == '$' || c == '#') {
                i++;
            }
            else if(c == '(') {
                stk.push(i);
                i++;
            }
            else{
                if(stk.isEmpty()) {
                    if(i + 1 < sb.length() && sb.charAt(i+1) == ')') {
                        sb.insert(i,'#');
                        i+=3;
                    }
                    else {
                        sb.insert(i,'#');
                        sb.insert(i+2,'#');
                        i += 3;
                    }
                }
                else if(i + 1 < sb.length() && sb.charAt(i+1) == ')') {
                    stk.pop();
                    i+=2;
                }
                else {
                    int j = stk.pop();
                    // sb.setCharAt(j, '#');
                    sb.insert(i+1, '#');
                    i+=2;
                }
            }
        }
        while(!stk.isEmpty()) {
            sb.setCharAt(stk.pop(), '$');
        }
        System.out.println(sb.toString());
        int ans = 0;
        for(char c : sb.toString().toCharArray()) {
            if(c == '#') ans++;
            else if(c == '$') ans += 2;
        }
        return ans;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.minInsertions("))))()))())"));
    }
}