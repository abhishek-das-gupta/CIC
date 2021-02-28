package com.spoj.graphs.traversals.benefact;

import java.io.*;
import java.util.*;
import java.lang.*;

public class Main {
    static class Pair{
        int v;
        int w;
        public Pair(int v, int w){
            this.v = v;
            this.w = w;
        }
        public String toString(){
          return "("  + this.v + ", " + this.w + ")";
        }
    }
    static int res = 0;
    static int farthest = 0;
    public static void main(String[] args) throws java.lang.Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        while(t-- != 0) {
            int n = Integer.parseInt(br.readLine());
            Map<Integer, List<Pair>> mp = new HashMap<>();
            for (int i = 1; i <=n; ++i)
                mp.put(i, new ArrayList<Pair>());

            for(int i=0; i<n-1; ++i){
                String[] arr = br.readLine().split(" ");
                int src = Integer.parseInt(arr[0]);
                int dst = Integer.parseInt(arr[1]);
                int w = Integer.parseInt(arr[2]);
                mp.get(src).add(new Pair(dst,w));
                mp.get(dst).add(new Pair(src,w));
            }
            dfs(new Pair(1,0),new HashSet<>(),mp);
            dfs(new Pair(farthest,0),new HashSet<>(), mp);
            System.out.println(res);
            res=0;
            farthest=0;
        }
    }
    public static void dfs(Pair curr, Set<Integer> set, Map<Integer,List<Pair>> mp){
        set.add(curr.v);
        for(Pair adj : mp.get(curr.v)){
            if(!set.contains(adj.v)){
                if(res < curr.w + adj.w){
                    farthest = adj.v;
                    res = curr.w + adj.w;
                }
                dfs(new Pair(adj.v,curr.w+adj.w),set,mp);
            }
        }
        set.remove(curr.v);
    }
}
