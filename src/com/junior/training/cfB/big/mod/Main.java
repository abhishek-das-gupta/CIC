package com.junior.training.cfB.big.mod;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s;
        while((s=br.readLine()) != null){
            long a = Integer.parseInt(s);
            long b = Long.parseLong(br.readLine());
            long M = Long.parseLong(br.readLine());
            long r = 1;

            while(b > 0){
                if(b % 2 == 1) r = (r*a) % M;
                a = (a*a) % M;
                b /= 2;
            }
            System.out.println(r % M);
            br.readLine();
        }
    }
}
