package com.junior.training.cfB.kuriyama.mirai.stones;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Random;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) {
        FastScanner fs = new FastScanner();
        int n = fs.nextInt();
        long[] A = new long[n];
        long[] B = new long[n];

        for(int i=0; i<n; ++i){
            A[i] = fs.nextLong();
            B[i] = A[i];
        }
        fs.shuffleArray(B);
        Arrays.sort(B);
        for(int i=1; i<n; ++i){
            A[i] += A[i-1];
            B[i] += B[i-1];
        }
        int m = fs.nextInt();
        while(m-- != 0){
            long ans;
            int t = fs.nextInt();
            int l = fs.nextInt()-1;
            int r = fs.nextInt()-1;
            if(t == 1){
                ans = A[r]- (l-1 < 0 ? 0 : A[l-1]);
            }
            else{
                ans = B[r] - (l-1 < 0 ? 0 : B[l-1]);
            }
            System.out.println(ans);
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
        void shuffleArray(long[] arr){
            int n = arr.length;
            Random rnd = new Random();
            for(int i=0; i<n; ++i){
                long tmp = arr[i];
                int randomPos = i + rnd.nextInt(n-i);
                arr[i] = arr[randomPos];
                arr[randomPos] = tmp;
            }
        }
        long nextLong() {
            return Long.parseLong(next());
        }
    }
}
