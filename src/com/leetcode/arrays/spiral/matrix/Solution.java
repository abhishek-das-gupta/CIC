package com.leetcode.arrays.spiral.matrix;
import java.util.List;
import java.util.ArrayList;
class Solution {
    public List<Integer> spiralOrder(int[][] nums) {
        List<Integer> spiral = new ArrayList<>();
        if(nums == null || nums.length == 0){
            return spiral;
        }

        dfs(0,0,nums,spiral,"right",0);

        return spiral;
    }

    private void dfs(int row, int col,int[][]nums, List<Integer> spiral,String direction,int count){
        spiral.add(nums[row][col]);
        nums[row][col] = Integer.MAX_VALUE;
        count += 1;

        if(isBoundary(row,col,nums,direction)){
            direction = changeDirection(direction);
        }
        if(count == nums.length*nums[row].length){
            return;
        }

        if(/*inBounds(row,col+1,nums) &&*/direction.equals("right")){
            dfs(row,col+1,nums,spiral,direction,count);
        }
        else if(/*inBounds(row+1,col,nums) && */direction.equals("down")){
            dfs(row+1,col,nums,spiral,direction,count);
        }
        else if(/*inBounds(row,col-1,nums) && */direction.equals("left")){
            dfs(row,col-1,nums,spiral,direction,count);
        }
        else if(/*inBounds(row-1,col,nums) && */direction.equals("up")){
            dfs(row-1,col,nums,spiral,direction,count);
        }

    }

    private boolean inBounds(int row, int col, int[][] nums){
        return row >=0 && row < nums.length &&
                col >=0 && col < nums[row].length;
    }

    private boolean isVisited(int row, int col , int[][] nums){
        return row >=0 && row < nums.length &&
                col >=0 && col < nums[row].length &&
                nums[row][col] == Integer.MAX_VALUE;
    }

    private String changeDirection(String direction){
        if(direction.equals("right")){
            return"down";
        }else if(direction.equals("down")){
            return "left";
        }else if(direction.equals("left")){
            return "up";
        }else if(direction.equals("up")){
            return "right";
        }
        else{
            return "";
        }
    }

    private boolean isBoundary(int row,int col,int[][] nums, String direction){
        if(direction.equals("right")){
            if(col + 1 == nums[row].length){
                return true;
            }
            else if(isVisited(row,col+1,nums)){
                return true;
            }
        }else if(direction.equals("down")){
            if(row+1 == nums.length){
                return true;
            }
            else if(isVisited(row+1,col,nums)){
                return true;
            }

        }else if(direction.equals("left")){
            if(col-1 < 0 ){
                return true;
            }
            else if(isVisited(row,col-1,nums)){
                return true;
            }

        }else if(direction.equals("up")){
            if(row-1 < 0){
                return true;
            }
            else if(isVisited(row-1,col,nums)){
                return true;
            }

        }

        return false;
    }

    public static void main(String[] args){
        int[][] nums = {{1,2,3,4},{5,6,7,8},{9,10,11,12},{13,14,15,16}};
        Solution s= new Solution();
        System.out.println(s.spiralOrder(nums).toString());
    }

}