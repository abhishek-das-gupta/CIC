package com.leetcode.trie.replace.word;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution {
    private class Trie{
        private class TrieNode{
            char val;
            boolean isWord;
            TrieNode[] next;
            public TrieNode(char c){
                val=c;
                next = new TrieNode[26];
            }
            public void insert(String word){
                for(int i=0; i<word.length(); i++){
                    char c = word.charAt(i);

                }
            }

        }
        private TrieNode root;
        public Trie(){
            root = new TrieNode('#');
        }

        public void insert(String word){
            TrieNode curr = root;
            for(int i=0; i<word.length(); i++){
                char c = word.charAt(i);
                if(curr.next[c-'a'] == null){
                    curr.next[c-'a'] = new TrieNode(c);
                }
                curr = curr.next[c-'a'];
            }
            curr.isWord = true;
        }

        public String findRoot(String word){
            String minRoot = "";
            TrieNode curr = root;
            for(int i=0; i<word.length(); i++) {
                char c = word.charAt(i);
                if (curr.isWord) {
                    minRoot = word.substring(0, i);
                    break;
                }
                if (curr.next[c - 'a'] == null) {
                    return word;
                }

                curr = curr.next[c - 'a'];

            }
            return curr.isWord ? minRoot : word ;

        }


    }

    public String replaceWords(List<String> dict, String sentence) {
        Trie t = new Trie();

        for(String word : dict){
            t.insert(word);
        }

        String[] words = sentence.split("\\s+");
        // for(int i=0; i<words.length; i++){
        //     words[i] = words[i].replaceAll("[^\\w]","");
        // }
        System.out.println(Arrays.toString(words));

        StringBuilder sb = new StringBuilder();
        for(String word : words){
            //System.out.println(word);
            sb.append(t.findRoot(word));
            sb.append(" ");
        }
        return sb.toString();


    }

    public static void main(String[] args){
        Solution s = new Solution();
        List<String> dict = new ArrayList<>(Arrays.asList("cat","bat","rat"));
        String sentence = "the cattle was rattled by the battery";
        System.out.println(s.replaceWords(dict,sentence));
    }
}
