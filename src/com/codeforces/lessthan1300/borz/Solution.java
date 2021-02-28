package com.codeforces.lessthan1300.borz;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        StringBuilder sb = new StringBuilder();
        int n = s.length();
        for(int i=0; i<n; ++i){
            if(s.charAt(i) == '.'){
                sb.append('0');
            }else if(s.charAt(i) == '-'){
                if(i+1 < n && s.charAt(i+1) == '.'){
                    sb.append('1');
                }else if(i+1<n && s.charAt(i+1) == '-'){
                    sb.append('2');
                }
                i++;
            }
        }
        System.out.println(sb.toString());
    }
}
