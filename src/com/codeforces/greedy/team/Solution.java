package com.codeforces.greedy.team;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine().split(" ")[0]);
        int res = 0;
        while(n-- != 0){
            String[] s = br.readLine().split(" ");
            int a = Integer.parseInt(s[0]);
            int b = Integer.parseInt(s[1]);
            int c = Integer.parseInt(s[2]);
            if(a == 1 && b == 1 || a == 1 && c== 1 || b==1 && c == 1){
                res++;
            }
        }
        System.out.println(res);

    }
}
