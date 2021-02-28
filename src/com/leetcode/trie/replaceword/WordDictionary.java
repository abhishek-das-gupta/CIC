package com.leetcode.trie.replaceword;

public class WordDictionary {
    private TrieNode root;
    private class TrieNode {
        char val;
        TrieNode[] next;
        boolean isWord;
        public TrieNode(char val) {
            this.val = val;
            next = new TrieNode[26];
        }
    }
    /** Initialize your data structure here. */
    public WordDictionary() {
        root = new TrieNode('#');
    }

    /** Adds a word into the data structure. */
    public void addWord(String word) {
        TrieNode cur = root;
        for(char c : word.toCharArray()) {
            if(cur.next[c-'a'] == null) {
                cur.next[c-'a'] = new TrieNode(c);
            }
            cur = cur.next[c-'a'];
        }
        cur.isWord = true;
    }

    /** Returns if the word is in the data structure. A word could contain the dot character '.' to represent any one letter. */
    public boolean search(String word) {
        return dfs(0, root, word);
    }

    private boolean dfs(int idx, TrieNode cur, String s) {
        if(idx == s.length()) {
            return cur != null && cur.isWord;
        }
        if(cur == null) {
            return false;
        }
        char c = s.charAt(idx);
        if(c == '.') {
            for(int i = 0; i < 26; ++i) {
                if(dfs(idx+1, cur.next[i], s)) {
                    return true;
                }
            }
            return false;
        }
        return dfs(idx+1, cur.next[c-'a'], s);
    }
}
