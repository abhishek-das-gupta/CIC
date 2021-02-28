package com.codeforces.contest.div4.contest640.e;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) {
        FastScanner fs = new FastScanner();
        int t  = fs.nextInt();
        while(t-- != 0) {
            int n = fs.nextInt();
            int[] a = fs.readArray(n);
            int[] cnt = new int[n+1];
            for(int l=0; l<n; ++l){
                int s = a[l];
                for(int r=l+1; r<n; ++r){
                    s += a[r];
                    if(s>0 && s<=n)
                        ++cnt[s];
                }
            }
            int res = 0;
            for(int i=0; i<n; ++i)
                if(cnt[a[i]] > 0)
                    res++;
            System.out.println(res);
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
