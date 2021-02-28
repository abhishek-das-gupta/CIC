package com.junior.training.cfB.effective.approach;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) {
        FastScanner fs = new FastScanner();
        int n = fs.nextInt();
        Map<Integer,Integer> mp = new HashMap<>();
        for(int i=0; i<n; ++i) mp.put(fs.nextInt(), i);

        long ans1 =0, ans2 =0;
        int m = fs.nextInt();

        for(int i=0; i<m; ++i){
            int k = fs.nextInt();
            ans1 += mp.get(k) + 1;
            ans2 += n-mp.get(k);
        }
        System.out.println(ans1 + " " + ans2);

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
