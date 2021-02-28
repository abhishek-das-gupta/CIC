package com.codeforces.lessthan1300.iLoveUsername;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int i=0;
        int max=-1,min=-1;
        int res = 0;
        String s = br.readLine();
        while(i < n ){
            if(i==0){
                max = Integer.parseInt(s.split(" ")[i]);
                min = max;
            }
            else{
                int curr = Integer.parseInt(s.split(" ")[i]);
                if(curr > max){
                    res++;
                    max = curr;
                }else if(curr < min){
                    res++;
                    min = curr;
                }
            }
            i++;
        }
        System.out.println(res);
    }
}
