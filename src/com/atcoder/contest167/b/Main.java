package com.atcoder.contest167.b;

import java.util.Scanner;

public class Main {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        long a = sc.nextLong();
        long b = sc.nextLong();
        long c = sc.nextLong();
        long k = sc.nextLong();

        long sum =0;
        while(a >0 && k>0){
            sum++;
            a--;k--;
        }
        while(b > 0 && k>0){
            b--;
            k--;
        }
        while(c > 0 && k>0){
            sum--;
            c--;k--;
        }
        System.out.println(sum);
    }
}
