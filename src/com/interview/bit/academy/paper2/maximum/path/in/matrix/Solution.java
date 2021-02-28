package com.interview.bit.academy.paper2.maximum.path.in.matrix;

public class Solution {
    int res = Integer.MIN_VALUE;
    public int solve(int[][] A, int B){
        solve(0,0,A,B,0);
        return res;
    }

    private void solve(int row, int col, int[][] A, int B,int sum){
        int N = A.length;
        if(row == N-1 && col == N-1){
            if(B == 1){
                res = Math.max(sum + A[row][col], res);
                return;
            }
            return;
        }
        if(B < 1){
            return;
        }
        if(row <0 || row >=N || col <0 || col>=N){
            return;
        }

        solve(row,col+1, A,B,sum+A[row][col]);
        solve(row+1,col,A,B,sum+A[row][col]);
        solve(row-1,col,A,B-1,sum+A[row][col]);
        solve(row,col-1,A,B-1,sum+A[row][col]);
    }

    public static void main(String[] args){
        int[][] A = {
                {14,35,12,-45,62,11},
                {-16,-48,-48,-11,-59,44},
                {-7,-12,26,6,-41,-49},
                {-2,64,-37,-54,44,-27},
                {-67,11,-31,-26,65,-29},
                {-59,-10,25,-6,-14,-67}

        };

        int B = 98;
        Solution s = new Solution();
        System.out.println(s.solve(A,B));
    }
}
