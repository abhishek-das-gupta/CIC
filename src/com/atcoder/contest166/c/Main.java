package com.atcoder.contest166.c;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] str = br.readLine().split(" ");
        int n = Integer.parseInt(str[0]);
        int m = Integer.parseInt(str[1]);
        int[] h = new int[n + 1];
        int[] adj = new int[n+1];
        str = br.readLine().split(" ");
        for(int i=1; i<=n; ++i){
            h[i] = Integer.parseInt(str[i-1]);
            adj[i] = 0;
        }
        for(int i=0; i<m; ++i){
            str = br.readLine().split(" ");
            int u = Integer.parseInt(str[0]);
            int v = Integer.parseInt(str[1]);

            adj[u] = Math.max(adj[u], h[v]);
            adj[v] = Math.max(adj[v], h[u]);
        }
        int res = 0;
        for(int i=1; i<=n; ++i){
            res += h[i] > adj[i] ? 1 : 0;
        }
        System.out.println(res);
    }
}
