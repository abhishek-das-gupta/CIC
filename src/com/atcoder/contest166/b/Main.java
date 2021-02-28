package com.atcoder.contest166.b;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] str = br.readLine().split(" ");
        int N = Integer.parseInt(str[0]);
        int K = Integer.parseInt(str[1]);
        List<List<Integer>> A = new ArrayList<>(K);
        for(int i=0; i<K; ++i){
            A.add(new ArrayList<>());
            int d = Integer.parseInt(br.readLine());
            str = br.readLine().split(" ");
            for(int j=0; j<d; ++j)
                A.get(i).add(Integer.parseInt(str[j]));
        }
        int res = 0;
        for(int i=1; i<=N; ++i){
            boolean have = false;
            for(List<Integer> snack : A){
                for(int j=0; j<snack.size(); ++j){
                    if(snack.get(j) == i){
                        have = true;
                        break;
                    }
                }
                if(have) break;
            }
            if(!have) res++;
        }
        System.out.println(res);
    }
}
