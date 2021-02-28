package com.codeforces.greedy.dragons;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Solution {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        int S = Integer.parseInt(s.split(" ")[0]);
        int n = Integer.parseInt(s.split(" ")[1]);
        List<int[]> vii = new ArrayList<>(n);
        for(int i=0; i<n; i++){
            s = br.readLine();
            vii.add(new int[]{Integer.parseInt(s.split(" ")[0]),Integer.parseInt(s.split(" ")[1])});
        }
        Collections.sort(vii, (int[] a, int[] b) -> a[0]-b[0]);
        for(int[] d : vii){
            if(S <= d[0]){
                System.out.println("NO");
                return;
            }
            S +=d[1];
        }
        System.out.println("YES");
    }
}
