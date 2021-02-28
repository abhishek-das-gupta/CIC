package com.codeforces.lessthan1300.wordcapitalization;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder(br.readLine());
        if(!Character.isUpperCase(sb.charAt(0))) sb.setCharAt(0, Character.toUpperCase(sb.charAt(0)));
        System.out.println(sb.toString());

    }
}
