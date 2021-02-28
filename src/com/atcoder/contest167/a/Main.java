package com.atcoder.contest167.a;

import java.util.Scanner;

public class Main {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        String t = sc.nextLine();
        if(s.equals(t.substring(0,t.length()-1))){
            System.out.println("Yes");
        }else{
            System.out.println("No");
        }
    }
}
