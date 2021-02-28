package com.codeforces.algoshots.rating1500;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) {
        FastScanner fs = new FastScanner();
        int n = fs.nextInt(), d = fs.nextInt();
        int[] a = new int[n];
        for(int i=0; i<n; ++i) a[i] = fs.nextInt();
        Arrays.sort(a);
        int l = 0, r = n-1, ans = 0;
        while (l < r) {
            int dif = a[r] - a[l];
            if (dif > d) {
                int i = l+1;
                int difCnt = 0;
                while (i < r) {
                    if (a[i] - a[l] > d) difCnt++;
                    i++;
                }
                if (difCnt > 0) ans++;

                i = r-1;
                difCnt = 0;
                while (i > l) {
                    if (a[r] - a[i] > d) difCnt++;
                    i--;
                }
                if (difCnt > 0) ans++;
            }
            l++;
            r--;
        }
        System.out.println(ans);
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
