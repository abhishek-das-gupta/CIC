package com.leetcode.backtracking.word.search;

class Solution {
    public boolean exist(char[][] board, String word) {
        if(board == null || board.length == 0){
            return false;
        }
        if(word == null || word.length() == 0){
            return false;
        }

        for(int i=0; i<board.length; i++){
            for(int j=0; j<board[i].length; j++){
                if(exist(i,j,0,-1,-1,board,word)){
                    return true;
                }
            }
        }

        return false;
    }

    private boolean exist(int currRow,
                          int currCol,
                          int currentIndex,
                          int prevRow,
                          int prevCol,
                          char[][] board,
                          String word)
    {
        if(currentIndex == word.length()-1 && word.charAt(currentIndex) == board[currRow][currCol]){
            return true;
        }
        if(currentIndex == word.length()){
            return false;
        }

        if(word.charAt(currentIndex) != board[currRow][currCol]){
            return false;
        }

        final int[][] SHIFTS = {
                {0,1}, //right
                {1,0}, //down
                {0,-1}, //left
                {-1,0}, //up
        };

        for(int[] shift : SHIFTS){

            if(compare(prevRow,prevCol,currRow+shift[0],currCol+shift[1]) &&
                    inBounds(currRow+shift[0], currCol+shift[1], board) &&
                    exist(currRow+shift[0], currCol+shift[1], currentIndex+1, currRow, currCol, board, word))
            {
                return true;
            }
        }

        return false;

    }

    private boolean compare(int prevRow, int prevCol, int currRow, int currCol){
        if(prevRow == currRow){
            if(prevCol != currCol){
                return true;
            }
            else{
                return false;
            }
        }
        else{
            return true;
        }
    }

    private boolean inBounds(int row, int col, char[][] board){
        return row >= 0 && row < board.length &&
                col >=0 && col < board[row].length;
    }

    public static void main(String[] args){
        String s = "ABCCED";
        String s1 = "aaa";

        /**[["a","a","a","a"],["a","a","a","a"],["a","a","a","a"]]
         "aaaaaaaaaaaaa"
         */
        char[][] board = {{'A','B','C','E'},
                          {'S','F','C','S'},
                          {'A','D','E','E'}
                         };

        char[][] board1 = {{'a','a'}};

        Solution sol = new Solution();
        System.out.println(sol.exist(board1, s1 ));
    }
}