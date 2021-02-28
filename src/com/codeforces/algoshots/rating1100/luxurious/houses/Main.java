package com.codeforces.algoshots.rating1100.luxurious.houses;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) {
        FastScanner fs = new FastScanner();
        int n = fs.nextInt();
        long[] h = fs.readLongArray(n);
        long[] max = new long[n];
        max[n-1] = h[n-1];
        for (int i=n-2; i>=0; --i) max[i] = Math.max(h[i+1], max[i+1]);
        StringBuilder sb = new StringBuilder();
        for (int i=0; i<n-1; ++i) {
            if (h[i] > max[i]) sb.append("0");
            else {
                sb.append(max[i] - h[i] + 1);
            }
            sb.append(" ");
        }
        sb.append("0");
        System.out.println(sb.toString());
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

        long[] readLongArray(int n) {
            long[] a = new long[n];
            for (int i=0; i<n; ++i) a[i] = nextLong();
            return a;
        }

        long nextLong() {
            return Long.parseLong(next());
        }
    }
}
