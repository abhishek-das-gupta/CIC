package com.junior.training.cfB.bear.and.finding.criminals;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args){
        FastScanner fs = new FastScanner();
        int n = fs.nextInt();
        int a = fs.nextInt()-1;
        int[] arr = new int[n];
        for(int i=0; i<n; ++i) arr[i] = fs.nextInt();

        int i=a,j=a;
        int ans = 0;
        while(i >=0 || j < n){
            int s = i < 0 ? 1 : arr[i];
            int t = j >=n ? 1 : arr[j];
            if((s & t)== 1){
                if(i == j || i <0 || j>=n) ans++;
                else ans += 2;
            }
            i--;j++;
        }
        System.out.println(ans);
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
