package com.atcoder.contest171.e;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) {
        FastScanner fs = new FastScanner();
        int n = fs.nextInt();
        long[] arr = new long[n];
        long[] a = new long[n];
        long xor = 0;
        for(int i=0; i<n; ++i) {
            a[i] = fs.nextLong();
            xor ^= a[i];
        }
        for(int i=0; i<n; ++i){
            arr[i] = a[i] ^ xor;
        }
        /**
         * a[0] = arr[1] ^ //arr[2] ^ //arr[3]
         * a[1] = //arr[0] ^ //arr[2] ^ //arr[3]
         * a[2] = //arr[0] ^ //arr[1] ^ arr[3]
         * a[3] = arr[0] ^ //arr[1] ^ arr[2]
         *
         * arr[0] = (arr[1] ^ arr[2] ^ arr[3]) ^ (arr[0]^arr[1]^arr[2]^arr[3])
         *
         * */
        for(long x : arr)
            System.out.print(x + " ");
        System.out.println();
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
