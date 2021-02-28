package com.junior.training.cfB.petya.and.countryside;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) {
        FastScanner fs = new FastScanner();
        int n = fs.nextInt();
        int[] a = new int[n];
        for(int i=0; i<n; ++i)
            a[i] = fs.nextInt();
        int res = 0;
        for(int i=0; i<n; ++i){
            int len = 1;
            if(i-1 >=0) {
                int l = i - 1;
                int r = i - 1;
                while (l >= 0 && a[l] <= a[l + 1]) {
                    l--;
                }
                len += r - l;
            }
            if(i+1 < n) {
                int l = i + 1;
                int r = i + 1;
                while (r < n && a[r] <= a[r - 1]) {
                    r++;
                }
                len += r - l;
            }
            res = Math.max(res,len);


        }
        System.out.println(res);
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
