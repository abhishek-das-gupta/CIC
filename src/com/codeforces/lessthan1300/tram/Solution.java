package com.codeforces.lessthan1300.tram;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int res = 0;
        int i=0;
        int cap  =0;
        while(i < n){
            String s = br.readLine();
            int exit = Integer.parseInt(s.split(" ")[0]);
            int enter = Integer.parseInt(s.split(" ")[1]);
            cap -= exit;
            cap += enter;
            res = Math.max(res, cap);
            i++;
        }
        System.out.println(res);
    }
}
