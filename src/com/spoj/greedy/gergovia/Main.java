package com.spoj.greedy.gergovia;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        try{
            while(true){
                int n = Integer.parseInt(br.readLine());
                if(n == 0)  break;
                int[] nums = new int[n];
                String str = br.readLine();
                for(int i=0; i<n; ++i)
                    nums[i] = Integer.parseInt(str.split(" ")[i]);

                int s=0,b=0;
                int res = 0;
                while(true){
                    while(s < n && nums[s] >=0) s++;
                    while(b < n && nums[b] <=0) b++;

                    if(b==n || s == n) break;

                    int dist = Math.abs(b-s);
                    int min = Math.min(nums[b], -nums[s]) ;
                    nums[b] -= min;
                    nums[s] += min;
                    res += min * dist;
                }
                System.out.println(res);
            }
        }catch(Exception e){
            e.printStackTrace();
        }

    }
}
