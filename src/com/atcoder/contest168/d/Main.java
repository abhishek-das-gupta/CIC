package com.atcoder.contest168.d;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] s = br.readLine().split(" ");
        int n = Integer.parseInt(s[0]);
        int m = Integer.parseInt(s[1]);
        Map<Integer, List<Integer>> mp = new HashMap<>();
        for(int i=1; i<=n; ++i) mp.putIfAbsent(i, new ArrayList<>());
        boolean ok = false;
        for(int i=1; i<=m; ++i){
            s = br.readLine().split(" ");
            int u = Integer.parseInt(s[0]);
            int v = Integer.parseInt(s[1]);
            if(u == 1 || v == 1) ok = true;
            mp.get(u).add(v);
            mp.get(v).add(u);
        }
        if(!ok){
            System.out.println("No");
            return;
        }
        int[] sign = new int[n+1];
        Queue<Integer> q = new LinkedList<>();
        Set<Integer> set = new HashSet<>();
        q.add(1);
        set.add(1);
        while(!q.isEmpty()){
            int curr = q.poll();
            for(int v : mp.getOrDefault(curr, new ArrayList<>())){
                if(!set.contains(v)){
                    sign[v] = curr;
                    set.add(v);
                    q.add(v);
                }
            }
        }

        System.out.println("Yes");
        for(int i=2; i<=n; ++i){
            System.out.println(sign[i]);
        }
    }

}
