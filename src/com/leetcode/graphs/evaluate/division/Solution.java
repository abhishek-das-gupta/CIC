package com.leetcode.graphs.evaluate.division;

import java.util.*;

class Solution {
    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
        double[] res = new double[queries.size()];
        Arrays.fill(res, -1.0);
        Map<String, List<String>> adjList = new HashMap<>();
        Map<String, Double> weight = new HashMap<>();
        populate(adjList, weight, equations, values);



        System.out.println(adjList.toString());
        System.out.println(weight.toString());


        for(int i=0; i<queries.size(); i++){
            String start = queries.get(i).get(0);
            String end = queries.get(i).get(1);

            dfs(start,end, adjList,1.0, new ArrayList<String>(), weight,i, res);
        }

        for(int i=0; i<res.length; i++){
            System.out.print(res[i] + " ");
        }
        System.out.println();
        return res;

    }

    private void dfs(String currentTex,
                     String endTex,
                     Map<String, List<String>> adjList,
                     double partialVal,
                     List<String> partialString,
                     Map<String, Double> weight,
                     int currentQueryDex,
                     double[] res
    )
    {
        if(!adjList.containsKey(currentTex)){
            res[currentQueryDex] = -1.0;
            return;
        }

        if(!adjList.containsKey(endTex)){
            res[currentQueryDex] = -1.0;
            return;
        }

        if(currentTex.equals(endTex)){
            res[currentQueryDex] = partialVal;
            return;
        }

        partialString.add(currentTex);

        for(String adj : adjList.get(currentTex)){
            if(partialString.contains(adj)){
                continue;
            }
            partialString.add(adj);

            String expression = currentTex + "/" + adj;
            double edgeWeight = weight.get(expression);

            partialVal *= edgeWeight;

            dfs(adj, endTex, adjList, partialVal, partialString, weight, currentQueryDex, res);

            partialVal /= edgeWeight;
            partialString.remove(partialString.size()-1);

            if(Double.compare(res[currentQueryDex], -1.0) != 0){
                break;
            }

        }
        partialString.remove(partialString.size()-1);

    }



    private void populate(Map<String, List<String>> adjList,
                          Map<String, Double> weight,
                          List<List<String>> equations,
                          double[] values
    )
    {

        for(int i=0; i<equations.size(); i++){
            String numerator = equations.get(i).get(0);
            String denominator = equations.get(i).get(1);

            double val = values[i];

            List<String> denominatorList =  adjList.getOrDefault(numerator, new ArrayList<String>());
            denominatorList.add(denominator);
            adjList.put(numerator, denominatorList);
            weight.put(numerator + "/" + denominator, val);


            List<String> numeratorList =  adjList.getOrDefault(denominator, new ArrayList<String>());
            numeratorList.add(numerator);
            adjList.put(denominator, numeratorList);
            weight.put(denominator + "/" + numerator, 1/val);

        }



    }

    public static void main(String[] args){
//        List<List<String>> equations = new ArrayList<>();
//        equations.add(new ArrayList<String>(Arrays.asList("a","b")));
//        equations.add(new ArrayList<String>(Arrays.asList("b","c")));

        //System.out.println(equations.toString());

//        double[] values = {2.0, 3.0};
//
//        List<List<String>> queries = new ArrayList<>();
//        queries.add(new ArrayList<String>(Arrays.asList("a","c")));
//        queries.add(new ArrayList<String>(Arrays.asList("b","a")));
//        queries.add(new ArrayList<String>(Arrays.asList("a","e")));
//        queries.add(new ArrayList<String>(Arrays.asList("a","a")));
//        queries.add(new ArrayList<String>(Arrays.asList("x","x")));


        /*
        * Input:
        * [["a","aa"]]
          [9.0]
          [["aa","a"],["aa","aa"]]
          *
          *
        * Output:
        * [0.11111,1.0]
        * */

        List<List<String>> equations = new ArrayList<>();
        equations.add(new ArrayList<String>(Arrays.asList("a","aa")));

        System.out.println(equations.toString());


        double[] values = {9.0};

        List<List<String>> queries = new ArrayList<>();
        queries.add(new ArrayList<String>(Arrays.asList("aa","a")));
        queries.add(new ArrayList<String>(Arrays.asList("aa","aa")));


        Solution s = new Solution();
        System.out.println(s.calcEquation(equations, values, queries));
    }
}
