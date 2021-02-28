package com.codeforces.greedy.dominopilling;


import java.util.Scanner;

public class Main {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int m = sc.nextInt();
        int n = sc.nextInt();
        int res = 0;
        res += (m/2) *n;
        if(m%2 != 0){
            res += n/2;
        }
        System.out.println(res);
    }
}
