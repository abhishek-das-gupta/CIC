package com.junior.training.cfB.steps;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) {
        FastScanner fs = new FastScanner();
        long n = fs.nextLong();
        long m = fs.nextLong();
        long[] cur = new long[2];
        cur[0] = fs.nextLong(); cur[1] = fs.nextLong();
        int k = fs.nextInt();
        long steps = 0;
        while(k-- != 0){
            long dx = fs.nextLong();
            long dy = fs.nextLong();
            long jumpX=Long.MAX_VALUE,jumpY=Long.MAX_VALUE;
            if(dx < 0){
                jumpX = (1-cur[0])/dx;
            }else if(dx > 0){
                jumpX = (n-cur[0])/dx;
            }
            if(dy < 0){
                jumpY = (1-cur[1])/dy;
            }else if(dy > 0){
                jumpY = (m-cur[1])/dy;
            }
            long move = Math.min(jumpX, jumpY);
            steps += move;
            cur[0] += move;
            cur[1] += move;
        }
        System.out.println(steps);
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
