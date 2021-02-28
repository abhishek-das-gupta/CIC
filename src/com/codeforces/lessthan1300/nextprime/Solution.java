package com.codeforces.lessthan1300.nextprime;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] arr = br.readLine().split(" ");
        int a = Integer.parseInt(arr[0]);
        int b = Integer.parseInt(arr[1]);
        if(!isPrime(b)){
            System.out.println("NO");
            return;
        }
        if(b-a == 1){
            System.out.println("YES");
            return;
        }
        a = a+1;
        while(a < b){
            if(isPrime(a)){
                System.out.println("NO");
                return;
            }
            a++;
        }
        System.out.println("YES");
        return;
    }
    public static boolean isPrime(int n){
        if(n <= 1)
            return false;
        for(int i=2; i<n; ++i) {
            if(n%i == 0)
                return false;
        }
        return true;
    }
}
