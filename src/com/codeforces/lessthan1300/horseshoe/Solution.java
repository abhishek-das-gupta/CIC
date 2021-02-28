package com.codeforces.lessthan1300.horseshoe;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Solution {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        int[] nums = new int[4];
        for(int i=0; i<4; ++i)
            nums[i] = Integer.parseInt(s.split(" ")[i]);
        Arrays.sort(nums);
        int res=0;
        for(int i=1; i<4; ++i)
            if(nums[i-1]==nums[i])
                res++;
        System.out.println(res);
    }
}
