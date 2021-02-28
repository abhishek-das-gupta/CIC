package com.codeforces.lessthan1300.beautifulyear;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        while(true){
            n++;
            if(isDistinct(n)){
                System.out.println(n);
                break;
            }
        }
    }
    public static boolean isDistinct(int n){
        Set<Integer> s = new HashSet<>();
        while(n != 0){
            if(s.contains(n % 10))
                return false;
            s.add(n%10);
            n /= 10;
        }
        return true;
    }
}
