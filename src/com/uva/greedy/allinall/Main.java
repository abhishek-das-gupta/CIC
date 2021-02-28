package com.uva.greedy.allinall;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class Main
{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str;

        while((str = br.readLine()) != null){
            String s = str.split(" ")[0]; int n = s.length();
            String t = str.split(" ")[1]; int m = t.length();
            int i=0,j=0;
            while(true) {
                if (s.charAt(i) == t.charAt(j)) {
                    i++;
                    j++;
                } else {
                    j++;
                }
                if (j == m) {
                    if (i == n) {
                        System.out.println("Yes");
                        break;
                    } else {
                        System.out.println("No");
                        break;
                    }
                }
                if (i == n) {
                    System.out.println("Yes");
                    break;
                }
            }
        }
    }
}