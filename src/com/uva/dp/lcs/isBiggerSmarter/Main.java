package com.uva.dp.lcs.isBiggerSmarter;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s;
        Map<Integer, Stack<Integer>> mp1 = new HashMap<>();
        Map<Integer,Stack<Integer>> mp2 = new HashMap<>();
        int k=1;
        while(true){
            s = br.readLine();
            if(s == null || s.equals("")) break;
            String[] str = s.split(" ");
            int w = Integer.parseInt(str[0]);
            int iq = Integer.parseInt(str[1]);
            mp1.putIfAbsent(w, new Stack<>());
            mp1.get(w).add(k);
            mp2.putIfAbsent(iq, new Stack<>());
            mp2.get(iq).add(k);
            k++;
        }
        List<Integer> w = new ArrayList<>(mp1.keySet());
        Collections.sort(w);
        List<Integer> a = new ArrayList<>();
        for(int j=0; j<w.size(); ++j){
            Stack<Integer> q = mp1.get(w.get(j));
            while(!q.isEmpty()) a.add(q.pop());
        }
        List<Integer> iq = new ArrayList<>(mp2.keySet());
        Collections.sort(iq,Collections.reverseOrder());
        List<Integer> b = new ArrayList<>();
        for(int j=0; j<iq.size(); ++j){
            Stack<Integer> q = mp2.get(iq.get(j));
            while(!q.isEmpty()) b.add(q.pop());
        }

        //System.out.println(a.toString() + " " + b.toString());
        int[][] dp = new int[a.size()+1][b.size()+1];
        for(int i=0; i<=a.size(); ++i){
            for(int j=0; j<=b.size(); ++j){
                if(i==0 || j==0) dp[i][j] = 0;
                else if(a.get(i-1) ==  b.get(j-1)) dp[i][j] = 1+dp[i-1][j-1];
                else dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
            }
        }
        System.out.println(dp[a.size()][b.size()]);
        int i = a.size();
        int j = b.size();
        StringBuilder sb = new StringBuilder("");
        while(i >0 && j > 0){
            if(a.get(i-1) == b.get(j-1)){
                sb.insert(0, b.get(j-1)+"\n");
                i--;
                j--;
            }
            else if(dp[i-1][j] >= dp[i][j-1]){
                i--;
            }
            else{
                j--;
            }
        }
        sb.deleteCharAt(sb.length()-1);
        System.out.print(sb.toString());
    }
}
