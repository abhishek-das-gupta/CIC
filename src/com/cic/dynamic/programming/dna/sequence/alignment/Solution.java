package com.cic.dynamic.programming.dna.sequence.alignment;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Solution {

    public void minCost(String s1, String s2){
        int[][] dp = new int[s1.length()+1][s2.length()+1];

        dp[0][0] = 0;
        for(int j=1; j<=s2.length(); j++){
            dp[0][j] = j;
        }

        for(int i=1; i<=s1.length(); i++){
            dp[i][0] = i;
        }

        for(int i=1; i<=s1.length(); i++){
            for(int j=1; j<=s2.length(); j++){
                if(s1.charAt(i-1) == s2.charAt(j-1)){
                    dp[i][j] = dp[i-1][j-1];
                }
                else{
                    int mismatch = 0 + dp[i-1][j-1];
                    int gapAtS1 = 1 + dp[i][j-1];
                    int gapAtS2 = 1 + dp[i-1][j];
                    dp[i][j] = Math.min(mismatch, Math.min(gapAtS1,gapAtS2));
                }
            }
        }

        List<String> align1 = new LinkedList<>();
        List<String> aling2 = new LinkedList<>();
        //backTrack(s1.length(),s2.length(),dp,align1 ,align2);
        //System.out.println(align.toString());
    }

//    private void backTrack(int dex1, int dex2, int[][] dp, List<String> align1 , List<String> aling2,String s1, String s2){
//        if(dex1 == 0 && dex2 == 0){
//            return;
//        }
//
//        int minCost = Integer.MAX_VALUE;
//        String cost = "";
//        int i=0,j=0;
//        if(minCost > dp[dex1-1][dex2]){
//            /**gap at s2*/
//            minCost = dp[dex1-1][dex2];
//            i = dex1-1;
//            j = dex2;
//            cost = "gap at s2";
//        }
//        if(minCost > dp[dex1][dex2-1]){
//            /**gap at s1*/
//            minCost = dp[dex1][dex2-1];
//            i = dex1;
//            j = dex2;
//            cost = "gap at s1";
//        }
//        if(minCost > dp[dex1-1][dex2-1]){
//            /**mistatch at s1 and s2*/
//            i = dex1-1;
//            j = dex2-1;
//            cost = "mismatch";
//        }
//
//        if(cost.equals("gap at s2")){
//            al;
//        }
//
//        backTrack(i,j,dp,align1,aling2,s1,s2);
//
//    }
}
