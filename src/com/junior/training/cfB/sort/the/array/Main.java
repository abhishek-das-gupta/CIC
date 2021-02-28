package com.junior.training.cfB.sort.the.array;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) {
        FastScanner fs = new FastScanner();
        int n = fs.nextInt();
        long[] A = new long[n];
        long[] AA = new long[n];
        for(int i=0; i<n; ++i){
            A[i] = fs.nextLong();
            AA[i] = A[i];
        }
        Arrays.sort(AA);
        int count =0;
        int l=0,r=0;
        for(int i=0; i<n; ++i){
            if(A[i] == AA[i]) continue;
            if(count == 1){
                System.out.println("no");
                return;
            }
            count++;
            l = i;
            while(i < n-1 && A[i] > A[i+1]) i++;
            r = i;
            if(A[r] != AA[l] || A[l] != AA[r]){
                System.out.println("no");
                return;
            }

        }
        l++;r++;
        System.out.println("yes\n" +  l + " "+ r);

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
