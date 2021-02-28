package com.codeforces.algoshots.rating1500.queue;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
//100, 101, 102, 103, 104, 105
public class Main {
    public static void main(String[] args) {
        FastScanner fs = new FastScanner();
        int n = fs.nextInt();
        long[] a = fs.readLongArray(n);
        long[] res = new long[n]; res[n-1] = -1;
        for (int i=0; i<n-1; ++i) {
            int l=i+1, r = n-1, idx = i;
            while (l <= r) {
                int mid = l + (r-l)/2;
                if (a[i] >= a[mid]) {
                    l = mid + 1;
                    idx = i;
                } else {
                    r--;
                }
            }
            res[i] = idx - i - 1;
        }
        for (long x : res) System.out.print(x + " ");
    }

    public void naive(long[] a, int n) {
        long[] res = new long[n]; res[n-1] = -1;
        for (int i = 0; i < n-1; ++i) {
            int j = n - 1;
            while (j > i && a[i] <= a[j]) j--;
            res[i] = j - i - 1;
        }
        for (long x : res) System.out.print(x + " ");
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
            for (int i = 0; i < n; i++) a[i] = nextLong();
            return a;
        }

        long nextLong() {
            return Long.parseLong(next());
        }
    }
}
