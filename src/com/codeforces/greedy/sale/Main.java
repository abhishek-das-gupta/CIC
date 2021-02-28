package com.codeforces.greedy.sale;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] str = br.readLine().split(" ");
        int n = Integer.parseInt(str[0]);
        int m = Integer.parseInt(str[1]);
        int[] nums = new int[n];
        str = br.readLine().split(" ");
        for(int i=0; i<n; ++i)
            nums[i] = Integer.parseInt(str[i]);
        Arrays.sort(nums);
        int i=0;
        int res = 0;
        int min = Math.min(m,n);
        while(i < min){
            if(nums[i] < 0) res+= -nums[i];
            else if(nums[i] >0){
                break;
            }
            i++;
        }
        System.out.println(res);
    }
}
