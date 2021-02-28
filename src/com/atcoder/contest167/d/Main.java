package com.atcoder.contest167.d;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] str = br.readLine().split(" ");
        int n = Integer.parseInt(str[0]);
        long k = Long.parseLong(str[1]);
        str = br.readLine().split(" ");

        int[] arr = new int[n+1];
        for(int i=1; i<=n; ++i)
            arr[i] = Integer.parseInt(str[i-1]);

        int[] next = new int[n+1];
        Arrays.fill(next, -1);

        int i = 1;
        List<Integer> steps = new ArrayList<>();
        while(next[i] == -1){
            next[i] = arr[i];
            i = next[i];
            steps.add(i);
        }
        if(k <= steps.size()){
            System.out.println(steps.get((int)k-1));
            return;
        }
        int start = i;
        i = arr[i];
        int len = 1;
        while(i != start){
            len++;
            i = arr[i];
        }
        int stepsTakenBeforeCycle = steps.size() - len;
        k -= stepsTakenBeforeCycle;
        k %= len;
        i = start;
        while(k-- != 0){
            i = arr[i];
        }
        System.out.println(i);


    }
}
