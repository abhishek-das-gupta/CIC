package com.atcoder.contest168.a;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String n = br.readLine();
        int l = n.charAt(n.length()-1) - '0';
        if(l == 3) System.out.println("bon");
        else if(l == 0 || l == 1 || l == 6 || l== 8) System.out.println("pon");
        else System.out.println("hon");
    }
}
