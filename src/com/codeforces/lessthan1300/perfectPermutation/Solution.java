package com.codeforces.lessthan1300.perfectPermutation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        if(n == 1){
            System.out.println(-1);
            return;
        }
        List<Integer> p = new ArrayList<>();
        for(int i=1; i<=n; ++i)
            p.add(0,i);
        for(int x : p)
            System.out.print(x + " ");
        System.out.println();
    }
}
