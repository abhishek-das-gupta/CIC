package com.codeforces.algoshots.rating1000.CopyingHomework;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Solution {

    public static void main(String[] args) {
        FastScanner fs = new FastScanner();
        int n = fs.nextInt();
        int[] a = fs.readArray(n), b = new int[n];
        PriorityQueue<int[]> min = new PriorityQueue<>((o1, o2) -> o1[0] - o2[0]);
        PriorityQueue<int[]> max = new PriorityQueue<>((o1, o2) -> o2[0] - o1[0]);

        for (int i = 0; i < n; ++i) {
            min.offer(new int[]{a[i], i});
            max.offer(new int[]{a[i], i});
        }
        while  (!min.isEmpty() && !max.isEmpty()) {
            int[] curMin = min.poll();
            int[] curMax = max.poll();
            b[curMin[1]] = curMax[0];
        }
        System.out.println(Arrays.toString(b).replaceAll("[\\[,\\]]*", ""));

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
