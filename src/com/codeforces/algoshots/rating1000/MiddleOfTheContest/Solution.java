package com.codeforces.algoshots.rating1000.MiddleOfTheContest;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
    public static void main(String[] args) {
        FastScanner fs = new FastScanner();
        String s1 = fs.next(), s2 = fs.next();
        int h1 = Integer.parseInt(s1.split(":")[0].trim());
        int m1 = Integer.parseInt(s1.split(":")[1].trim());
        int h2 = Integer.parseInt(s2.split(":")[0].trim());
        int m2 = Integer.parseInt(s2.split(":")[1].trim());
        int t1 = h1*60 + m1;
        int t2 = h2*60 + m2;
        int t3 = (t1 + t2) / 2;
        int h3 = t3 / 60;
        int m3 = t3 % 60;
        System.out.println((h3 < 10 ? "0" + h3 : h3)+":"+(m3 < 10 ? "0" + m3 : m3));
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
