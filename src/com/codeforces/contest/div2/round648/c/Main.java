package com.codeforces.contest.div2.round648.c;

import javax.annotation.processing.SupportedSourceVersion;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) {
        FastScanner fs = new FastScanner();
        int n = fs.nextInt();
        int[] a = fs.readArray(n);
        int[] b = fs.readArray(n);
        int[] posA = new int[n+1];
        for(int i=0; i<n; ++i) posA[a[i]] = i;
        int[] posB = new int[n+1];
        for(int i=0; i<n; ++i) posB[b[i]] = i;

        int[] cnt = new int[n+1];
        for(int i=1; i<=n; ++i){
            int idx = (posB[i] - posA[i] + n) % n;
//            System.out.print(idx + " ");
            cnt[idx]++;
        }
        //System.out.println(Arrays.toString(cnt));
        int ans = 0;
        for(int x : cnt) ans = Math.max(ans, x);
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
