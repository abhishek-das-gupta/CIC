package com.codeforces.div2.b.contest284;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) {
        FastScanner fs = new FastScanner();
        int n = fs.nextInt(), m = fs.nextInt();
        Map<String, String> mp = new HashMap<>();
        for (int i=0; i<m; ++i) {
            String s1 = fs.next(), s2 = fs.next();
            if(s1.length() <= s2.length()) {
                mp.put(s1, s1);
                mp.put(s2, s1);
            } else {
                mp.put(s1, s2);
                mp.put(s2, s2);
            }
        }
        StringBuilder sb = new StringBuilder();
        for(int i=0; i<n-1; ++i) {
            sb.append(mp.get(fs.next())).append(" ");
        }
        sb.append(mp.get(fs.next()));
        System.out.println(sb);
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
