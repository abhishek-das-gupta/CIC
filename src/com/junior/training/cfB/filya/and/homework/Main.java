package com.junior.training.cfB.filya.and.homework;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        FastScanner fs = new FastScanner();
        int n = fs.nextInt();
        Set<Long> set = new LinkedHashSet<>();

        long[] arr = new long[n];
        for(int i=0; i<n; ++i){
            arr[i] = fs.nextLong();
        }
        fs.shuffleArray(arr);
        Arrays.sort(arr);
        for(long x : arr) set.add(x);
        if(set.size() == 1 || set.size() == 2) {
            System.out.println("YES");
        }
        else if(set.size() == 3){
            Iterator<Long> it = set.iterator();
            long q = it.next();
            long w = it.next();
            long e = it.next();
            if(q<w && w<e && 2*w == q+e){
                System.out.println("YES");
            }else{
                System.out.println("NO");
            }
        }
        else{
            System.out.println("NO");
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

        int[] readArray(int n) {
            int[] a = new int[n];
            for (int i = 0; i < n; i++) a[i] = nextInt();
            return a;
        }
        long[] readLongArray(int n) {
            long[] a = new long[n];
            for (int i = 0; i < n; i++) a[i] = nextLong();
            return a;
        }

        long nextLong() {
            return Long.parseLong(next());
        }
    }
}
