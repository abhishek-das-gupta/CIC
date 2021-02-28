package com.atcoder.contest162.c;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) {
        FastScanner fs = new FastScanner();
        int k = fs.nextInt();
        long ans = 0;
        for(int i=1; i<=k; ++i){
            for(int j=1; j<=k; ++j){
                for(int h=1; h<=k; ++h){
                    ans += gcd(i,gcd(j,h));
                }
            }
        }
        System.out.println(ans);
    }
    public static int gcd(int a, int b){
        if(a == 0) return b;
        return gcd(b%a, a);
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
