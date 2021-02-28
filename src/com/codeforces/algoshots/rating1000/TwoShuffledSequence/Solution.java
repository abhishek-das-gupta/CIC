package com.codeforces.algoshots.rating1000.TwoShuffledSequence;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Solution {
    public static void main(String[] args) {
        FastScanner fs = new FastScanner();
        int n = fs.nextInt();
        int[] a = fs.readArray(n);
        Map<Integer, Integer> mp = new HashMap<>();
        for (int x : a) {
            mp.put(x, mp.getOrDefault(x, 0) + 1);
            if (mp.get(x) > 2) {
                System.out.println("NO");
                return;
            }
        }
        boolean flag = true;
        PriorityQueue<Integer> inc = new PriorityQueue<>();
        PriorityQueue<Integer> dec = new PriorityQueue<>(Collections.reverseOrder());
        for (Map.Entry<Integer, Integer> entry : mp.entrySet()) {
            if (entry.getValue() == 2) {
                inc.offer(entry.getKey());
                dec.offer(entry.getKey());
            } else if (flag) {
                inc.offer(entry.getKey());
                flag = false;
            } else {
                dec.offer(entry.getKey());
                flag = true;
            }
        }
        System.out.println("YES");
        System.out.println(inc.size());
        StringBuilder sb1 = new StringBuilder();
        while (!inc.isEmpty()) {
            sb1.append(inc.poll()).append(" ");
        }
        System.out.println(sb1.toString().trim());
        System.out.println(dec.size());
        StringBuilder sb2 = new StringBuilder();
        while(!dec.isEmpty()) {
            sb2.append(dec.poll()).append(" ");
        }
        System.out.println(sb2.toString().trim());
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
