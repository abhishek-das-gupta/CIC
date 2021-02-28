package com.atcoder.contest171.d;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        FastScanner fs = new FastScanner();
        int n = fs.nextInt();
        long[] arr = fs.readArray(n);
        long sum = 0;
        Map<Long,Long> mp = new HashMap<>();
        for(long x : arr) {
            sum += x;
            mp.put(x, mp.getOrDefault(x, 0L)+1);
        }
        int q = fs.nextInt();
        StringBuilder sb = new StringBuilder();
        while(q-- != 0){
            long b = fs.nextLong();
            long c = fs.nextInt();
            boolean present = mp.containsKey(b);
            long cnt = mp.getOrDefault(b,0L);
            sum -= b * cnt;
            sum += c * cnt;
            if(present){
                mp.remove(b);
            }
            mp.putIfAbsent(c, 0L);
            mp.put(c, mp.getOrDefault(c,0L) + cnt);
            sb.append(sum).append("\n");
        }
        System.out.print(sb.toString());

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

        long[] readArray(int n) {
            long[] a = new long[n];
            for (int i = 0; i < n; i++) a[i] = nextInt();
            return a;
        }

        long nextLong() {
            return Long.parseLong(next());
        }
    }
}
