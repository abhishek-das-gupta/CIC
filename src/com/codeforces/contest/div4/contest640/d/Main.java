package com.codeforces.contest.div4.contest640.d;

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
            int[] a = fs.readArray(n);
            int i=0, j=n-1;
            boolean ok = true;
            int sumA = 0;
            int sumB = 0;
            int top = 0;
            int ct =0;
            while(i <= j){
                ++ct;
                if(ok){
                    int currA = 0;
                    while(i <= j && currA <= top){
                        currA += a[i];
                        i++;
                    }
                    sumA += currA;
                    if(currA < top) break;
                    top = currA;
                    ok = false;

                }
                else{
                    int currB = 0;
                    while(j >=i && currB <= top){
                        currB += a[j];
                        j--;
                    }
                    sumB += currB;
                    if(currB < top) break;
                    top = currB;
                    ok = true;
                }
            }
            System.out.println(ct + " " + sumA + " " + sumB);
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
