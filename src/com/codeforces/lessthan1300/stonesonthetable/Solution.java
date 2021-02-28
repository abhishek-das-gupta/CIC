package com.codeforces.lessthan1300.stonesonthetable;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        String s = br.readLine();
        int res = 0;
        int i=1;
        int j=1;
        while(j < n){
            if(s.charAt(j-1) == s.charAt(j)){
                i = j;
                while(j < n && s.charAt(j-1) == s.charAt(j))
                    j++;
                res += j-i;
                i=j;
            }
            j++;
        }
        System.out.println(res);
    }
}
