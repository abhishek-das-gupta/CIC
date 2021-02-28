package com.junior.training.cfB.fence;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) {
        FastScanner fs = new FastScanner();
        int n = fs.nextInt();
        int k = fs.nextInt();
        int[] h = fs.readArray(n);
        int[] pf = new int[n];
        int sum = Integer.MAX_VALUE;
        int idx = -1;
        for(int i=0; i<n; ++i){
            if(i < k-1) pf[i] = Integer.MAX_VALUE;
            else if(i-k+1 == 0){
                int sum1 = 0;
                for(int j=i-k+1; j<=i; ++j){
                    sum1 += h[j];
                }
                pf[i] = sum1;
            }
            else{
                pf[i] = h[i] + pf[i-1] - h[i-k];
            }
            if(sum > pf[i]){
                sum = pf[i];
                idx = i-k + 2;
            }
        }
        System.out.println(idx);

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
