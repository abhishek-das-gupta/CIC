package com.leetcode.sliding.window.longest.valid.parentheses;

import java.util.Stack;

class Solution {
    public static int longestValidParentheses(String s) {
        if(s == null || s.length() == 0){
            return 0;
        }
        StringBuilder sb = new StringBuilder(s);
        Stack<Integer> stack = new Stack<>();
        for(int i=0; i<sb.length(); i++){
            char c = sb.charAt(i);
            if(c == '('){
                stack.push(i);
            }
            else{
                if(stack.isEmpty()){
                    sb.setCharAt(i,'#');
                }
                else{
                    stack.pop();
                }
            }
        }
        while(!stack.isEmpty()){
            sb.setCharAt(stack.pop(),'#');
        }
        System.out.println(sb);

        int l=0;
        int r=0;
        int res = 0;
        while(l < sb.length() && sb.charAt(l) == '#'){
            l++;
        }
        r=l;
        System.out.println(l + " " + r);
        if(r == sb.length()){
            return 0;
        }
        while(r < sb.length()){
            if(sb.charAt(r) == '#'){
                res = Math.max(res, r-l);
                while(r < sb.length() && sb.charAt(r) == '#'){
                    r++;
                }
                l=r;
            }
            r++;
        }
        res = Math.max(res, r-l);
        return res;
    }

    public static void main(String[] args){
        System.out.println(Solution.longestValidParentheses("(("));
    }
}