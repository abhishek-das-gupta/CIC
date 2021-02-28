package com.atcoder.contest173.b;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        FastScanner fs = new FastScanner();
        Map<String, Integer> mp = new LinkedHashMap<>();
        int n = fs.nextInt();
        mp.put("AC",0); mp.put("WA",0); mp.put("TLE",0); mp.put("RE", 0);
        for(int i=0; i<n; ++i){
            String s = fs.next();
            mp.put(s, mp.getOrDefault(s, 0)+1);
        }
        for(String k : mp.keySet()){
            System.out.println(k + " x " + mp.get(k));
        }
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
