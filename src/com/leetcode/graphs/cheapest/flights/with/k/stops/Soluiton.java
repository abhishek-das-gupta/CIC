package com.leetcode.graphs.cheapest.flights.with.k.stops;

import java.util.*;

class Solution {
    Map<Integer,List<int[]>> mp = new HashMap<>();
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int K) {
        for(int[] f : flights){
            mp.putIfAbsent(f[0],new ArrayList<>());
            mp.get(f[0]).add(new int[]{f[1],f[2]});
        }
        return dfs(src,dst,0,K);
    }

    private int dfs(int u, int v, int cost, int K){
        if(K == -1){
            if(u==v){
                return cost;
            }else{
                return Integer.MAX_VALUE;
            }
        }
        if(u == v){
            return cost;
        }

        int res = Integer.MAX_VALUE;
        for(int[] adj : mp.getOrDefault(u,new ArrayList<>())){
            res = Math.min(res, dfs(adj[0],v,cost+adj[1],K-1));
        }
        System.out.println(u + " " + v + " " + K +  " " + res);
        return res;

    }

    public static void main(String[] args) {
        int[][] flights = {{0,1,100},{1,2,100},{0,2,500}};
        Solution s = new Solution();
        System.out.println(s.findCheapestPrice(3,flights,0,2,0));
    }
}