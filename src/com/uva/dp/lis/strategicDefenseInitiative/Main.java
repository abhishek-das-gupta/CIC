package com.uva.dp.lis.strategicDefenseInitiative;

import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        int count = 0;
        for(int k=0; k<t; ++k){
            if(count == 0) {
                br.readLine();
                count++;
            }
            String s;
            List<Integer> v = new ArrayList<>();
            while(true){
                s = br.readLine();
                if(s==null || s.equals("")) break;
                v.add(Integer.parseInt(s));
            }
            int n = v.size();
            int[] I = new int[n+1];
            Arrays.fill(I, Integer.MAX_VALUE);
            I[0] = Integer.MIN_VALUE;
            int[] L = new int[n];
            int idx = -1;
            int lis = 0;

            for(int i=0; i<n; ++i){
                int l = 0,r=n;

                while(l <= r){
                    int mid = l + (r-l)/2;
                    if(I[mid] < v.get(i))
                        l = mid+1;
                    else
                        r = mid-1;
                }
                L[i] = l;
                I[l] = v.get(i);
                if(lis <= l){
                    lis = l;
                    idx = i;
                }
            }
            int[] res = new int[lis];
            int top = lis-1;
            res[top--] = v.get(idx);

            for(int j=idx-1; j>=0; --j){
                if(v.get(j) < v.get(idx) && L[idx] == L[j]+1){
                    idx = j;
                    res[top--] = v.get(idx);
                }
            }
            System.out.println("Max hits: " + lis);
            for(int x : res)
                System.out.println(x);
            if(k < t-1)
                System.out.println();
        }

    }
}
