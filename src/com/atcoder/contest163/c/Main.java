package com.atcoder.contest163.c;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] res = new int[n+1];
        String[] str = br.readLine().split(" ");
        for(int i=0; i<n-1; ++i){
            res[Integer.parseInt(str[i])]++;
        }
        for(int i=1; i<=n; ++i){
            System.out.println(res[i]);
        }
    }
}
