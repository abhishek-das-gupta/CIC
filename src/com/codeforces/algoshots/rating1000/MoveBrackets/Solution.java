package com.codeforces.algoshots.rating1000.MoveBrackets;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Solution {
    public static void main(String[] args) {
        FastScanner fs = new FastScanner();
        int t = fs.nextInt();
        while (t-- > 0) {
            int n = fs.nextInt();
            StringBuilder sb = new StringBuilder(fs.next());
            Stack<Integer> stack = new Stack<>();
            for (int i = 0; i < n; ++i) {
                char c = sb.charAt(i);
                if (c == '(') {
                    stack.push(i);
                } else {
                    if (stack.isEmpty()) {
                        sb.setCharAt(i, '#');
                    } else {
                        stack.pop();
                    }
                }
            }
            while (!stack.isEmpty()) {
                sb.setCharAt(stack.pop(), '#');
            }
            int misplacedBracketsCount = 0;
            for (char c : sb.toString().toCharArray()) {
                misplacedBracketsCount += c == '#' ? 1 : 0;
            }
            System.out.println(misplacedBracketsCount / 2);
        }

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
