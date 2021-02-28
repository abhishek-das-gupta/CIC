package com.codeforces.greedy.army;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] rank = new int[n+1];
        String[] str = br.readLine().split(" ");
        for(int i=1; i<n; ++i){
            rank[i] = Integer.parseInt(str[i-1]);
        }
        str = br.readLine().split(" ");
        int a = Integer.parseInt(str[0]);
        int b = Integer.parseInt(str[1]);
        int i=a;
        int res = 0;
        while(i < b){
            res += rank[i++];
        }
        System.out.println(res);
    }
}
