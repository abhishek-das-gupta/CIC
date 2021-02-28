package com.leetcode.trie.magic.dictionary;

public class MagicDictionary {
    private class TrieNode{
        char val;
        boolean ends;
        TrieNode[] adjs;
        public TrieNode(char val){
            this.val=val;
            ends = false;
            adjs = new TrieNode[26];
        }
    }
    /** Initialize your data structure here. */
    private TrieNode root;
    public MagicDictionary() {
        root = new TrieNode('#');
    }

    /** Build a dictionary through a list of words */
    public void buildDict(String[] dict) {
        for(String word : dict){
            TrieNode curr = root;
            for(int i=0; i<word.length(); i++){
                char c = word.charAt(i);
                if(curr.adjs[c-'a'] == null){
                    curr.adjs[c-'a'] = new TrieNode(c);
                    curr = curr.adjs[c-'a'];
                }
                else{
                    curr = curr.adjs[c-'a'];
                }
            }
            curr.ends = true;
        }
    }

    /** Returns if there is any word in the trie that equals to the given word after modifying exactly one character */
    public boolean search(String word) {
        return dfs(root,0,word,0);
    }

    private boolean dfs(TrieNode curr, int dex, String word,int diff){
        if(diff > 1){
            return false;
        }
        if(dex == word.length()){
            if(diff == 0){
                return false;
            }
            if(curr.ends == true){
                return true;
            }
            else{
                return false;
            }
        }

        char c = word.charAt(dex);
        if(curr.adjs[c-'a'] == null){
            for(int i=0; i<26; i++){
                if(curr.adjs[i] != null){
                    if(dfs(curr.adjs[i],dex+1,word,diff+1)){
                        return true;
                    }
                }
            }
            return false;
        }
        else{
            return dfs(curr.adjs[c-'a'],dex+1,word,diff);
        }
    }

}

/**
 * Your MagicDictionary object will be instantiated and called as such:
 * MagicDictionary obj = new MagicDictionary();
 * obj.buildDict(dict);
 * boolean param_2 = obj.search(word);
 */