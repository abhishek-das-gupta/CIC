package com.codeforces.contest.div4.contest640.a;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t  = Integer.parseInt(br.readLine());
        while(t-- != 0){
            int n = Integer.parseInt(br.readLine());
            List<Integer> v = new ArrayList<>();
            int k=0;
            int p = 1;
            while(n !=0){
                if(n%10 != 0) {
                    ++k;
                    v.add(n%10*p);
                }
                n /= 10;
                p *= 10;
            }
            System.out.println(k);
            for(int i=0; i<v.size()-1; ++i){
                System.out.print(v.get(i) + " ");
            }
            System.out.println(v.get(v.size()-1));
        }
    }
}
