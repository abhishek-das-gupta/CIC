package com.codeforces.algoshots.rating1000.Expression;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
    public static void main(String[] args) {
        FastScanner fs = new FastScanner();
        int[] arr = fs.readArray(3);
        int oneCount = 0;
        for (int  x : arr) {
            oneCount += x == 1 ? 1 : 0;
        }
        int sum = 0;
        if (oneCount == 3) {
            for (int x : arr) {
                sum += x;
            }
        }
        else if (oneCount == 2) {
            int first = -1, second = -1;
            for (int i=0; i<arr.length; ++i) {
                if (arr[i] == 1) {
                    if (first == -1) {
                        first = i;
                    }
                    else if (second == -1) {
                        second = i;
                    }
                }
            }
            if (first == 0 && second == 2) {
                sum += arr[1] + 2;
            }
            else {
                int tmp = 0;
                for (int j : arr) {
                    if (j == 1) {
                        tmp++;
                    } else {
                        sum = j;
                    }
                }
                sum *= tmp;
            }
        }
        else if (oneCount == 1) {
            int idx = -1;
            for (int i = 0; i<arr.length; ++i) {
                if (arr[i] == 1) {
                    idx = i;
                    break;
                }
            }
            if (idx == 0) {
                sum += (arr[1] + 1) * arr[2];
            } else if (idx == 2) {
                sum += (arr[1] + 1) * arr[0];
            } else {
                if (arr[0] >= arr[2]) {
                    sum += (arr[2] + 1) * arr[0];
                } else {
                    sum += (arr[0] + 1) * arr[2];
                }
            }
        }
        else {
            sum = arr[0] * arr[1] * arr[2];
        }
        System.out.println(sum);

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
