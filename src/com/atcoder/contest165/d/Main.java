package com.atcoder.contest165.d;

import java.util.Scanner;

public class Main {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        long a = sc.nextLong();
        long b = sc.nextLong();
        long n = sc.nextLong();

        long ans = 0;
        for(int x=0; x<=n; ++x){
            ans = (long) Math.max(Math.floor(a*x/b)-a*Math.floor(x/b),ans);
        }
        System.out.println(ans);
    }
}
