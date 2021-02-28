package com.leetcode.strings.rotate.string;

class Solution {
    public boolean rotateString(String A, String B) {
        if(A.equals(B)){
            return true;
        }
        int rotate = 0;
        String C = new String(A);
        while(!C.equals(B)){
            Rotate(C,1);
            rotate += 1;
            if(C.equals(A)){
                return false;
            }
        }

        return true;
    }

    private void Rotate(String s,int k){
        reverse(s,0,s.length()-1);
        k = k % s.length();
        int pivot = s.length() - k;
        reverse(s,0,pivot-1);
        reverse(s,pivot,s.length()-1);

    }

    private void reverse(String s, int left, int right){
        if(left <= right){
            return;
        }
        char c = s.charAt(right);
        s = s.substring(0,right) + s.charAt(left);
        s = s.substring(0,left) + c + s.substring(left+1,right+1);

        reverse(s,left+1,right-1);
    }

    public static void main(String[] args){
        String A = "abcde";
        String B = "cdeab";

        Solution s = new Solution();
        s.rotateString(A,B);
    }
}