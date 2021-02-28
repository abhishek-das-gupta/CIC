package com.cic.graphs.search.a.maze;

import java.util.Objects;

public class Coordinate {
    private int row;
    private int col;

    public Coordinate(int r, int c){
        row = r;
        col = r;
    }

    @Override
    public boolean equals(Object o ){
        if(o == null){
            return false;
        }
        if(this == o){
            return true;
        }
        if(this.getClass() != o.getClass()){
            return false;
        }
        Coordinate that = (Coordinate) o;
        if(this.row != that.row || this.col != that.col){
            return false;
        }
        return true;
    }

    @Override
    public int hashCode(){
        return Objects.hash(row,col);
    }

    public int getRow(){
        return row;
    }

    public int getCol(){
        return col;
    }

}
