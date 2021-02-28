package com.codeforces.lessthan1300.InsomniaCure;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int k = Integer.parseInt(br.readLine());
        int l = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());
        int n = Integer.parseInt(br.readLine());
        int d = Integer.parseInt(br.readLine());
        if(k == 1 || l==1 || m == 1 || n == 1){
            System.out.println(d);
            return;
        }
        Set<Integer> s = new HashSet<>();
        int[] arr = {k,l,m,n};
        for (int i=0; i<4; ++i){
            for(int j = arr[i];j <=d; j+=arr[i]){
                s.add(j);
            }
        }
        System.out.println(s.size());
    }
}
