package com.atcoder.contest173.c;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        FastScanner fs = new FastScanner();
        int n = fs.nextInt();
        int m = fs.nextInt();
        int k = fs.nextInt();
        char[][] a = new char[n][m];
        for (int i = 0; i < n; ++i) {
            String s = fs.next();
            for (int j = 0; j < m; ++j) {
                a[i][j] = s.charAt(j);
            }
        }
        int ans = 0;
        for(int mask=0; mask < 1 << (n + m); ++mask){
            int count = 0;
            for(int i=0; i<n; ++i){
                for(int j=0; j<m; ++j){
                    if(a[i][j] == '.') continue;
                    if((mask & ((1 << i)  | (1 << (n + j)))) != 0) continue;
                    count++;
                }
            }
            if(count == k) ans++;
        }
        System.out.println(ans);
    }


    static class FastScanner {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer("");

        String next() {
            while (!st.hasMoreTokens())
                try {
                    st = new StringTokenizer(br.readLine());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            return st.nextToken();
        }

        int nextInt() {
            return Integer.parseInt(next());
        }

        int[] readArray(int n) {
            int[] a = new int[n];
            for (int i = 0; i < n; i++) a[i] = nextInt();
            return a;
        }

        long nextLong() {
            return Long.parseLong(next());
        }
    }
}

