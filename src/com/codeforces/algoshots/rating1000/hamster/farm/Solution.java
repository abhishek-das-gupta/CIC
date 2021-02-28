package com.codeforces.algoshots.rating1000.hamster.farm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
    public static void main(String[] args) {
        FastScanner fs = new FastScanner();
        long n = fs.nextLong();
        if (n == 0) {
            System.out.println(1 + " " + 0);
            return;
        }
        int k = fs.nextInt();
        long[] a = fs.readLongArray(k);
        long minRem = Long.MAX_VALUE, boxIndex = -1, boxVal = -1;
        for (int i=0; i<k; ++i) {
            if (minRem > n % a[i]) {
                minRem = n % a[i];
                boxIndex = i;
                boxVal = a[i];
            } else if(minRem == n % a[i]) {
                if (boxVal > a[i]) {
                    boxIndex = i;
                    boxVal = a[i];
                }
            }
        }
        System.out.println(boxIndex + 1 + " " + n / boxVal);

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
