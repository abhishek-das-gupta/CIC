package com.leetcode.contest.weekly.html.entity.parser;

import java.util.HashMap;
import java.util.Map;

class Solution {
    public static String entityParser(String text) {
        Map<String,String> mp = new HashMap<>();
        mp.put("&quot;" , "\"");
        mp.put("&apos;" , "'");
        mp.put("&amp;" , "&");
        mp.put("&gt;" , ">");
        mp.put("&lt;" , "<");
        mp.put("&frasl;", "/");
        System.out.println(mp.toString());
        int i=0;
        int j=0;
        StringBuilder sb = new StringBuilder("");
        while(j < text.length()){
            if(text.charAt(j) == '&'){
                i = j;
                boolean isBreak = false;
                j++;
                while(j < text.length() && text.charAt(j) != ';'){
                    if(!Character.isLetter(text.charAt(j))){
                        isBreak = true;
                        break;
                    }
                    j++;
                }
                if(isBreak){
                    if(text.charAt(j) != '&'){
                        sb.append(text.substring(i,j+1));
                        j++;
                    }
                    else{
                        sb.append(text.substring(i,j));
                    }
                    continue;
                }
                String s = text.substring(i,j+1);
                if(mp.containsKey(s)){
                    sb.append(mp.get(s));
                }
                else{
                    sb.append(s);
                }
            }
            else{
                sb.append(text.charAt(j));
            }
            j++;
        }
        return sb.toString();

    }
    public static void main(String[] args){
        String s = "&&;&quot;&amp;&quot&lt;&gt;&frasl;;;";
        System.out.println(Solution.entityParser(s));
    }
}
