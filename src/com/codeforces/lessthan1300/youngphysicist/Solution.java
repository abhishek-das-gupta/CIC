package com.codeforces.lessthan1300.youngphysicist;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        int x = 0, y=0, z = 0;
        while(t-- != 0){
            x += sc.nextInt();
            y += sc.nextInt();
            x += sc.nextInt();
        }

        if(x==0 && y==0 && z==0)
            System.out.println("YES");
        else
            System.out.println("NO");
    }
}
