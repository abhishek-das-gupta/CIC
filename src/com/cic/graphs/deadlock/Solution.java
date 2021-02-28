package com.cic.graphs.deadlock;

import java.util.List;

public class Solution {
    public boolean isCyclic(List<GraphVertex> graph){
        for(GraphVertex vertex : graph){
            if(vertex.color == GraphVertex.Color.WHITE && hasCycleFromVertex(vertex)){
                return true;
            }
        }
        return false;
    }

    public boolean hasCycleFromVertex(GraphVertex vertex){
        if(vertex.color == GraphVertex.Color.GRAY){
            return true;
        }

        vertex.color = GraphVertex.Color.GRAY;

        for(GraphVertex adj : vertex.edges){

            if(adj.color != GraphVertex.Color.BLACK && hasCycleFromVertex(adj)){
                return true;
            }
        }

        vertex.color = GraphVertex.Color.BLACK;
        return false;
    }
}
