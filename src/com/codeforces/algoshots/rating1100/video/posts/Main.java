package com.codeforces.algoshots.rating1100.video.posts;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) {
        FastScanner fs = new FastScanner();
        int n = fs.nextInt(), k = fs.nextInt();
        int[] a = fs.readArray(n);
        long sum = Arrays.stream(a).sum();
        if (sum % k != 0) {
            System.out.println("No");
            return;
        }
        long part = sum / k;
        int[] res = new int[k];
        int curSum = 0, j=0, ct=0;
        for (int i=0; i<n; ++i) {
            curSum += a[i];
            ct++;
            if (curSum == part) {
                res[j] = ct;
                curSum = 0;
                ct = 0;
                j++;
            }
        }
        //what if one part consumes all a's ?
        if (j != k) {
            System.out.println("No");
            return;
        }
        System.out.println("Yes");
        for (int i=0; i<k; ++i) System.out.print(res[i] + " ");
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
