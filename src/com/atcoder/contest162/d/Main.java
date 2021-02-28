package com.atcoder.contest162.d;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) {
        FastScanner fs = new FastScanner();
        int n = fs.nextInt();
        String s = fs.next();
        long r=0, b=0, g=0;
        for(char c : s.toCharArray()){
            if(c == 'R') r++;
            else if(c == 'B') b++;
            else g++;
        }
        long total = r*b*g;
        int rgb = (int) 'R' + (int) 'B' + (int) 'G';
        for(int i=0; i<n; ++i){
            char si = s.charAt(i);
            for(int j=i+1; j<n; ++j){
                char sj = s.charAt(j);
                int k = 2*j-i;
                if(k < n)
                    if(((int) si + (int) sj + (int) s.charAt(k)) == rgb)
                        total--;
            }
        }
        System.out.println(total);
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
