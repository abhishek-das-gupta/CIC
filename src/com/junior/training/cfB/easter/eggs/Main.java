package com.junior.training.cfB.easter.eggs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) {
        FastScanner fs = new FastScanner();
        int n = fs.nextInt();
        String s1 = "ROYG";
        String s2 = "RBIV";

        StringBuilder sb = new StringBuilder();
        int groups = n / 4;
        int i = 0;
        for(i=0; i<groups; ++i){
            if(i % 2 ==0) sb.append(s1);
            else sb.append(s2);
        }
        int rem = n % 4;
        if(i % 2 == 0) {
            if (rem == 1) {
                sb.append("G");
            } else if (rem == 2) {
                sb.append("GB");
            } else if (rem == 3) {
                sb.append("GBI");
            }
        }
        else{
            if(rem == 1){
                sb.append("B");
            }
            else if(rem == 2){
                sb.append("BI");
            }
            else if(rem == 3){
                sb.append("BIV");
            }
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
