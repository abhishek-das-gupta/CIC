package com.uva.dp.lis.wavioSequence;

import java.util.*;
import java.io.*;

class Main {
    public static void main(String[] args) throws IOException{
        Scanner sc = new Scanner(System.in);
        while(sc.hasNext()){
            int n = sc.nextInt();
            int[] nums = new int[n];
            for(int i=0; i<n; ++i) nums[i] = sc.nextInt();
            int[] L1 = new int[n];

            /**L1[] represents LIS ending at i**/
            LIS(nums,n,L1);

            /**reverse nums to find LIS*/
            reverse(nums);

            /**L2[] represents LIS on reverse of nums*/
            int[] L2 = new int[n];
            LIS(nums,n,L2);

            /**L2[] represents LIS ending at i starting from right to left*/
            reverse(L2);

            int ans = 0;
            for(int i=0; i<n; ++i){
                ans = Math.max(ans, Math.min(L1[i],L2[i]));
            }
            System.out.println(2*ans-1);
        }

    }
    public static void LIS(int[] nums,int n, int[] L1){
        int[] I = new int[n+1];
        Arrays.fill(I, Integer.MAX_VALUE);
        I[0] = Integer.MIN_VALUE;

        for(int i=0; i<n; ++i){
            int l=0,r=n;

            while(l <= r){
                int mid = l + (r-l)/2;
                if(I[mid] < nums[i])
                    l = mid+1;
                else
                    r = mid-1;
            }
            I[l] = nums[i];
            L1[i] = l;
        }
    }
    public static void reverse(int[] L){
        int l=0;
        int r=L.length-1;
        while(l < r){
            int temp = L[l];
            L[l++] = L[r];
            L[r--] = temp;
        }
    }
}
