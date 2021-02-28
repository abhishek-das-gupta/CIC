package com.atcoder.contest171.c;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) {
        FastScanner fs = new FastScanner();
        BigInteger bi = new BigInteger(fs.next());
        BigInteger twentySix = new BigInteger("26");
        StringBuilder sb = new StringBuilder();
        while(bi.compareTo(BigInteger.ZERO)  != 0 ){
            BigInteger k = bi.divide(twentySix);
            int last = Integer.parseInt(bi.mod(twentySix).toString());
            if(last == 0){
                k = k.subtract(BigInteger.ONE);
                sb.insert(0,'z');
            }
            else{
                sb.insert(0, (char)('a' + (last-1)));
            }
            bi = k;
        }
        System.out.println(sb.toString());

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
