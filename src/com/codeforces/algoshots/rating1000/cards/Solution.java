package com.codeforces.algoshots.rating1000.cards;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Solution {
    public static void main(String[] args) {
        Map<Character, Integer> mp = new HashMap<>();
        mp.put('6', 1);  mp.put('7', 2); mp.put('8', 3);
        mp.put('9', 4); mp.put('T', 5); mp.put('J', 6);
        mp.put('Q', 7); mp.put('K', 8); mp.put('A', 9);

        FastScanner fs = new FastScanner();
        char trump = fs.next().charAt(0);
        String[] s = new String[]{fs.next(), fs.next()};
        if (s[0].charAt(1) == trump && s[1].charAt(1) == trump) {
            System.out.println((mp.get(s[0].charAt(0)) >= mp.get(s[1].charAt(0)) ? "YES" : "NO"));
            return;
        }
        if (s[0].charAt(1) == trump) {
            System.out.println("YES");
            return;
        }
        if (s[1].charAt(1) == trump) {
            System.out.println("NO");
            return;
        }
        if (s[0].charAt(1) != s[1].charAt(1)) {
            System.out.println("NO");
            return;
        }
        System.out.println((mp.get(s[0].charAt(0)) > mp.get(s[1].charAt(0)) ? "YES" : "NO"));
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
