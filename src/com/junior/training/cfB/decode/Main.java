package com.junior.training.cfB.decode;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) {
        FastScanner fs = new FastScanner();
        int n = fs.nextInt();
        String s = fs.next();
        char[] arr = new char[n];
        if(n % 2 != 0){
            int i=n/2,j=n/2;
            arr[i] = s.charAt(0);
            i--;
            j++;
            for(int k=1; k<n; k+=2){
                arr[i] = s.charAt(k);
                arr[j] = s.charAt(k+1);
                i--;
                j++;
            }
        }
        else{
            int i=0;
            int j=n-1;
            for(int k=n-1; k>=0; k-=2){
                arr[j] = s.charAt(k);
                arr[i] = s.charAt(k-1);
                i++;
                j--;
            }
        }
        System.out.println(new String(arr));
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
