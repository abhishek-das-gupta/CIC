package com.codeforces.algoshots.rating1100.the.contest;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) {
        FastScanner fs = new FastScanner();
        int n = fs.nextInt();
        int[] a = fs.readArray(n);
        int m = fs.nextInt();
        int[][] t = new int[m][2];
        for (int i=0; i<m; ++i) {
            t[i] = fs.readArray(2);
        }
        int all = 0, res = 0, j=0;
        for (int i= 0; i<m; ++i) {
            if (i != 0) {

            }
            int dif = t[i][1] - t[i][0];
            while (j < n && a[j] <= dif) {
                all++;
                j++;
                dif -= a[j];
            }
            if (j == n) break;
        }
        if (all != n) {
            System.out.println(-1);
            return;
        }
        System.out.println(res);
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
