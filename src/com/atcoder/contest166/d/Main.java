package com.atcoder.contest166.d;

import java.util.Scanner;

public class Main {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        long x = sc.nextLong();
        boolean found = false;
        for(int i=-1000; i<=1000; ++i){
            for(int j=-1000; j<=1000; ++j){
                long a = (long) Math.pow(i,5);
                long b = (long) Math.pow(j,5);
                if(a - b == x){
                    System.out.println(i + " " + j);
                    found = true;
                    break;
                }
                if(found) break;
            }
        }
    }
}
