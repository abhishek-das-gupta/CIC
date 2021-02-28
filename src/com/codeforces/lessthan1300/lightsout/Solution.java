package com.codeforces.lessthan1300.lightsout;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Solution {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[][] nums = new int[3][3];
        for(int i=0; i<3; ++i)
            Arrays.fill(nums[i],1);
        for(int i=0; i<3; ++i){
            String[] arr = br.readLine().split(" ");
            for(int j=0; j<3; ++j){
                int x = Integer.parseInt(arr[j]);
                if(x % 2 != 0){
                    nums[i][j] = nums[i][j] == 1 ? 0 : 1;
                    if(i-1 >=0)
                        nums[i-1][j] = nums[i-1][j] == 1 ? 0 : 1;
                    if(j+1 < 3)
                        nums[i][j+1] = nums[i][j+1] == 1 ? 0 : 1;
                    if(i+1 < 3)
                        nums[i+1][j] = nums[i+1][j] == 1 ? 0 : 1;
                    if(j-1 >= 0)
                        nums[i][j-1] = nums[i][j-1] == 1 ? 0 : 1;
                }
            }

        }
        for(int i=0; i<3; i++){
            for(int j=0; j<3; j++)
                System.out.print(nums[i][j]);
            System.out.println();
        }
    }
}
