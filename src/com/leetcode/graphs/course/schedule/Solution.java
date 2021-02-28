package com.leetcode.graphs.course.schedule;


import java.util.*;

class Solution {
    public boolean canFinish(int numCourses, int[][] preReq) {
       if(preReq.length == 0){
           return true;
       }
       Map<Integer, List<Integer>> graph = encodePreReq(preReq);
       Set<Integer> visiting = new HashSet<>();
       List<Integer> visited = new ArrayList<>();

       for(int course=0 ;course<numCourses; course++){
           if(hasCycle(course,graph,visiting,visited)){
               return false;
           }
       }
       return true;
    }

    private boolean hasCycle(int course, Map<Integer,List<Integer>> graph, Set<Integer> visiting, List<Integer> visited){
        if(visiting.contains(course)){
            return true;
        }
        if(visited.contains(course)){
            return false;
        }
        if(!graph.containsKey(course)){
            visited.add(course);
            return false;
        }

        visiting.add(course);
        for(int dependentCourse : graph.get(course)){
            if(hasCycle(dependentCourse,graph,visiting,visited)){
                return true;
            }
        }
        visiting.remove(course);
        visited.add(course);
        return false;

    }


    private Map<Integer,List<Integer>> encodePreReq(int[][] preReq){
        Map<Integer,List<Integer>> aMap = new HashMap<>();

        for(int i=0; i<preReq.length; i++){
            if(!aMap.containsKey(preReq[i][1])){
                List<Integer> aList = new ArrayList<>();
                aList.add(preReq[i][0]);
                aMap.put(preReq[i][1], aList);
            }
            else{
                List<Integer> updatedList = aMap.get(preReq[i][1]);
                updatedList.add(preReq[i][0]);
                aMap.put(preReq[i][1], updatedList);

            }
        }
        for(Map.Entry<Integer,List<Integer>> entry : aMap.entrySet()){
            System.out.print(entry.getKey() + " -> ");
            List<Integer> valueList = entry.getValue();
            for(int values : valueList){
                System.out.print(values + " -> ");
            }
            System.out.println();
        }
        return aMap;
    }


}