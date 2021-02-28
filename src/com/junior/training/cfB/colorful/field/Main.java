package com.junior.training.cfB.colorful.field;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        FastScanner fs = new FastScanner();
        int n = fs.nextInt();
        int m = fs.nextInt();
        int k = fs.nextInt();
        int t = fs.nextInt();
        long[] waste = new long[k];
        for(int i=0; i<k; ++i){
            int x = fs.nextInt();
            int y = fs.nextInt();
            waste[i] = m*(x-1) + y;
        }
        fs.shuffleArray(waste);
        Arrays.sort(waste);

        while(t-- != 0){
            int x = fs.nextInt();
            int y = fs.nextInt();

            long testPos = m*(x-1) + y;

            long totalCrops = m*(x-1) + y - 1;
            long totalWaste = 0;

            boolean isWaste = false;
            for(long pos : waste){
                if(pos < testPos) totalWaste++;
                else if(pos == testPos){
                    System.out.println("Waste");
                    isWaste = true;
                    break;
                }
                else{
                    break;
                }
            }
            if(isWaste) continue;
            long ans = (totalCrops-totalWaste) % 3;
            if(ans == 0) System.out.println("Carrots");
            else if(ans == 1) System.out.println("Kiwis");
            else System.out.println("Grapes");
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
