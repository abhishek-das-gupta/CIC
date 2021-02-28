package com.cic.graphs.paint.a.region;

import java.util.Objects;

public class Coordinate {
    public int row;
    public int col;

    public Coordinate(int r, int c){
        row = r;
        col = r;
    }

    @Override
    public boolean equals(Object o){
        if(o == null){
            return false;
        }
        if(this == o){
            return true;
        }
        if(o.getClass() != this.getClass()){
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
}
