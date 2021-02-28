package com.cic.graphs.search.a.maze;

import java.util.ArrayList;
import java.util.List;

public class SearchAMaze {
    public static List<Coordinate> searchMaze(List<List<Color>> maze, Coordinate start, Coordinate end){
        List<Coordinate> path = new ArrayList<>();

        path.add(start);
        maze.get(start.getRow()).set(start.getCol(), Color.BLACK);

        if(!hasPathtoEnd(maze,start,end,path)){
            path.remove(path.size()-1);
        }

        return path;
    }

    public static boolean hasPathtoEnd(List<List<Color>> maze, Coordinate node, Coordinate end, List<Coordinate> path){
        if(node.equals(end)){
            return true;
        }

        final int[][] SHIFTS = {
                {0,1}, //going right
                {1,0}, //going down
                {-1,0}, //going left
                {0,-1} //going up
        };

        for(int[] shift : SHIFTS){
            Coordinate next = new Coordinate(node.getRow() + shift[0], node.getCol()+shift[1]);
            if(canTraverse(maze,next)){
                path.add(next);
                maze.get(next.getRow()).set(next.getCol(),Color.BLACK);

                if(hasPathtoEnd(maze,next,end,path)){
                    return true;
                }

                path.remove(path.size()-1);
            }
        }

        return false;
    }

    public static boolean canTraverse(List<List<Color>> maze, Coordinate node){
        return node.getRow() >=0 && node.getRow() < maze.size() && node.getCol() >=0
                && node.getCol() < maze.get(node.getRow()).size()
                && maze.get(node.getRow()).get(node.getCol()) == Color.WHITE;
    }
}
