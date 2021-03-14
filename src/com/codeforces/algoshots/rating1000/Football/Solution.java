package com.codeforces.algoshots.rating1000.Football;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Solution {
    public static void main(String[] args) {
        FastScanner fs = new FastScanner();
        int n = fs.nextInt();
        Map<String, Integer> mp = new HashMap<>();
        for (int i = 0; i < n; ++i) {
            String team = fs.next();
            mp.put(team, mp.getOrDefault(team, 0) + 1);
        }
        String team = "";
        int maxScore = 0;
        for (Map.Entry<String, Integer> entry : mp.entrySet()) {
            if (maxScore < entry.getValue()) {
                maxScore = entry.getValue();
                team = entry.getKey();
            }
        }
        System.out.println(team);
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
