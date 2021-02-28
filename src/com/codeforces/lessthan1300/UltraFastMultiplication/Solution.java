package com.codeforces.lessthan1300.UltraFastMultiplication;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String a = br.readLine();
        String b = br.readLine();
        int i = a.length()-1;
        StringBuilder res = new StringBuilder("");

        while(i >= 0){
            int n = (a.charAt(i)-'0') ^ (b.charAt(i)-'0');
            String c = Integer.toString(n);
            res.insert(0,c);
            i--;
        }
        System.out.println(res.toString());
    }
}
