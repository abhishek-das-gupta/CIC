package com.codeforces.lessthan1300.petyaandstrings;

import java.util.Scanner;

public class Solution {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        String s1 = sc.nextLine();
        String s2 = sc.nextLine();
        int val = s1.compareToIgnoreCase(s2);
        if(val < 0){
            System.out.println(-1);
        }else if(val == 0){
            System.out.println(val);
        }else{
            System.out.println(1);
        }
    }
}
