package com.spoj.graphs.traversals.catm;

import java.lang.*;
import java.util.*;
import java.io.*;

public class Solution {
    public static void main(String[] args) throws java.lang.Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        int m = Integer.parseInt(s.split(" ")[0]);
        int n = Integer.parseInt(s.split(" ")[1]);
        int t = Integer.parseInt(br.readLine());
        while (t-- != 0) {
            String s1 = br.readLine();
            int[] mouse = {Integer.parseInt(s1.split(" ")[0]) - 1, Integer.parseInt(s1.split(" ")[1]) - 1};
            int[] cat1 = {Integer.parseInt(s1.split(" ")[2]) - 1, Integer.parseInt(s1.split(" ")[3]) - 1};
            int[] cat2 = {Integer.parseInt(s1.split(" ")[4]) - 1, Integer.parseInt(s1.split(" ")[5]) - 1};

            int[][] d_m = new int[m][n];
            int[][] d_c = new int[m][n];
            for(int i=0; i<m; ++i) {
                Arrays.fill(d_m[i], Integer.MAX_VALUE);
                Arrays.fill(d_c[i], Integer.MAX_VALUE);
            }

            bfs(mouse, d_m,m,n);
            bfs(cat1, d_c,m,n);
            bfs(cat2, d_c,m,n);

            boolean found = false;

            if(!found) {
                for (int i = 0; i < m; ++i) {
                    if(d_m[i][0] < d_c[i][0] || d_m[i][n-1] < d_c[i][n-1]){
                        System.out.println("YES");
                        found = true;
                        break;
                    }
                }
            }
            if(!found){
                for(int j=0; j<n; ++j){
                    if(d_m[0][j] < d_c[j][0] || d_m[m-1][j] < d_c[m-1][j]){
                        System.out.println("YES");
                        found = true;
                        break;
                    }
                }
            }
            if(!found){
                System.out.println("NO");
            }

        }
    }
    public static void bfs(int[] start, int[][] dist, int m, int n){
        Queue<int[]> q = new LinkedList<>();
        boolean[][] vis = new boolean[m][n];

        q.add(start);
        vis[start[0]][start[1]] = true;
        dist[start[0]][start[1]] = 0;

        while(!q.isEmpty()) {
            int[] curr = q.poll();
            int x = curr[0];
            int y = curr[1];

            final int[][] shifts = {
                    {-1, 0},
                    {0, 1},
                    {1, 0},
                    {0, -1}
            };
            for (int[] shift : shifts) {
                int dx = x + shift[0];
                int dy = y + shift[1];
                if (isValid(dx, dy, m, n) && !vis[dx][dy] && dist[dx][dy] > dist[x][y] + 1) {
                    q.add(new int[]{dx, dy});
                    vis[dx][dy] = true;
                    dist[dx][dy] = dist[x][y] + 1;
                }
            }
        }
    }
    public static boolean isValid(int x, int y, int m, int n){
        return 0 <= x && x < m && 0 <= y && y < n;
    }

}
