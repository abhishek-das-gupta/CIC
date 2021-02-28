package com.codeforces.lessthan1300.word;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        int lower = 0;
        int upper = 0;
        for(int i=0; i<s.length(); ++i){
            char c = s.charAt(i);
            if(Character.isUpperCase(c))
                upper++;
            else
                lower++;
        }
        if(upper > lower)
            System.out.println(s.toUpperCase());
        else
            System.out.println(s.toLowerCase());
    }
}
