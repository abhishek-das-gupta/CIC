package com.leetcode.union.find.path.in.a.grid;

import java.util.HashSet;
import java.util.Set;

class Solution {
    class UnionFind {
        int[] id;
        public UnionFind(int N) {
            id = new int[N];
            for (int i = 0; i < N; i++) {
                id[i] = i;
            }
        }
        public void union(int x, int y) {
            int rx = find(x), ry = find(y);
            if (rx != ry) {
                id[rx] = ry;
            }
        }
        public int find(int x) {
            if (id[x] != x) {
                id[x] = find(id[x]);
            }
            return id[x];
        }
    }

    public boolean hasValidPath(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        UnionFind uf = new UnionFind(4*m*n);

        //the street which has correspongding direction
        Set<Integer> up = new HashSet<>();
        up.add(2); up.add(5); up.add(6);
        Set<Integer> down = new HashSet<>();
        down.add(2); down.add(3); down.add(4);
        Set<Integer> left = new HashSet<>();
        left.add(1); left.add(3); left.add(5);
        Set<Integer> right = new HashSet<>();
        right.add(1); right.add(4); right.add(6);

        //build external connection, connect grid with grid if possible
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                int idx = i * n + j;
                //connect cur grid with downward grid if possible
                if (down.contains(grid[i][j])) {
                    if (i + 1 < m && up.contains(grid[i+1][j])) {
                        int d = (i + 1) * n + j;
                        uf.union(idx*4+3, d*4+1);
                    }
                }
                //connect cur grid with rightward grid if possible
                if (right.contains(grid[i][j])) {
                    if (j + 1 < n && left.contains(grid[i][j+1])) {
                        int r = i * n + (j + 1);
                        uf.union(idx*4+2, r*4);
                    }
                }
                //connect cur grid with upward grid if possible
                if (up.contains(grid[i][j])) {
                    if (i - 1 >= 0 && down.contains(grid[i-1][j])) {
                        int u = (i-1) * n + j;
                        uf.union(idx*4+1, u*4+3);
                    }
                }
                //connect cur grid with leftward grid if possible
                if (left.contains(grid[i][j])) {
                    if (j - 1 >= 0 && right.contains(grid[i][j-1])) {
                        int l = i * n + (j - 1);
                        uf.union(idx*4, l*4+2);
                    }
                }
            }
        }

        //build internal connection
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                int dir = grid[i][j];
                int idx = i * n + j;
                int b = 4 * idx;
                if (dir == 1) {
                    uf.union(b, b+2);
                } else if (dir == 2) {
                    uf.union(b+1, b+3);
                } else if (dir == 3) {
                    uf.union(b, b+3);
                } else if (dir == 4) {
                    uf.union(b+2, b+3);
                } else if (dir == 5) {
                    uf.union(b, b+1);
                } else {
                    uf.union(b+1, b+2);
                }
            }
        }

        //check if (0, 0) and (m-1, n-1) is connected
        int src = 0, des = m*n-1;
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < 4; i++) {
            set.add(uf.find(4*src+  i));
        }
        for (int i = 0; i < 4; i++) {
            if (set.contains(4*des+i)) return true;
        }
        return false;
    }

    public static void main(String[] args){
        Solution s = new Solution();
        int[][] grid = {{2,4,3},{6,5,2}};
        s.hasValidPath(grid);
    }
}