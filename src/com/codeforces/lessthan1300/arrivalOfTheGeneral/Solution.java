package com.codeforces.lessthan1300.arrivalOfTheGeneral;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int max = Integer.MIN_VALUE,maxIdx = 0,min =Integer.MAX_VALUE, minIdx = 0;
        int[] arr = new int[n];
        String s = br.readLine();
        for(int i=0; i<n; ++i) {
            arr[i] = Integer.parseInt(s.split(" ")[i]);
            if(max < arr[i]){
                max = arr[i];
                maxIdx = i;
            }
        }
        for(int i=n-1; i>=0; i--){
            if(min > arr[i]){
                min = arr[i];
                minIdx = i;
            }
        }
        int res = 0;
        if(maxIdx < minIdx){
            res += maxIdx;
            res += n-1-minIdx;
        }else{
            res += maxIdx - minIdx;
            res += minIdx;
            minIdx++;
            res += n-1-minIdx;
        }
        System.out.println(res);

    }
}
