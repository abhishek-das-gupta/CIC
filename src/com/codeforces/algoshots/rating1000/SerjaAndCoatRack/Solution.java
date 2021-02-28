package com.codeforces.algoshots.rating1000.SerjaAndCoatRack;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution {

    public static void main(String[] args) {
        FastScanner fs = new FastScanner();
        int n = fs.nextInt(), d = fs.nextInt();
        int[] a = fs.readArray(n);
        int m = fs.nextInt(), res = 0;
        if (m >= n) {
            int sum = 0;
            for (int i=0; i<n; ++i) {
                sum += a[i];
            }
            res += sum - (m - n)*d;
        } else {
            Arrays.sort(a);
            int i=0;
            while (m-- > 0) {
                res += a[i];
                i++;
            }
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
