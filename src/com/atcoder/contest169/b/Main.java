package com.atcoder.contest169.b;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) {
        FastScanner fs = new FastScanner();
        int n = fs.nextInt();
        BigInteger ans = BigInteger.ONE;
        BigInteger M = new BigInteger("1000000000000000000");
        List<BigInteger> arr = new ArrayList<>();
        for(int i=0; i<n; ++i){
            BigInteger temp = new BigInteger(fs.next());
            if(temp.compareTo(BigInteger.ZERO) == 0){
                System.out.println(0);
                return;
            }
            arr.add(temp);
        }
        StringBuilder sb = new StringBuilder();
        for(int i=0; i<n; ++i){
            ans = ans.multiply(arr.get(i));
            //System.out.println(sb.toString() + " " + ans + " " + M);
            if(ans.compareTo(M) > 0){
                System.out.println(-1);
                return;
            }
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
