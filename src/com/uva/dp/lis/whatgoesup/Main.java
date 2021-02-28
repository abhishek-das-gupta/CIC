package com.uva.dp.lis.whatgoesup;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        List<Integer> v = new ArrayList<>();
        String s;
        while(true){
            s = br.readLine();
            if(s == null || s.equals("")) break;
            v.add(Integer.parseInt(s));
        }
        int n = v.size();
        int lis = 0;
        int[] I = new int[n+1];
        Arrays.fill(I, Integer.MAX_VALUE);
        I[0] = Integer.MIN_VALUE;
        int[] L = new int[n];
        int idx = -1;

        for(int i=0; i<n; ++i){
            int l=0, r=n;

            while(l <=r) {
                int mid = l + (r-l)/2;
                if(I[mid] < v.get(i))
                    l = mid+1;
                else
                    r = mid-1;
            }
            I[l] = v.get(i);
            L[i] = l;
            if(lis <= l){
                lis = l;
                idx = i;
            }
        }
        int[] res = new int[lis];
        int top = lis-1;
        res[top--] = v.get(idx);
        for(int j=idx-1; j>=0; --j){
            if(v.get(j) < v.get(idx) && L[j] == L[idx]-1){
                idx = j;
                res[top--] = v.get(idx);
            }
        }
        System.out.println(lis + "\n"+"-");
        for(int x : res)
            System.out.println(x);
    }
}
