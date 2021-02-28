package com.atcoder.contest163.a;

import java.util.Scanner;

public class Main {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int r = sc.nextInt();
        double res = Math.round(2 * 3.1415*r*100)/100.0;
        System.out.println(res);
    }
}
