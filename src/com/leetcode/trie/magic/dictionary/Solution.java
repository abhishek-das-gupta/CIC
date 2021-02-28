package com.leetcode.trie.magic.dictionary;

public class Solution {
    public static void main(String args[]){
        MagicDictionary md = new MagicDictionary();
        md.buildDict(new String[]{"hello","leetcode"});
        System.out.println(md.search("hhllo"));
    }
}
