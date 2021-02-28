package com.codeforces.lessthan1300.queueattheschool;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        int n = Integer.parseInt(input[0]);
        int t = Integer.parseInt(input[1]);
        StringBuilder sb = new StringBuilder(br.readLine());

        while(t-- != 0){
            for(int i=1; i<n; ++i){
                if(sb.charAt(i-1) == 'B' && sb.charAt(i) == 'G'){
                    sb.setCharAt(i-1,'G');
                    sb.setCharAt(i,'B');
                    ++i;
                }
            }
        }
        System.out.println(sb.toString());
    }

}
