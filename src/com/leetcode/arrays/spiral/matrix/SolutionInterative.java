package com.leetcode.arrays.spiral.matrix;

import java.util.ArrayList;

public class SolutionInterative {
    public static ArrayList<Integer> findSpiral(int[][] arr) {
        ArrayList<Integer> spiral = new ArrayList<Integer>();

        int row = 0;
        int col = 0;

        int n = arr.length;
        int count = 0;

        String direction = "right";
        //System.out.println(row + " " + col);
        while(count != n*n){
            System.out.println(row + " " + col);
            spiral.add(arr[row][col]);
            count += 1;

            arr[row][col] = Integer.MAX_VALUE;

            if(isBoundary(row,col,arr,direction)){
                direction  = changeDirection(direction);
            }

            if(direction.equals("right")){
                col++;
                //System.out.println(row + " " + col);
            }
            else if(direction.equals("down")){
                row++;
                //System.out.println(row + " " + col);
            }
            else if(direction.equals("left")){
                col--;
                //System.out.println(row + " " + col);
            }
            else if(direction.equals("up")){
                row--;
                //System.out.println(row + " " + col);
            }

        }

        return spiral;
    }


    private static boolean isBoundary(int row, int col, int[][] arr, String direction){
        if(direction.equals("right")){
            if(col + 1 == arr.length){
                return true;
            }
            else if(arr[row][col+1] == Integer.MAX_VALUE){
                return true;
            }
        }
        else if(direction.equals("down")){
            if(row + 1 == arr.length){
                return true;
            }
            else if(arr[row+1][col] == Integer.MAX_VALUE){
                return true;
            }
        }
        else if(direction.equals("left")){
            if(col - 1 <0){
                return true;
            }
            else if(arr[row][col-1] == Integer.MAX_VALUE){
                return true;
            }
        }
        else if(direction.equals("up")){
            if(row - 1 <0){
                return true;
            }
            else if(arr[row-1][col] == Integer.MAX_VALUE){
                return true;
            }
        }
        return false;
    }

    private static String changeDirection(String direction){
        if(direction.equals("right")){
            return "down";
        }
        else if(direction.equals("down")){
            return "left";
        }
        else if(direction.equals("left")){
            return "up";
        }
        else{
            return "right";
        }
    }


    public static void main(String[] args){
        int[][] nums = {{1,2,3,4},{5,6,7,8},{9,10,11,12}};
        SolutionInterative s = new SolutionInterative();
        System.out.println(findSpiral(nums));
    }


}
