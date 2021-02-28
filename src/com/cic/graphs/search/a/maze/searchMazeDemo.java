package com.cic.graphs.search.a.maze;


import java.util.ArrayList;
import java.util.List;

public class searchMazeDemo {

    public static void main(String[] args){
        List<List<Color>> maze = new ArrayList<List<Color>>(5);
        for(int i=0; i<5; i++){
            maze.add(new ArrayList<Color>(5));
        }
    }
}
