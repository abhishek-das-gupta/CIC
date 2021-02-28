package com.codeforces.algoshots.rating1000.XeniaAndRingRoad;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;
/**
 * Idea: Given a circle of points n, how to find distance b/w two points in clockwise order ?
 * <br>Use <b>modulo arithmetic</b>
 * <br>Consider two points a and b and <code>distance</code> is distance b/w them.
 * <br>if <code>a < b</code> then <code>distance = b - a</code>
 * <br>else b lies behind a (<code>a > b</code>) then <code>distance = n +  b - a</code>
 * <br>This can be written without if checks as:
 * <br><code>distance = (b - a + n) % n</code>
 * */

public class Solution {
    public static void main(String[] args) {
        FastScanner fs = new FastScanner();
        int n = fs.nextInt(), m = fs.nextInt();
        int prevHouse = 1;
        long res = 0;
        for (int i = 0; i < m; ++i) {
            int curHouse = fs.nextInt();
            res += (curHouse - prevHouse + n) % n;
            prevHouse = curHouse;
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
