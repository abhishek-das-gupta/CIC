package com.codeforces.algoshots.rating1000.LuckyDivision;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
    //4, 7, 44, 47, 74, 77, 447, 474, 4
    public static void main(String[] args) {
        FastScanner fs = new FastScanner();
        int n = fs.nextInt();
        if (dfs(n, new int[]{4, 7}, new StringBuilder())) {
            System.out.println("YES");
            return;
        }
        System.out.println("NO");
    }

    private static boolean dfs(int n, int[] lucky, StringBuilder sb) {
        if (sb.length() != 0 && n >= Integer.parseInt(sb.toString())) {
            int num = Integer.parseInt(sb.toString());
            if (n == num || n % num == 0) {
                return true;
            }
        }
        if (sb.length() != 0 && n < Integer.parseInt(sb.toString())) {
            return false;
        }
        for (int j : lucky) {
            sb.append(j);
            if (dfs(n, lucky, sb)) {
                return true;
            }
            sb.deleteCharAt(sb.length() - 1);
        }
        return false;
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
