package com.leetcode.graphs.word.ladder.ii;

import java.util.*;

class Solution {
    class Pair{
        String key;
        int val;
        public Pair(String k, int v){
            key=k;
            val=v;
        }
    }
    Map<String, List<String>> mp = new HashMap<>();
    Map<String, Integer> lenMp = new HashMap<>();
    List<List<String>> res = new ArrayList<>();
    public List<List<String>> findLadders(String start, String end, List<String> wordList) {
        if(!wordList.contains(end)){
            return res;
        }
        populate(start,wordList);
        System.out.println(mp.toString());
        bfs(start,end);
        dfs(start,end ,new ArrayList<String>());
        return res;
    }

    private void bfs(String start, String end){
        Queue<Pair> q = new LinkedList<>();
        Set<String> set = new HashSet<>();
        q.add(new Pair(start,1));
        set.add(start);
        while(!q.isEmpty()){
            Pair curr = q.poll();
            if(curr.key == end){
                break;
            }
            for(String adj : mp.get(curr.key)){
                if(!set.contains(adj)){
                    q.add(new Pair(adj, curr.val+1));
                    lenMp.put(adj, curr.val+1);
                    set.add(adj);
                }
            }
        }
    }

    private void dfs(String curr, String end,List<String> list){
        if(curr.equals(end)){
            list.add(curr);
            res.add(new ArrayList<String>(list));
            list.remove(list.size()-1);
            return;
        }
        list.add(curr);
        for(String adj : mp.get(curr)){
            if(lenMp.getOrDefault(adj,0) == lenMp.getOrDefault(curr,0)+1){
                dfs(adj,end,list);
            }
        }
        list.remove(list.size()-1);
    }
    private void populate(String start,List<String> wordList){
        for(String word : wordList){
            mp.putIfAbsent(word, new ArrayList<String>());
        }
        mp.putIfAbsent(start,new ArrayList<String>());

        int n = wordList.size();
        for(int i=0; i<n; ++i){
            String w1 = wordList.get(i);
            int m = w1.length();
            for(int j=i+1; j<n; ++j){
                String w2 = wordList.get(j);
                int k=0;
                int diff = 0;

                while(k<m){
                    if(w1.charAt(k) != w2.charAt(k)){
                        diff++;
                    }
                    if(diff > 1){
                        break;
                    }
                    k++;
                }
                if(diff == 1){
                    mp.get(w1).add(w2);
                    mp.get(w2).add(w1);
                }

            }
        }
        if(mp.get(start).size()==0){
            int m = start.length();
            for(int i=0; i<n; ++i){
                int k=0;
                int diff = 0;
                while(k < m){
                    if(start.charAt(k) != wordList.get(i).charAt(k)){
                        diff++;
                    }
                    if(diff > 1){
                        break;
                    }
                    k++;
                }
                if(diff == 1){
                    mp.get(start).add(wordList.get(i));
                    mp.get(wordList.get(i)).add(start);
                }
            }
        }

    }

    public static void main(String[] args){
        Solution s = new Solution();
        List<String> wordList = Arrays.asList("hot","dog","cog","pot","dot");
        System.out.println(s.findLadders("hot","dog",wordList));
    }
}