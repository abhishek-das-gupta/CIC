package com.leetcode.graphs.time.needed.to.inform.all.employees;

import java.util.*;

class Solution {
    class Pair{
        int id;
        int time;
        public Pair(int id, int time){
            this.id=id;
            this.time=time;
        }
    }
    public int numOfMinutes(int n, int headID, int[] manager, int[] informTime) {
        Queue<Pair> fringe = new LinkedList<>();
        Set<Integer> seen = new HashSet<>();

        Map<Integer,List<Integer>> adjList = new HashMap<>();
        for(int i=0; i<n; i++){
            if(manager[i] == -1){
                continue;
            }
            adjList.putIfAbsent(manager[i], new ArrayList<>());
            adjList.get(manager[i]).add(i);
        }
        fringe.add(new Pair(headID,0));
        seen.add(headID);
        int totalTime = 0;
        while(!fringe.isEmpty()){
            Pair currManager = fringe.poll();
            totalTime = Math.max(totalTime, currManager.time);
            if(adjList.containsKey(currManager.id)){
                for(int subordinate : adjList.get(currManager.id)){
                    if(!seen.contains(subordinate)){
                        fringe.add(new Pair(subordinate, currManager.time + informTime[currManager.id]));
                        seen.add(subordinate);
                    }
                }
            }
        }
        return totalTime;

    }

    public static void main(String[] args){
        int n = 7;
        int headID = 6;
        int[] manager =  {1,2,3,4,5,6,-1};
        int[] informTime = {0,6,5,4,3,2,1};
        Solution sol = new Solution();
        System.out.println(sol.numOfMinutes(n,headID,manager,informTime));
    }
}