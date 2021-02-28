package com.codeforces.algoshots.rating1000.MikeAndPalindromes;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
    public static void main(String[] args) {
        FastScanner fs = new FastScanner();
        StringBuilder sb = new StringBuilder(fs.next());
        int l = 0, r = sb.length() - 1;
        while (l < r) {
            if (sb.charAt(l) != sb.charAt(r)) {
                char tmp = sb.charAt(r);
                sb.setCharAt(r, sb.charAt(l));
                if (isPalindrome(sb.toString())) {
                    System.out.println("YES");
                } else {
                    System.out.println("NO");
                }
                return;
            }
            l++;
            r--;
        }
        System.out.println(sb.length() % 2 == 1 ? "YES" : "NO");
    }
    private static boolean isPalindrome(String s) {
        int l = 0, r = s.length() - 1;
        while (l < r ){
            if (s.charAt(l) != s.charAt(r)) {
                return  false;
            }
            l++;
            r--;
        }
        return true;
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
