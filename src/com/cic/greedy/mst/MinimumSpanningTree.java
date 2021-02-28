package com.cic.greedy.mst;

import java.util.*;

public class MinimumSpanningTree {
    public static void main(String[] args){
        List<Edge> edges = new ArrayList<>();
        edges.add(new Edge('a', 'b', 5));
        edges.add(new Edge('a', 'e', 17));

        edges.add(new Edge('b', 'a', 5));
        edges.add(new Edge('b', 'e', 12));
        edges.add(new Edge('b', 'f', 8));
        edges.add(new Edge('b', 'c', 13));

        edges.add(new Edge('c', 'b', 13));
        edges.add(new Edge('c', 'f', 11));
        edges.add(new Edge('c', 'g', 6));

        edges.add(new Edge('d', 'e', 10));
        edges.add(new Edge('d', 'f', 4));

        edges.add(new Edge('e', 'a', 17));
        edges.add(new Edge('e', 'b', 12));
        edges.add(new Edge('e', 'd', 10));
        edges.add(new Edge('e', 'f', 8));

        edges.add(new Edge('f', 'd', 4));
        edges.add(new Edge('f', 'e', 8));
        edges.add(new Edge('f', 'b', 8));
        edges.add(new Edge('f', 'c', 11));
        edges.add(new Edge('f', 'g', 14));

        edges.add(new Edge('g', 'c', 6));
        edges.add(new Edge('g', 'f', 14));

        lazyPrims(edges);
    }

    private static void lazyPrims(List<Edge> edges){
        List<Edge> mstEdges = new ArrayList<>();
        Set<Character> mstNodes = new HashSet<>();

        Map<Character, List<Edge>> adjList = populate(edges);

        char startNode = 'a';
        PriorityQueue<Edge> candidates = new PriorityQueue<>(10, new EdgeComparater());

        List<Edge> adjacents = adjList.get(startNode);
        for(Edge adjacent : adjacents){
            candidates.add(adjacent);
        }

        mstNodes.add(startNode);

        while(!candidates.isEmpty()){
            Edge currMinConstEdge = candidates.poll();
            Character tailOfMinCostEdge = currMinConstEdge.end;

            if(!mstNodes.contains(tailOfMinCostEdge)){
                mstEdges.add(currMinConstEdge);
                mstNodes.add(tailOfMinCostEdge);

                for(Edge adjacent : adjList.get(tailOfMinCostEdge)){
                    candidates.add(adjacent);
                }
            }
        }
        mstInfo(mstEdges);
    }

    private static Map<Character, List<Edge>> populate(List<Edge> edges){
        Map<Character, List<Edge>> adjList = new HashMap<>();
        for(Edge edge : edges){
            char start = edge.start;
            List<Edge> adjacents;
            if(!adjList.containsKey(start)){
                adjacents = new ArrayList<Edge>();
            }
            else{
                adjacents = adjList.get(start);
            }
            adjacents.add(edge);
            adjList.put(start, adjacents);

        }
        return adjList;
    }

    private static void mstInfo(List<Edge> edges) {
        int totalCost = 0;

        for (Edge e: edges) {
            System.out.println(e.toString());
            totalCost += e.weight;
        }

        System.out.println("Total MST cost: " + totalCost);
    }


    private static class EdgeComparater implements Comparator<Edge> {
        @Override
        public int compare(Edge o1, Edge o2){
            return Integer.compare(o1.weight, o2.weight);
        }
    }
    private static class Edge{
        char start;
        char end;
        int weight;

        public Edge(char start, char end, int weight){
            this.start = start;
            this.end = end;
            this.weight = weight;
        }

        @Override
        public String toString() {
            return "Edge: {" + this.start + "," + this.end + "} w/ cost " + this.weight;
        }
    }


}


