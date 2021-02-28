package com.atcoder.contest163.b;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] str = br.readLine().split(" ");
        int n = Integer.parseInt(str[0]);
        int m = Integer.parseInt(str[1]);
        str = br.readLine().split(" ");
        for(int i=0; i<m ; ++i){
            n -= Integer.parseInt(str[i]);
        }
        if(n < 0){
            System.out.println(-1);
        }else{
            System.out.println(n);
        }
    }
}
