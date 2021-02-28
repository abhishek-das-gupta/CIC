package com.codeforces.algoshots.rating1000.TransformAtoB;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.List;
import java.util.StringTokenizer;

public class Solution {
    public static void main(String[] args) {
        FastScanner fs = new FastScanner();
        long a = fs.nextLong(), b = fs.nextLong();
        if ((b % 10) %2 != 0 && b % 10 != 1) {
            System.out.println("NO");
            return;
        }
        List<Long> arr = new LinkedList<>();
        boolean isTransformationPossible = false;
        while (b >= a) {
            ((LinkedList) arr).offerFirst(b);
            if (b == a) {
                isTransformationPossible = true;
                break;
            }
            long lastDigit = b % 10;
            if (lastDigit % 2 == 0) {
                b = b / 2;
            } else if (lastDigit == 1) {
                String s = b + "";
                b = Long.parseLong(s.substring(0, s.length()-1));
            } else {
                System.out.println("NO");
                return;
            }
        }
        if (!isTransformationPossible) {
            System.out.println("NO");
            return;
        }
        System.out.println("YES");
        System.out.println(arr.size());
        System.out.println(arr.toString().replaceAll("[\\[\\],]*",""));
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
