package com.spoj.graphs.traversals.LuciusDungeon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class Main {
    static class Pair{
        int x;
        int y;
        public Pair(int x, int y){
            this.x = x;
            this.y = y;
        }
    }
    static int rem = 0;
    public static void main(String[] args) throws java.lang.Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        while(t-- != 0) {
            String s1 = br.readLine();
            int m = Integer.parseInt(s1.split(" ")[0]);
            int n = Integer.parseInt(s1.split(" ")[1]);
            int[][] nums = new int[m][n];
            for(int i=0; i<m; ++i){
                String s2 = br.readLine();
                for(int j=0; j<n; ++j){
                    nums[i][j] = Integer.parseInt(s2.split(" ")[j]);
                }
            }
            boolean[][] vis = new boolean[m][n];
            int[][] vals = new int[m][n];
            for(int i=0; i<m; ++i)
                Arrays.fill(vals[i], Integer.MAX_VALUE);
            String s3 = br.readLine();
            int dstX = Integer.parseInt(s3.split(" ")[0]);
            int dstY = Integer.parseInt(s3.split(" ")[1]);
            int T = Integer.parseInt(s3.split(" ")[2]);

            PriorityQueue<Pair> pq = new PriorityQueue<Pair>(new Comparator<Pair>() {
                @Override
                public int compare(Pair p1, Pair p2) {
                    return vals[p1.x][p1.y] - vals[p2.x][p2.y];
                }
            });
            pq.offer(new Pair(0,0));
            vals[0][0] = nums[0][0];
            vis[0][0] = true;
            final int[][] shifts = {
                    {-1,0},
                    {0,1},
                    {1,0},
                    {0,-1}
            };

            while(!pq.isEmpty()){
                Pair curr = pq.poll();
                if(curr.x == dstX-1 && curr.y == dstY-1){
                    break;
                }
                for(int[] shift : shifts){
                    int x = curr.x+shift[0];
                    int y = curr.y+shift[1];

                    if(isValid(x,y,nums) && !vis[x][y] && vals[x][y] > nums[x][y] + vals[curr.x][curr.y]){
                        vals[x][y] = nums[x][y] + vals[curr.x][curr.y];
                        vis[x][y] = true;
                        pq.offer(new Pair(x,y));
                    }
                }

            }
            if(vals[dstX-1][dstY-1] <= T){
                rem = T-vals[dstX-1][dstY-1];
                System.out.println("YES" + "\n" + rem);
                rem=0;
            }else{
                System.out.println("NO");
            }
        }
    }
    public static boolean dfs(int i,int j, int T, int X, int Y, int[][] nums, boolean[][] vis){
        if(i == X-1 && j == Y-1){
            if(T <= 0){
                return false;
            }else{
                if(T-nums[i][j] >=0){
                    rem  = T-nums[i][j];
                    return true;
                }else{
                    return false;
                }
            }
        }
        if(T <= 0){
            return false;
        }
        T -= nums[i][j];
        vis[i][j] = true;
        final int[][] shifts = {
                {-1,0},
                {0,1},
                {1,0},
                {0,-1}
        };
        for(int[] shift : shifts){
            int x = i + shift[0];
            int y = j + shift[1];
            if(isValid(x,y,nums) && !vis[x][y]){
                if(dfs(x,y,T,X,Y,nums,vis)){
                    return true;
                }
            }
        }
        vis[i][j] = false;
        return false;
    }
    public static boolean isValid(int x,int y, int[][] nums){
        return 0<=x && x < nums.length && 0 <= y && y < nums[0].length;
    }
}
