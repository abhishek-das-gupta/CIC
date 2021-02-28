package com.junior.training.cfB.chat.online;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) {
        FastScanner fs = new FastScanner();
        int p = fs.nextInt();
        int q = fs.nextInt();
        int l = fs.nextInt();
        int r = fs.nextInt();
        int[][] z = new int[p][2];
        for(int i=0; i<p; ++i){
            z[i][0] = fs.nextInt();
            z[i][1] = fs.nextInt();
        }
        int[][] x = new int[q][2];
        for(int i=0; i<q; ++i){
            x[i][0] = fs.nextInt();
            x[i][1] = fs.nextInt();
        }
        int ans = 0;
        for(int i=l; i<=r; ++i){
            boolean found = false;
            for(int j=0; j<q; ++j){
                x[j][0] += i;
                x[j][1] += i;
                for(int k=0; k<p; ++k){
                    int a = Math.max(x[j][0],z[k][0]);
                    int b = Math.min(x[j][1],z[k][1]);

                    if(a <= b) {
                        ans++;
                        found = true;
                        break;
                    }
                }

                x[j][0] -= i;
                x[j][1] -= i;
                if(found) break;
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
