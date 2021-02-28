package com.codeforces.algoshots.rating1500.modulo.equality;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.StringTokenizer;


public class Main {
    public static void main(String[] args) {
        FastScanner fs = new FastScanner();
        long n = fs.nextLong();
        BigInteger m = new BigInteger(fs.next());
        BigInteger a = new BigInteger("0"), b = new BigInteger("0");
        for (int i = 0; i < n; ++i) a = a.add(new BigInteger(fs.next()));
        a = a.mod(m);
        for (int i = 0; i < n; ++i) b = b.add(new BigInteger(fs.next()));
        b = b.mod(m);
        b = b.subtract(a);
        System.out.println(b.mod(m));
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
