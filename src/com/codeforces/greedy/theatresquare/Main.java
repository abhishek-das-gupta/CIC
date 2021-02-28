package com.codeforces.greedy.theatresquare;

import java.util.Scanner;

public class Main {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int a = sc.nextInt();
        int res =0;
        if(m % 4 == 0){
            res += (n/4) * (m/4);
            res += (n%4) * (m/4);
        }else{
            res += (n/4)*(m/4);
            res += (n%4)*(m%4);
        }
        System.out.println(res);
    }
}
