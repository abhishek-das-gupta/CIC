package com.cic.graphs.strong.connectivity;

import java.util.*;

public class Solution {

    public boolean isStronglyConnected(List<List<Integer>> edges){
        Map<Integer,List<Integer>> adjList = new HashMap<>();

        /**Create graph from list of edges*/
        populate(adjList, edges);
        System.out.println(adjList.toString());

        /**Check Weakly Connected*/
        boolean allReachable = allReachableViaBFS(adjList);
        if(!allReachable){
            return false;
        }

        /**Check Strongly Connected*/
        Map<Integer, List<Integer>> reverseAdjList = new HashMap<>();
        populateReverseAdjList(reverseAdjList, adjList);
        System.out.println(reverseAdjList.toString());

        allReachable = allReachableViaBFS(reverseAdjList);

       return allReachable;
    }

    private boolean allReachableViaBFS(Map<Integer, List<Integer>> adjList){
        Queue<Integer> fringe = new LinkedList<>();
        Set<Integer>  seen = new HashSet<>();

        fringe.add(0);
        seen.add(0);

        while(!fringe.isEmpty()){
            int curr = fringe.poll();
            for(int neighbor : adjList.get(curr)){
                if(!seen.contains(neighbor)){
                    fringe.add(neighbor);
                    seen.add(neighbor);
                }
            }
        }

        return seen.size() == adjList.size();
    }

    private void populateReverseAdjList(Map<Integer, List<Integer>> reverse, Map<Integer, List<Integer>> adjList){
        for(Map.Entry<Integer, List<Integer>> entry : adjList.entrySet()){
            int key = entry.getKey();
            List<Integer> neighbors = entry.getValue();

            for(int neighbor : neighbors){

                List<Integer> reverseEdge =  reverse.getOrDefault(neighbor, new ArrayList<>());
                reverseEdge.add(key);
                reverse.put(neighbor, reverseEdge);
            }
        }

    }


    private void populate(Map<Integer,List<Integer>> adjList, List<List<Integer>> edges){
        for(List<Integer> edge : edges){
            List<Integer> neighbors = adjList.getOrDefault(edge.get(0), new ArrayList<Integer>());
            neighbors.add(edge.get(1));
            adjList.put(edge.get(0), neighbors);
        }
    }

    public static void main(String[] args){
        List<List<Integer>>  edges = new ArrayList<>();
        edges.add(Arrays.asList(0,1));
        edges.add(Arrays.asList(1,2));
        edges.add(Arrays.asList(2,4));
        edges.add(Arrays.asList(4,2));
        edges.add(Arrays.asList(2,3));
        edges.add(Arrays.asList(3,0));

        Solution sol = new Solution();
        System.out.println(sol.isStronglyConnected(edges));
    }

}
