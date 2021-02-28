package com.junior.training.cfB.students.and.shoelaces;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        FastScanner fs = new FastScanner();
        int n = fs.nextInt();
        int m = fs.nextInt();
        Map<Integer, Set<Integer>> mp = new HashMap<>();
        int[] in = new int[n+1];
        for(int i=0; i<m; ++i){
            int a = fs.nextInt();
            int b = fs.nextInt();
            mp.putIfAbsent(a, new HashSet<>());
            mp.putIfAbsent(b, new HashSet<>());
            mp.get(a).add(b);
            mp.get(b).add(a);
            in[a]++;
            in[b]++;
        }
        Queue<Integer> q = new LinkedList<>();
        for(int k : mp.keySet()){
            if(mp.get(k).size() == 1){
                q.add(k);
            }
        }
        if(q.isEmpty()){
            System.out.println(0);
            return;
        }
        int group = 0;
        while(!q.isEmpty()){
            int size = q.size();
            group++;
            for(int i=0; i<size; ++i) {
                int cur = q.poll();
                for (int adj : mp.getOrDefault(cur,new HashSet<>())) {
                    mp.get(adj).remove(cur);
                    mp.get(cur).remove(adj);
                    in[adj]--;
                }
                in[cur]--;
            }
            for(int i=1; i<=n; ++i)
                if(in[i] == 1)
                    q.add(i);
        }
        System.out.println(group);
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
