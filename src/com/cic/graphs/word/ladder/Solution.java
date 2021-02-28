package com.cic.graphs.word.ladder;

import java.util.*;

class Solution {
    private class Node{
        String word;
        int distance;
        public Node(String w , int d){
            word=w;
            distance = d;
        }
    }
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        if(!wordList.contains(endWord)){
            return 0;
        }

        Map<String, List<String>> aMap = encode(wordList);

        Queue<Node> aQueue = new LinkedList<>();
        Set<String> seen = new HashSet<>();

        aQueue.add(new Node(beginWord,1));
        seen.add(beginWord);

        while(!aQueue.isEmpty()){
            Node node = aQueue.poll();
            String curr = node.word;
            int distance = node.distance;

            StringBuilder sb = new StringBuilder(curr);
            for(int i=0; i<sb.length(); i++){

                char temp = sb.charAt(i);
                sb.setCharAt(i,'*');

                if(aMap.containsKey(sb.toString())){
                    List<String> aList = aMap.get(sb.toString());
                    for(String word : aList){
                        if(word.equals(endWord)){
                            return distance+1;
                        }
                        if(!seen.contains(word)){
                            aQueue.add(new Node(word,distance+1));
                            seen.add(word);
                        }
                    }
                }
                sb.setCharAt(i,temp);
            }

        }
        return 0;
    }


    public Map<String,List<String>> encode(List<String> wordList){
        Map<String, List<String>> aMap = new HashMap<>();

        for(String word : wordList){
            char[] arr= word.toCharArray();
            for(int i=0; i<arr.length; i++){
                char temp = arr[i];
                arr[i] = '*';

                if(!aMap.containsKey(String.valueOf(arr))){
                    aMap.put(String.valueOf(arr),new ArrayList<String>());
                    List<String> aList = aMap.get(String.valueOf(arr));
                    aList.add(word);
                    aMap.put(String.valueOf(arr),aList);
                }
                else{
                    List<String> aList = aMap.get(String.valueOf(arr));
                    aList.add(word);
                    aMap.put(String.valueOf(arr),aList);
                }
                arr[i] = temp;
            }
        }
        return aMap;
    }

    public static void main(String[] args){
        List<String> wordList = new ArrayList<>();
        wordList.add("hot");
        wordList.add("dot");
        wordList.add("dog");
        wordList.add("lot");
        wordList.add("log");
        wordList.add("cog");

        Solution s = new Solution();
        s.encode(wordList);
        System.out.println(s.ladderLength("hit","cog",wordList));
    }
}