package com.codeforces.lessthan1300.nearlyluckynumber;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        int cnt = 0;
        for(int i=0; i<s.length(); ++i)
            if(s.charAt(i) == '4' || s.charAt(i) == '7')
                cnt++;
        if(cnt == 4 || cnt == 7)
            System.out.println("YES");
        else
            System.out.println("NO");
    }
}
