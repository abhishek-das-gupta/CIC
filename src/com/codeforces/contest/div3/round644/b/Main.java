package com.codeforces.contest.div3.round644.b;

import org.w3c.dom.ls.LSException;

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
            int[] s = new int[n];
            for(int i=0; i<n; ++i){
               s[i] = fs.nextInt();
            }
            Arrays.sort(s);
            List<Integer> A = new ArrayList<>();
            List<Integer> B = new ArrayList<>();
            boolean pick = true;
            for(int j=n-1; j>=0; --j){
                if(pick){
                    B.add(0,s[j]);
                    pick = false;
                }
                else{
                    A.add(0,s[j]);
                    pick = true;
                }

            }
            //System.out.println(A.toString() + " " + B.toString());
            int ans = Integer.MAX_VALUE;
            for(int i=0; i<B.size(); ++i){
                ans = Math.min(ans, Math.abs(A.get(A.size()-1) - B.get(i)));
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

        long nextLong() {
            return Long.parseLong(next());
        }
    }
}
