package com.codeforces.lessthan1300.helpfulmaths;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        int one=0,two=0,three=0;
        for(char c : s.toCharArray()){
            if(c=='1') one++;
            else if(c=='2') two++;
            else if(c=='3') three++;
        }
        StringBuilder res = new StringBuilder("");
        while(one != 0 || two != 0 || three != 0){
            if(one != 0){
                res.append("1+");
                one--;
            }else if(two != 0){
                res.append("2+");
                two--;
            }else{
                res.append("3+");
                three--;
            }
        }
        res.deleteCharAt(res.length()-1);
        System.out.println(res.toString());
    }
}
