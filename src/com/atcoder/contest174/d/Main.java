package com.atcoder.contest174.d;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) {
        FastScanner fs = new FastScanner();
        int n = fs.nextInt();
        char[] a = fs.next().toCharArray();
        int ans = 0;
        List<Integer> ws = new ArrayList<>(), rs = new ArrayList<>();
        for(int i=0; i<n; ++i)
            if(a[i] == 'W') ws.add(i);
            else rs.add(i);
        int wIdx = 0, rIdx = rs.size()-1;
        while(wIdx < ws.size() && rIdx >= 0) {
            if(ws.get(wIdx) < rs.get(rIdx)) {
                ans++;
            }
            wIdx++;
            rIdx--;
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
