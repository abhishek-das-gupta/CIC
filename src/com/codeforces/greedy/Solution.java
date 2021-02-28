package com.codeforces.greedy;

import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();

        for(int i=0; i<s.length(); ++i){
            if(s.charAt(i) == '0'){
                s = s.substring(0,i) + s.substring(i+1,s.length());
                System.out.println(s);
                return;
            }
        }
        System.out.println(s.substring(0,s.length()-1));
        for(int i=0; i<100000; ++i)
            System.out.print(1 + " ");

    }
}
