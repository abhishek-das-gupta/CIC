package com.leetcode.trie.searchsuggestionsystem;

public class Main {
    public static void main(String[] args) {
        SearchSuggestionSystem ss = new SearchSuggestionSystem();
        String[] products = {"mobile","mouse","moneypot","monitor","mousepad"};
        String searchWord = "mouse";
//        String[] products = {"bags","baggage","banner","box","cloths"};
//        String searchWord = "bags";
//        String[] products = {"havana"};
//        String searchWord = "tatiana";
        ss.suggestedProducts(products, searchWord);
    }
}
