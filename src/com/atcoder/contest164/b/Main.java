package com.atcoder.contest164.b;

import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int A = sc.nextInt();
        int B = sc.nextInt();
        int C = sc.nextInt();
        int D = sc.nextInt();

        boolean turn = true;
        while(true){
            if(turn){
                C -= B;
                turn = false;
            }else{
                A -= D;
                turn = true;
            }
            if(C <= 0) {
                System.out.println("Yes");
                break;
            }
            if(A <= 0) {
                System.out.println("No");
                break;
            }
        }


    }
}