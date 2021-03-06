package com.codeforces.algoshots.rating1000.RoadToZero;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
    public static void main(String[] args) {
        FastScanner fs = new FastScanner();
        int t = fs.nextInt();
        while (t-- > 0) {
            long amount = 0;
            long x = fs.nextLong(), y = fs.nextLong();
            long a = fs.nextLong(), b = fs.nextLong();
            //1. Bring both x and y to the same value which will be Math.min(x, y).
            if (x > y || y > x) {
                amount += Math.abs(x - y) * a;
            }
            if (x != 0 && y != 0) {
                //2. There now exists two cases.
                //2.1 Bringing both of them simultaneously to zero using b
                long bothZeroAmount = Math.min(x, y) * b;
                //2.2 Bringing each of them separately to zero using two a's.
                long separateZeroAmount = Math.min(x, y) * (2 * a);
                amount += Math.min(bothZeroAmount, separateZeroAmount);
            }
            System.out.println(amount);
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
