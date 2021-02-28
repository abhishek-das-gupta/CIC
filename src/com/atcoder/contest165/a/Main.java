package com.atcoder.contest165.a;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args){
        Scanner sc =new Scanner(System.in);
        int k = sc.nextInt();
        int a = sc.nextInt();
        int b = sc.nextInt();

        boolean ok = false;
        if(a %k ==0 || b%k == 0) ok = true;
        if(!ok){
            int r = a % k;
            int temp = a- r;
            for(int i=temp; i<b; i+=k){
                if(i > a && i%k == 0){
                    ok = true;
                    break;
                }
            }

        }
        if(ok) System.out.println("OK");
        else System.out.println("NG");
    }
}
