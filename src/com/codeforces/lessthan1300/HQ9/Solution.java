package com.codeforces.lessthan1300.HQ9;

import java.util.Scanner;

public class Solution {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        for(char c : sc.nextLine().toCharArray()){
            if(c == 'H' || c == 'Q' || c == '9'){
                System.out.println("YES");
                return;
            }
        }
        System.out.println("NO");
    }
}
