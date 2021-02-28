package com.junior.training.cfB.keyboard;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        FastScanner fs = new FastScanner();
        int n = fs.nextInt();
        int m = fs.nextInt();
        int x = fs.nextInt();

        char[][] keys = new char[n][m];
        for(int i=0; i<n; ++i){
            String s = fs.next();
            for(int j=0; j<m; ++j){
                keys[i][j] = s.charAt(j);
            }
        }

        boolean[] oneHandLetters = new boolean[26];
        boolean[] isLetterPresent = new boolean[26];
        int shift = 0;

        for(int i=0; i<n; ++i){
            for(int j=0; j<m; ++j){
                if(keys[i][j] == 'S'){
                    shift++;
                    for(int k=0; k<n; ++k){
                        for(int l=0; l<m; ++l){
                            if(keys[k][l] != 'S' && (k-i)*(k-i) + (l-j)*(l-j) <= x*x){
                                oneHandLetters[keys[k][l]-'a'] = true;
                            }
                        }
                    }
                }
                else{
                    isLetterPresent[keys[i][j]-'a'] = true;
                }
            }
        }

        int l = fs.nextInt();
        char[] arr = fs.next().toCharArray();
        long ans = 0;
        for(char c : arr){
            if(Character.isLowerCase(c)){
                if(!isLetterPresent[c-'a']) {
                    System.out.println(-1);
                    return;
                }
            }
            else{
                char cc = Character.toLowerCase(c);
                if(shift == 0 || !isLetterPresent[cc-'a']){
                    System.out.println(-1);
                    return;
                }
                if(!oneHandLetters[cc-'a']){
                    ans++;
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
