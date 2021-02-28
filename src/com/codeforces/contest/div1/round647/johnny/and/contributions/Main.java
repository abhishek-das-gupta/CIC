package com.codeforces.contest.div1.round647.johnny.and.contributions;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        FastScanner fs = new FastScanner();
        int n = fs.nextInt();
        int m = fs.nextInt();
        Map<Integer, List<Integer>> mp = new HashMap<>();
        for(int i=0; i<m; ++i){
            int u = fs.nextInt();
            int v = fs.nextInt();
            mp.putIfAbsent(u,new ArrayList<>());
            mp.get(u).add(v);
            mp.putIfAbsent(v,new ArrayList<>());
            mp.get(v).add(u);
        }
        int[] t = new int[n+1];
        List<int[]> arr = new ArrayList<>();
        for(int i=1; i<=n; ++i){
            t[i] = fs.nextInt();
            arr.add(new int[]{i,t[i]});
        }
        arr.sort(Comparator.comparingInt(a -> a[1]));
        boolean[] vis = new boolean[n+1];
        StringBuilder sb = new StringBuilder();
        for(int[] cur : arr){
            int ct = 0;
            for(int adj : mp.getOrDefault(cur[0],new ArrayList<>())){
                if(t[adj] == cur[1]){
                    System.out.println(-1);
                    return;
                }
                if(t[adj] < cur[1]){
                    if(!vis[t[adj]]) {
                        ct++;
                        vis[t[adj]] = true;
                    }
                }
            }
            if(ct != cur[1]-1){
                System.out.println(-1);
                return;
            }
            else{
                sb.append(cur[0]).append(' ');
            }
            for(int adj : mp.getOrDefault(cur[0],new ArrayList<>()))
                vis[t[adj]] = false;
        }
        sb.deleteCharAt(sb.length()-1);
        System.out.println(sb);
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
