package com.codeforces.greedy.kingsshortestpath;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        String src = "b2";
        String dst = "b4";
        int s_r = 8-(src.charAt(1)-'0');
        int s_c = src.charAt(0)-'a';
        int d_r = 8-(dst.charAt(1)-'0');
        int d_c = dst.charAt(0)-'a';

        final int[][] shifts = {
                {-1,0}, //U
                {-1,1}, //RU
                {0,1},  //R
                {1,1},  //RD
                {1,0},  //D
                {1,-1}, //LD
                {0,-1}, //L
                {-1,-1} //LU
        };
        final String[] dir = {"U","RU","R","RD","D","LD","L","LU"};
        List<String > v = new ArrayList<>();
        int cnt = 0;
        int i = s_r, j=s_c;
        while(i != d_r  || j != d_c){
            String d = "";
            int curr_dst_x = 0;
            int curr_dst_y = 0;
            int res = Integer.MAX_VALUE;
            for(int k=0; k<8; ++k){
                int x  = i + shifts[k][0];
                int y = j + shifts[k][1];
                if(x < 0 || x > 7 || y <0 || y > 7)
                    continue;

                int dist = (d_r-x)*(d_r-x) + (d_c-y)*(d_c-y);
                if(res > dist) {
                    d = dir[k];
                    res = dist;
                    curr_dst_x = x;
                    curr_dst_y = y;
                }
            }
            i = curr_dst_x;
            j = curr_dst_y;
            cnt++;
            v.add(d);
        }
        System.out.println(cnt);
        for(String d : v){
            System.out.println(d);
        }

    }
}
