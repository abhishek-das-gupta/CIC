package com.codeforces.lessthan1300.beautifulmatrix;

import java.util.Scanner;

public class Solution {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        for(int i=1;i<=5; ++i){
            for(int j=1; j<=5; ++j){
                int x = sc.nextInt();
                if(x == 1){
                    System.out.println(Math.abs(i-3) + Math.abs((j-3)));
                    break;
                }
            }
        }
    }
}
