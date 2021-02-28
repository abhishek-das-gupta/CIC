package com.spoj.dp.lis.elis;

import java.util.*;
import java.io.*;

class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        String[] str =  br.readLine().split(" ");
        int[] arr = new int[n];
        for(int i=0; i<n; ++i)
            arr[i] = Integer.parseInt(str[i]);

        int[] I = new int[n+1];
        Arrays.fill(I, Integer.MAX_VALUE);
        I[0] = Integer.MIN_VALUE;
        int[] L = new int[n];
        int lis = 0;

        for(int i=0; i<n; ++i){
            int l=0,r=n;

            while(l <= r){
                int mid = l + (r-l)/2;
                if(I[mid] < arr[i])
                    l = mid+1;
                else
                    r = mid-1;
            }
            L[i] = l;
            I[l] = arr[i];
            if(lis < l)
                lis = l;
        }
        System.out.println(lis);
    }
}
