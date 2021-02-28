package com.leetcode.dynamic.programming.count.vowels.permutation;

import java.util.HashMap;
import java.util.Map;

class Solution {
    long mod = 100000007;
    char[] vowels = {'a','e','i','o','u'};
    public int countVowelPermutation(int n) {
        if(n==1){
            return 5;
        }
        return dfs(n,'\0',new HashMap<String,Integer>());
    }

    private int dfs(int n, char last, Map<String,Integer> dp){
        if(n==0) {
            return 1;
        }
        if(dp.containsKey(n+","+last)){
            return dp.get(n+","+last);
        }

        int ways = 0;
        for(int i=0; i<vowels.length; i++){
            if(last=='\0'){
                ways += dfs(n--,vowels[i],dp);
            }
            else if(last=='a' && vowels[i]=='e'){
                ways += dfs(n--,vowels[i],dp);
            }
            else if(last=='e' && (vowels[i]=='a' || vowels[i]=='i')){
                ways +=dfs(n--,vowels[i],dp);
            }
            else if(last=='i' && vowels[i]!='i'){
                ways +=dfs(n--,vowels[i],dp);
            }
            else if(last=='o' && (vowels[i]=='i'||vowels[i]=='u')){
                ways +=dfs(n--,vowels[i],dp);
            }
            else if(last=='u' && vowels[i]=='a'){
                ways +=dfs(n--,vowels[i],dp);
            }
        }
        long res = ways % mod;
        dp.put(n+","+last, (int) res);
        return (int) res;
    }

    public static void main(String[] args){
        int n = 2;
        System.out.println(new Solution().countVowelPermutation(n));
    }

}