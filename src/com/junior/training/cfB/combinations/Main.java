package com.junior.training.cfB.combinations;

import java.util.Scanner;

public class Main {
    static long M = 0x7fffffff;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();
        while(true){
            long n = sc.nextLong();
            long m = sc.nextLong();
            if(n == 0 && m == 0) break;
            long a = fact(n); long b = fact((n-m) % M); long c = fact(m);
            long d = (b*c) % M;
            long ans = divide(a,d);
            sb.append(n + " things taken " + m + " at a time is " + ans + " exactly."+"\n");
        }
        System.out.print(sb);
    }
    public static long fact(long N){
        long ans = 1;
        for(int i=1; i<=N; ++i)
            ans = (ans * i) % M;
        return ans;
    }
    public static long divide(long a, long b){
        return a * pow(b,M-2) % M;
    }
    public static long pow(long a, long b){
        long res = 1;
        while(b > 0){
            if(b % 2 == 1) res = (res*a) % M;
            a = (a*a) % M;
            b /=2;
        }
        return res;
    }


}
