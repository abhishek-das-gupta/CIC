package com.codeforces.algoshots.rating1000.MaximumControl;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Solution {
    public static void main(String[] args) {
        FastScanner fs = new FastScanner();
        int n = fs.nextInt();
        Map<Integer, List<Integer>> mp = new HashMap<>();
        for (int i=0; i<n-1; ++i) {
            int[] e = fs.readArray(2);
            mp.putIfAbsent(e[0], new ArrayList<>());
            mp.putIfAbsent(e[1], new ArrayList<>());
            mp.get(e[0]).add(e[1]);
            mp.get(e[1]).add(e[0]);
        }
        int res = 0;
        for (Map.Entry<Integer, List<Integer>> entry : mp.entrySet()) {
            if (entry.getValue().size() == 1) {
                res++;
            }
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
