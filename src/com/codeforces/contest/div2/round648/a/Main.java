package com.codeforces.contest.div2.round648.a;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) {
        FastScanner fs = new FastScanner();
        int t = fs.nextInt();
        while(t-- != 0){
            int n = fs.nextInt();
            int m = fs.nextInt();
            int[][] arr = new int[n][m];
            Set<Integer> set1 = new HashSet<>();
            Set<Integer> set2 = new HashSet<>();
            for(int i=0; i<n;++i){
                for(int j=0; j<m; ++j){
                    arr[i][j] = fs.nextInt();
                    if(arr[i][j] == 1){
                        set1.add(i);
                        set2.add(j);
                    }
                }
            }
            int k=0;
            boolean found = false;
            while(true){
                for(int i=0; i<n; ++i){
                    for(int j=0; j<m; ++j){
                        if(arr[i][j] == 0 && !set1.contains(i) && !set2.contains(j)){
                            arr[i][j] = 1;
                            set1.add(i);
                            set2.add(j);
                            found = true;
                            break;
                        }
                    }
                    if(found) break;
                }
                if(!found && k%2 ==0){
                    System.out.println("Vivek");
                    break;
                }
                if(!found && k%2 !=0){
                    System.out.println("Ashish");
                    break;
                }
                k++;
                found = false;
            }
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
