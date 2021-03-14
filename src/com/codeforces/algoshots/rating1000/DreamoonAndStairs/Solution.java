package com.codeforces.algoshots.rating1000.DreamoonAndStairs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
    public static void main(String[] args) {
        FastScanner fs = new FastScanner();
        int n = fs.nextInt(), m = fs.nextInt(), totalSteps;
        //If n < m, then totalSteps <= n and hence can never be multiple of m.
        if (m > n) {
            totalSteps = -1;
        } else {
            if (n % 2 == 0) {
                totalSteps = n / 2;
            } else {
                totalSteps = n / 2 + 1;
            }
            while (totalSteps % m != 0) {
                totalSteps++;
            }
        }
        System.out.println(totalSteps);
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
