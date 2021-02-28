package com.junior.training.cfB.summer.sell.off;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) {
        FastScanner fs = new FastScanner();
        int n = fs.nextInt();
        int f = fs.nextInt();
        long[][] arr = new long[n][2];
        for(int i=0; i<n; ++i){
            arr[i][0] = fs.nextLong();
            arr[i][1] = fs.nextLong();
        }
        Arrays.sort(arr, new Comparator<long[]>() {
            @Override
            public int compare(long[] a, long[] b) {
                long withoutSelloutA = Math.min(a[0],a[1]);
                long withSelloutA = Math.min(2*a[0],a[1]);

                long withoutSelloutB = Math.min(b[0],b[1]);
                long withSelloutB = Math.min(2*b[0],b[1]);

                long diffA = withSelloutA - withoutSelloutA;
                long diffB = withSelloutB - withoutSelloutB;

                if(diffA != diffB){
                    return (int)(diffB-diffA);
                }
                else{
                    return (int)(a[0]-b[0]);
                }

            }
        });
        //for(int i=0; i<n; ++i) System.out.println(Arrays.toString(arr[i]));
        long ans = 0;
        int i=0;
        while(i<n || f > 0){
            if(f >0){
                arr[i][0] *= 2;
                f--;
            }
            ans += Math.min(arr[i][0], arr[i][1]);
            i++;
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
