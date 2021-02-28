package com.atcoder.contest170.c;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) {
        FastScanner fs = new FastScanner();
        int x = fs.nextInt();
        int n = fs.nextInt();
        boolean[] is = new boolean[101];
        for(int i=0; i<n; ++i) {
            int k = fs.nextInt();
            is[k] = true;
        }
        if(n == 0){
            System.out.println(x);
            return;
        }
        int i=x-1;
        int j=x+1;

        while(i >0 && is[i]) i--;

        while(j <=100 && is[j]) j++;

        if(x-i <= j-x){
            System.out.println(i);
        }else{
            System.out.println(j);
        }
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
