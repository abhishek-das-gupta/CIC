package com.leetcode.trie.searchsuggestionsystem;
import java.util.*;


class SearchSuggestionSystem {
    class TrieNode {
        char val;
        TrieNode[] next;
        PriorityQueue<String> pq;
        boolean isWord;
        TrieNode(char val) {
            this.val = val;
            next = new TrieNode[26];
            pq = new PriorityQueue<>();
        }
        void prefToWord(String s){
            pq.offer(s);
        }
        List<String> suggestTopThree() {
            List<String> suggestions = new ArrayList<>();
            int i = 0;
            int stop = Math.min(pq.size(), 3);
            while (i < stop) {
                i++;
                suggestions.add(pq.poll());
            }
            return suggestions;
        }
        @Override
        public boolean equals(Object o) {
            if(o == null) {
                return false;
            }
            if(this == o) {
                return true;
            }
            if(o.getClass() != this.getClass()) {
                return false;
            }
            TrieNode that = (TrieNode) o;
            if(this.val != that.val || this.isWord != that.isWord) {
                return false;
            }
            for(int i=0; i<26; ++i) {
                if(!this.next[i].equals(that.next[i])) {
                    return false;
                }
            }
            if(this.pq.size() != that.pq.size()) {
                return false;
            }
            Iterator it1 = this.pq.iterator();
            Iterator it2 = that.pq.iterator();

            while(it1.hasNext() && it2.hasNext()) {
                String s1 = (String) it1.next();
                String s2 = (String) it2.next();
                if(!s1.equals(s2)) {
                    return false;
                }
            }
            return true;
        }
        @Override
        public int hashCode() {
            return Objects.hash(val, next, pq, isWord);
        }
    }
    private TrieNode root = new TrieNode('#');
    List<List<String>> res = new ArrayList<>();
    Map<TrieNode, Set<String>> mp = new HashMap<>();
    List<List<String>> suggestedProducts(String[] products, String searchWord) {
        for(String s : products) {
            insert(s);
        }
        TrieNode cur = root;
        for(char c : searchWord.toCharArray()) {
            cur = suggest(c, cur);
        }
        return res;
    }
    private void insert(String s){
        TrieNode cur = root;
        for(char c : s.toCharArray()) {
            if(cur.next[c-'a'] == null) cur.next[c-'a'] = new TrieNode(c);
            cur = cur.next[c-'a'];
            if(!(mp.containsKey(cur) && mp.get(cur).contains(s))) {
                cur.prefToWord(s);
                mp.putIfAbsent(cur, new HashSet<>());
                mp.get(cur).add(s);
            }
        }
        cur.isWord = true;
    }
    private TrieNode suggest(char pref, TrieNode cur) {
        if(cur == null) {
            res.add(new ArrayList<>());
        } else {
            cur = cur.next[pref-'a'];
            if(cur == null) {
                res.add(new ArrayList<>());
            } else {
                res.add(new ArrayList<>(cur.suggestTopThree()));
            }
        }
        return cur;
    }
}
