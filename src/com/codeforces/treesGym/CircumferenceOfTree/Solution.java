package com.codeforces.treesGym.CircumferenceOfTree;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Solution {
    public static void main(String[] args) {
        FastScanner fs = new FastScanner();
        int n = fs.nextInt();
        if (n == 1) {
            System.out.println("0");
            return;
        }
        Node[] nodes = new Node[n];
        for (int i=0; i<n; ++i) {
            nodes[i] = new Node(i);
        }
        for (int i=0; i<n-1; ++i) {
            int[] e = fs.readArray(2);
            nodes[e[0] - 1].adjList.add(nodes[e[1] - 1]);
            nodes[e[1] - 1].adjList.add(nodes[e[0] - 1]);
        }
        bfs(nodes[0], nodes);
        Node farthest = farthest(nodes);
        bfs(farthest, nodes);
        System.out.println(3*farthest(nodes).dist);
    }

    private static void bfs(Node node, Node[] nodes) {
        for (Node n : nodes) {
            n.dist = -1;
        }
        node.dist = 0;
        Deque<Node> dq = new ArrayDeque<>();
        dq.offer(node);
        while (!dq.isEmpty()) {
            Node cur = dq.poll();
            for (Node adj : cur.adjList) {
                if (adj.dist == -1) {
                    adj.dist = cur.dist + 1;
                    dq.offer(adj);
                }
            }
        }
    }

    private static Node farthest(Node[] nodes) {
        Node max = nodes[0];
        for (Node nn : nodes) {
            if (nn.dist > max.dist) {
                max = nn;
            }
        }
        return max;
    }

    static class FastScanner {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer("");

        String next() {
            while (!st.hasMoreTokens())
                try {
                    st = new StringTokenizer(br.readLine());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            return st.nextToken();
        }

        int nextInt() {
            return Integer.parseInt(next());
        }

        int[] readArray(int n) {
            int[] a = new int[n];
            for (int i = 0; i < n; i++) a[i] = nextInt();
            return a;
        }

        long nextLong() {
            return Long.parseLong(next());
        }
    }

    static class Node {
        int val;
        List<Node> adjList;
        int dist;

        public Node (int val) {
            this.val = val;
            this.adjList = new ArrayList<>();
        }
    }
}
