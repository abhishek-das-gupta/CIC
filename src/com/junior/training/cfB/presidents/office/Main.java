package com.junior.training.cfB.presidents.office;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) {
        FastScanner fs = new FastScanner();
        int n = fs.nextInt();
        int m = fs.nextInt();
        char c = fs.next().charAt(0);
        //System.out.println(c);
        char[][] arr = new char[n][m];
        for(int i=0; i<n; ++i){
            String[] str = fs.next().split("");
            for(int j=0; j<m; ++j){
                arr[i][j] = str[j].charAt(0);
            }
        }
//        for(int i=0; i<n; ++i)
//            System.out.println(Arrays.toString(arr[i]));
        int[][] shifts = {{-1,0},{0,1},{1,0},{0,-1}};
        Set<Character> set = new HashSet<>();
        int ans = 0;
        for(int i=0; i<n; ++i){
            for(int j=0; j<m; ++j) {
                if (arr[i][j] == '.' || arr[i][j] == c) continue;
                if (set.contains(arr[i][j])) continue;
                for (int[] shift : shifts) {
                    int dx = i + shift[0];
                    int dy = j + shift[1];
                    if (dx < 0 || dx >= n || dy < 0 || dy >= m) continue;
                    if (arr[dx][dy] == c) {
                        set.add(arr[i][j]);
                        ans++;
                        break;
                    }
                }
            }
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