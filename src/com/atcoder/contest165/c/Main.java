package com.atcoder.contest165.c;

import java.io.*;
import java.util.*;

public class Main {
    static int res = 0;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] str = br.readLine().split(" ");
        int n = Integer.parseInt(str[0]);
        int m = Integer.parseInt(str[1]);
        int q = Integer.parseInt(str[2]);

        int[][] Q = new int[q][5];
        for(int i=0; i<q; ++i){
            str = br.readLine().split(" ");
            for(int j=1; j<=4; ++j){
                Q[i][j] = Integer.parseInt(str[j-1]);
            }
        }
        dfs(0,new ArrayList<>(n), n,m,q,Q);
        System.out.println(res);
    }
    public static void dfs(int idx, List<Integer> A, int n,int m, int q,int[][] Q){
        if(idx == n){
            if(A.size() < n) return;
            int score = 0;
            for(int i=0; i<q; ++i){
                if(A.get(Q[i][2]-1) - A.get(Q[i][1]-1) == Q[i][3])
                    score += Q[i][4];
            }
            res = Math.max(res, score);
            return;
        }
        int val = 1;
        if(idx-1 >= 0) {
            val = A.get(idx - 1);
        }
        for(int i=val; i<=m; ++i){
            A.add(i);
            dfs(idx+1,A,n,m,q,Q);
            A.remove(A.size()-1);
        }
    }
}
