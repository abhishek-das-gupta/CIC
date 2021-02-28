package com.codeforces.greedy.twins;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Solution {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] nums = new int[n];
        int sum = 0;
        String s = br.readLine();
        for(int i=0; i<n; ++i){
            nums[i] = Integer.parseInt(s.split(" ")[i]);
            sum += nums[i];
        }
        Arrays.sort(nums);
        int res = 0;
        int curr = 0;
        for(int i=n-1; i>=0; i--){
            if(curr > sum/2) break;
            curr += nums[i];
            res++;
        }
        System.out.println(res);

    }
}
