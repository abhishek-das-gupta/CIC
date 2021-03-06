package com.codeforces.algoshots.rating1000.MultiplicationTable;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
    public static void main(String[] args) {
        FastScanner fs = new FastScanner();
        long n = fs.nextLong(), x = fs.nextLong(), count = 0;
        for (int i = 1; i <= n; ++i) {
            //1, 2, 3, 4, 5, 6, --> 1 + 1*(n - 1)
            //2, 4, 6, 8, 10, 12 --> 2 + 2*(n - 2)
            // i + i*(pos - 1) = x
            // => pos = (x - i)/i + 1
            // => pos = x/i
            count += x % i  == 0 && x / i <=n ? 1 : 0;
        }
        System.out.println(count);
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
