package com.codeforces.contest.div4.contest640.b;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) {
        FastScanner fs = new FastScanner();
        int t  = fs.nextInt();
        while(t-- != 0){
            int n = fs.nextInt();
            int k = fs.nextInt();
            if(n < k){
                System.out.println("No");
            }
            else if(n % 2 !=0){
                if(k % 2 != 0 && n > k-1){
                    System.out.println("YES");
                    System.out.print(n-(k-1) + " ");
                    for(int i=0; i<k-1; ++i) System.out.print(1 + " ");
                    System.out.println();
                }
                else{
                    System.out.println("No");
                }
            }
            else{
                if(k % 2 == 0){
                    if(n > k-1) {
                        System.out.println("YES");
                        System.out.print(n - (k - 1) + " ");
                        for (int i = 0; i < k - 1; ++i) System.out.print(1 + " ");
                        System.out.println();
                    }
                    else{
                        System.out.println("NO");
                    }
                }
                else{
                    if(n > 2*(k-1)){
                        System.out.println("YES");
                        System.out.print(n-2*(k-1) + " ");
                        for(int i=0; i<k-1; ++i) System.out.print(2 + " ");
                        System.out.println();
                    }
                    else{
                        System.out.println("No");
                    }
                }
            }

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
