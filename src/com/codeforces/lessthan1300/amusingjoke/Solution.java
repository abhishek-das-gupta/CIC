package com.codeforces.lessthan1300.amusingjoke;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String a = br.readLine();
        String b = br.readLine();
        String s = br.readLine();
        int[] cnt = new int[26];
        for(char c : a.toCharArray())
            cnt[c-'A']++;
        for(char c : b.toCharArray())
            cnt[c-'A']++;
        for(char c : s.toCharArray()){
            cnt[c-'A']--;
        }
        for(int i=0; i<26; ++i){
            if(cnt[i] != 0 ) {
                System.out.println("NO");
                return;
            }
        }
        System.out.println("YES");

    }
}
