package com.codeforces.lessthan1300.bitpp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int x = 0;
        while(n-- != 0){
            String s = br.readLine();
            if( s.equals("++X")|| s.equals("X++")) x++;
            else x--;
        }
        System.out.println(x);
    }
}
