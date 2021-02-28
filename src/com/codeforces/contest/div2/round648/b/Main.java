package com.codeforces.contest.div2.round648.b;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        FastScanner fs = new FastScanner();
        int t = fs.nextInt();
        while(t-- != 0){
            int n = fs.nextInt();
            int[] arr = new int[n];
            for(int i=0; i<n; ++i) arr[i] = fs.nextInt();
            boolean isSorted = true;
            for(int i=1; i<n; ++i){
                if(arr[i-1] > arr[i]){
                    isSorted = false;
                    break;
                }
            }
            int[] type = new int[n];
            boolean one = false,zero= false;
            for(int i=0; i<n; ++i){
                type[i] = fs.nextInt();
                if(type[i] == 0) zero = true;
                else one = true;
            }
            if(isSorted || (one & zero)){
                System.out.println("Yes");
            }else{
                System.out.println("No");
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
