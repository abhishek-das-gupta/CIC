package com.codeforces.lessthan1300.cupboards;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Solution {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int t = 0;
        List<int[]> vii = new ArrayList<>();
        int l_closed = 0;
        int r_closed = 0;
        int i=0;
        while(i++ < n){
            String s = br.readLine();
            int l = Integer.parseInt(s.split(" ")[0]);
            if(l == 0){
                l_closed++;
            }
            int r = Integer.parseInt(s.split(" ")[1]);
            if(r == 0){
                r_closed++;
            }
            vii.add(new int[]{l,r});
        }
        int lState = l_closed >= n-l_closed ? 0 : 1;
        int rState = r_closed >= n-r_closed ? 0 : 1;
        for(int[] ii : vii){
            if(ii[0] != lState)
                t++;
            if(ii[1] != rState)
                t++;
        }
        System.out.println(t);
    }
}
