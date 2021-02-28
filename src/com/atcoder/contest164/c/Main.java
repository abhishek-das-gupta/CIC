package com.atcoder.contest164.c;

import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Set<String> set = new HashSet<>();
        int n = Integer.parseInt(br.readLine());
        String[] str = new String[n];
        for(int i=0; i<n; ++i)
            str[i] = br.readLine();
        Arrays.sort(str);
        set.addAll(Arrays.asList(str));
        System.out.println(set.size());
    }
}
