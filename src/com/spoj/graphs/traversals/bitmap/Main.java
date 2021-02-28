package com.spoj.graphs.traversals.bitmap;

import java.util.*;
import java.lang.*;
import java.io.*;

public class Main {
    static class Triple {
        int x;
        int y;
        int w;

        public Triple(int x, int y, int w) {
            this.x = x;
            this.y = y;
            this.w = w;
        }

        public boolean equals(Object o) {
            if (o == null)
                return false;
            if (this.getClass() != o.getClass())
                return false;
            Triple that = (Triple) o;
            if (this.x == that.x && this.y == that.y && this.w == that.w)
                return true;
            else
                return false;
        }

        public int hashCode() {
            return Objects.hash(x, y, w);
        }
    }
    public static void main(String[] args) throws java.lang.Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        while(t-- != 0){
            String s = br.readLine();
            int n = Integer.parseInt(s.split(" ")[0]);
            int m = Integer.parseInt(s.split(" ")[1]);
            int[][] nums = new int[n][m];
            for(int i=0; i<n; ++i){
                String s1 = br.readLine();
                for(int j=0; j<m; ++j){
                    nums[i][j] = s1.charAt(j)-'0';
                }
            }
            Queue<Triple> q = new LinkedList<>();
            boolean[][] vis = new boolean[n][m];
            int[][] res = new int[n][m];
            for(int i=0; i<n; ++i){
                for(int j=0; j<m; ++j){
                    if(nums[i][j] == 1) {
                        q.add(new Triple(i, j, 0));
                        vis[i][j] = true;
                    }
                    res[i][j] = Integer.MAX_VALUE;
                }
            }
            while(!q.isEmpty()){
                Triple curr = q.poll();
                res[curr.x][curr.y] = Math.min(curr.w, res[curr.x][curr.y]);
                final int[][] shifts ={
                        {-1,0},
                        {0,1},
                        {1,0},
                        {0,-1},
                };
                for(int[] shift : shifts){
                    int x = curr.x + shift[0];
                    int y = curr.y + shift[1];
                    if(isValid(x,y,nums) && !vis[x][y]){
                        q.add(new Triple(x,y,curr.w+1));
                        vis[x][y] = true;
                    }
                }
            }
            for(int i=0; i<n-1; ++i){
                for(int j=0; j<m; ++j){
                    System.out.print(res[i][j] + " ");
                }
                System.out.println();
            }
            for(int j=0; j<m; ++j)
                System.out.print(res[n-1][j] + " ");
        }
    }
    public static boolean isValid(int x, int y, int[][] nums){
        return x>=0 && x<nums.length && y>=0 && y<nums[0].length;
    }
}
