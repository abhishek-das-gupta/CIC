package com.leetcode.strings.rabin.karp.longest.duplicate.string;

import java.util.*;

class Solution {
    public static String longestDupSubstring(String s) {
        int n =s.length();

        int l=0,r=n-1;
        String ans = "";
        while(l <= r){
            int mid = l + (r-l)/2;
            String cur = rbk(s, mid);
            if(cur != null){
                ans = cur;
                l = mid+1;
            }else{
                r = mid-1;
            }
        }
        return ans;
    }

    private static String rbk(String s, int len){
        int n = s.length();
        int R = 31;
        Map<Long, List<Integer>> mp = new HashMap<>();

        long cur = 0;
        for(int i=0; i<len; ++i)
            cur = cur*R + (s.charAt(i)-'a');

        mp.putIfAbsent(cur, new ArrayList<>());
        mp.get(cur).add(0);

        int RM = 1;
        for(int i=1; i<=len-1; ++i)
            RM = (RM * R);

        for(int i = len; i<n; ++i){
            cur = cur - RM*(s.charAt(i-len)-'a');
            cur = cur*R + (s.charAt(i)-'a');

            if(mp.containsKey(cur)){
                String curStr = s.substring(i-len+1, i+1);
                for(int idx : mp.get(cur)){
                    String hashStr = s.substring(idx, idx+len);
                    if(hashStr.equals(curStr)){
                        return curStr;
                    }
                }
            }
            mp.putIfAbsent(cur, new ArrayList<>());
            mp.get(cur).add(i-len+1);
        }

        return null;
    }

    public static void main(String[] args){
        System.out.println(Solution.longestDupSubstring("ababdaebdabedeabbdddbcebaccececbccccebbcaaabaadcadccddaedaacaeddddeceedeaabbbbcbacdaeeebaabdabdbaebadcbdebaaeddcadebedeabbbcbeadbaacdebceebceeccddbeacdcecbcdbceedaeebdaeeabccccbcccbceabedaedaacdbbdbadcdbdddddcdebbcdbcabbebbeabbdccccbaaccbbcecacaebebecdcdcecdeaccccccdbbdebaaaaaaeaaeecdecedcbabedbabdedbaebeedcecebabedbceecacbdecabcebdcbecedccaeaaadbababdccedebeccecaddeabaebbeeccabeddedbeaadbcdceddceccecddbdbeeddabeddadaaaadbeedbeeeaaaeaadaebdacbdcaaabbacacccddbeaacebeeaabaadcabdbaadeaccaecbeaaabccddabbeacdecadebaecccbabeaceccaaeddedcaecddaacebcaecebebebadaceadcaccdeebbcdebcedaeaedacbeecceeebbdbdbaadeeecabdebbaaebdddeeddabcbaaebeabbbcaaeecddecbbbebecdbbbaecceeaabeeedcdecdcaeacabdcbcedcbbcaeeebaabdbaadcebbccbedbabeaddaecdbdbdccceeccaccbdcdadcccceebdabccaebcddaeeecddddacdbdbeebdabecdaeaadbadbebecbcacbbceeabbceecaabdcabebbcdecedbacbcccddcecccecbacddbeddbbbadcbdadbecceebddeacbeeabcdbbaabeabdbbbcaeeadddaeccbcdabceeabaacbeacdcbdceebeaebcceeebdcdcbeaaeeeadabbecdbadbebbecdceaeeecaaaedeceaddedbedbedbddbcbabeadddeccdaadaaeaeeadebbeabcabbdebabeedeeeccadcddaebbedadcdaebabbecedebadbdeacecdcaebcbdababcecaecbcbcdadacaebdedecaadbaaeeebcbeeedaaebbabbeeadadbacdedcbabdaabddccedbeacbecbcccdeaeeabcaeccdaaaddcdecadddabcaedccbdbbccecacbcdecbdcdcbabbeaacddaeeaabccebaaaebacebdcdcbbbdabadeebbdccabcacaacccccbadbdebecdaccabbecdabdbdaebeeadaeecbadedaebcaedeedcaacabaccbbdaccedaedddacbbbdbcaeedbcbecccdbdeddcdadacccdbcdccebdebeaeacecaaadccbbaaddbeebcbadceaebeccecabdadccddbbcbaebeaeadacaebcbbbdbcdaeadbcbdcedebabbaababaacedcbcbceaaabadbdcddadecdcebeeabaadceecaeccdeeabdbabebdcedceaeddaecedcdbccbbedbeecabaecdbba"));
    }
}