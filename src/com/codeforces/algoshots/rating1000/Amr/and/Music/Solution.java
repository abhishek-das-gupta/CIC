package com.codeforces.algoshots.rating1000.Amr.and.Music;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Solution {
    public static void main(String[] args) {
        FastScanner fs = new FastScanner();
        int n = fs.nextInt(), k = fs.nextInt();
        PriorityQueue<int[]> pq = new PriorityQueue<>((int[] o1, int[] o2) -> o1[0] - o2[0]);
        for (int i=1; i<=n; ++i) {
            pq.offer(new int[] {fs.nextInt(), i});
        }
        List<Integer> res = new ArrayList<>();
        while (!pq.isEmpty()) {
            int[] cur = pq.poll();
            if (k < cur[0]) {
                break;
            }
            k -= cur[0];
            res.add(cur[1]);
        }
        System.out.println(res.size());
        System.out.println(res.toString().replace("[", "").replace("]", "").replaceAll(",", ""));

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
