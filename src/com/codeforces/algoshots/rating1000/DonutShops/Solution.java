package com.codeforces.algoshots.rating1000.DonutShops;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution {
    public static void main(String[] args) {
        FastScanner fs = new FastScanner();
        int n = fs.nextInt(), m = fs.nextInt(), t = 0;
        int[] a = fs.readArray(m);
        int addCycle = 0;
        int[] cycleAddedHouses = new int[m];
        for (int i = 0; i < a.length; ++i) {
            if (i > 0 && a[i - 1] > a[i]) {
                addCycle += n;
            }
            cycleAddedHouses[i] += a[i] + addCycle;
        }
        //System.out.println(Arrays.toString(a));
        for (int i = 0; i < cycleAddedHouses.length; ++i) {
            t += i == 0 ? cycleAddedHouses[i] - 1 : cycleAddedHouses[i] - cycleAddedHouses[i - 1];
        }
        System.out.println(t);
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
