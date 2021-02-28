package com.spoj.graphs.traversals.keytask;

import java.util.*;
import java.io.*;
import java.lang.*;

public class Main {
    public static void main(String[] args) throws java.lang.Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        try {
            while (true) {
                String s = br.readLine();
                int m = Integer.parseInt(s.split(" ")[0]);
                int n = Integer.parseInt(s.split(" ")[1]);

                if (m == 0 && n == 0) return;

                char[][] grid = new char[m][n];
                int[][][] d = new int[3][20][16];
                int[] start = null;
                for (int i = 0; i < m; ++i) {
                    String s1 = br.readLine();
                    for (int j = 0; j < n; ++j) {
                        grid[i][j] = s1.charAt(j);
                        if (grid[i][j] == '*') start = new int[]{i, j};
                        for (int k = 0; k < 16; ++k)
                            d[i][j][k] = -1;
                    }
                }


                int res = bfs(start, grid, d);
                if (res >= 0) {
                    System.out.println("Escape possible in " + res + " steps.");
                } else {
                    System.out.println("The poor student is trapped!");
                }
            }
        }catch(Exception e){
            return;
        }

    }

    public static int bfs(int[] start, char[][] grid, int[][][] d) {
        int m = grid.length;
        int n = grid[0].length;

        Queue<int[]> q = new LinkedList<>();
        d[start[0]][start[1]][0] = 0;
        q.add(new int[]{start[0], start[1], 0});

        while (!q.isEmpty()) {
            int[] curr = q.poll();
            int x = curr[0];
            int y = curr[1];
            int umask = curr[2];
            final int[][] shifts = {
                    {-1, 0},
                    {0, 1},
                    {1, 0},
                    {0, -1}
            };
            for (int[] shift : shifts) {
                int dx = x + shift[0];
                int dy = y + shift[1];

                if (isValid(dx, dy, m, n) && grid[dx][dy] != '#') {
                    if (grid[dx][dy] == 'X') {
                        return d[x][y][umask] + 1;
                    }
                    if (d[dx][dy][umask] == -1) {
                        char val = grid[dx][dy];
                        if (val == 'r' || val == 'b' || val == 'g' || val == 'y') {
                            int vmask = umask;
                            if (val == 'r') vmask |= 0x1;
                            else if (val == 'b') vmask |= 0x2;
                            else if (val == 'g') vmask |= 0x4;
                            else vmask |= 0x8;

                            q.add(new int[]{dx, dy, vmask});
                            d[dx][dy][umask] = d[x][y][umask] + 1;
                            d[dx][dy][vmask] = d[dx][dy][umask];
                        } else if (val == 'R' || val == 'G' || val == 'B' || val == 'Y') {
                            switch (val) {
                                case 'R':
                                    if ((umask & 0x1) == 1) q.add(new int[]{dx, dy, umask});
                                    break;
                                case 'B':
                                    if ((umask & 0x2) == 2) q.add(new int[]{dx, dy, umask});
                                    break;
                                case 'G':
                                    if ((umask & 0x4) == 4) q.add(new int[]{dx, dy, umask});
                                    break;
                                case 'Y':
                                    if ((umask & 0x8) == 8) q.add(new int[]{dx, dy, umask});
                                    break;
                            }
                            d[dx][dy][umask] = d[x][y][umask] + 1;
                        } else {
                            q.add(new int[]{dx, dy, umask});
                            d[dx][dy][umask] = d[x][y][umask] + 1;
                        }
                    }
                }
            }
        }
        return -1;
    }

    public static boolean isValid(int x, int y, int m, int n) {
        return 0 <= x && x < m && 0 <= y && y < n;
    }
}
