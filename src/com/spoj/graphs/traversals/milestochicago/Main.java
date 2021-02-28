package com.spoj.graphs.traversals.milestochicago;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.DecimalFormat;
import java.util.*;

public class Main {
    static class ii{
        int v;
        double p;
        public ii(int v, double p){
            this.v=v;
            this.p=p;
        }
        public String toString(){
            return "{" + v + ", " + p + "}";
        }

    }
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        int n = Integer.parseInt(s.split(" ")[0]);
        int e = Integer.parseInt(s.split(" ")[1]);
        Map<Integer, List<int[]>> mp = new HashMap<>();
        for(int i=0; i<e; ++i){
            String s1 = br.readLine();
            int u = Integer.parseInt(s1.split(" ")[0]);
            int v = Integer.parseInt(s1.split(" ")[1]);
            int w = Integer.parseInt(s1.split(" ")[2]);
            mp.putIfAbsent(v, new ArrayList<>());
            mp.putIfAbsent(u, new ArrayList<>());
            mp.get(u).add(new int[]{v,w});
            mp.get(v).add(new int[]{u,w});
        }
        double[] d = new double[n+1];
        DecimalFormat numberFormat = new DecimalFormat("#.000000");
        d[1] = (double) Math.round((1.0) * 1000000d) / 1000000d;
        System.out.println(d[1]);
        double res = 1.0;
        PriorityQueue<ii> pq = new PriorityQueue<ii>((ii p1, ii p2) -> (int) (p2.p-p1.p));
        Set<Integer> set = new HashSet<>();
        pq.add(new ii(1,1.0));
        set.add(1);
        while(!pq.isEmpty()){
            ii curr = pq.poll();
            int u = curr.v;
            double p_u = curr.p;
            for(int[] adj : mp.get(u)){
                int v = adj[0]; int w = adj[1];
                if(v == n){
                    System.out.println(p_u*w/100.0);
                    break;
                }
                if(!set.contains(v) && d[v] < p_u*w/100.0){
                    pq.add(new ii(v, p_u*w/100.0));
                    set.add(v);
                }
            }
            for(Object o : pq.toArray()){
                ii pair = (ii) o;
                System.out.print(pair.toString() + ", ");
            }
            System.out.println();
        }


    }
}
