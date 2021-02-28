package com.cic.graphs.paint.a.region;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

public class PaintRegion {

    public static Color[][] paintRegion(Color[][] region, int row, int col){
        Queue<Coordinate> aQueue = new LinkedList<>();
        Set<Coordinate> seen = new HashSet<>();

        aQueue.add(new Coordinate(row,col));
        seen.add(new Coordinate(row,col));

        while(!aQueue.isEmpty()){
            Coordinate curr = aQueue.poll();
            region[curr.row][curr.col] = Color.BLACK;

            final int[][] SHIFTS = {
                    {0,1}, //going right
                    {1,0}, //going down
                    {0,-1}, //going left
                    {-1,0} //going up
            };

            for(int[] shift : SHIFTS){
                Coordinate next = new Coordinate(curr.row + shift[0],curr.col + shift[1]);
                if(canTraverse(next,region)){
                    if(!seen.contains(next)){
                        seen.add(next);
                        aQueue.add(next);
                    }
                }
            }
        }
        return region;
    }

    private static boolean canTraverse(Coordinate node, Color[][] region){
        return node.row >=0 && node.row < region.length &&
               node.col >=0 && node.col < region[node.row].length &&
               region[node.row][node.col] == Color.WHITE;
    }
}
