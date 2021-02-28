package com.junior.training.cfB.inna.and.candies;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) {
        FastScanner fs = new FastScanner();
        int n = fs.nextInt();
        int m = fs.nextInt();

        Set<Integer> set = new HashSet<>();
        for(int i=0; i<n; ++i){
            String s = fs.next();
            int yG = -1;
            int yS = -1;
            for(int j=0; j<m; ++j){
                char cell = s.charAt(j);
                if(cell == 'G') yG = j;
                if(cell == 'S') yS = j;
            }
            if(yS < yG ){
                System.out.println(-1);
                return;
            }
            set.add(yS-yG);
        }
        System.out.println(set.size());
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
