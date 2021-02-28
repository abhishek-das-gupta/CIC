package com.codeforces.lessthan1300.softdrink;

import java.util.Scanner;

public class Solution {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        int l = sc.nextInt();
        int c = sc.nextInt();
        int d = sc.nextInt();
        int p = sc.nextInt();
        int nl = sc.nextInt();
        int np = sc.nextInt();

        int drinkToast = k*l/nl;
        int limeToast = c*d;
        int saltToast = p/np;
        int toast = Math.min(drinkToast, Math.min(limeToast,saltToast))/n;
        System.out.println(toast);
    }
}
