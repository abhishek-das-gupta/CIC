package com.codeforces.treesGym.DynamicDiameter;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.*;

public class Solution {
    public static void main(String[] args) {
        FastScanner fs = new FastScanner();
        int n = fs.nextInt();
        Node[] nodes = new Node[n];
        for (int i = 0; i < n; ++i) {
            nodes[i] = new Node(i);
        }
        for (int i = 0; i < n - 1; ++i) {
            int a = fs.nextInt() - 1, b = fs.nextInt() - 1;
            nodes[a].adjList.add(nodes[b]);
            nodes[b].adjList.add(nodes[a]);
        }
        //1. Find the original diameter.
        bfs(nodes[0], nodes);
        Node farthestNode = farthest(nodes);
        bfs(farthestNode, nodes);
        Node endNodeOfDiameter = farthest(nodes);
        int originalDiameter = endNodeOfDiameter.dist;
        //2. Check whether each node is a previous diameter.
        for (Node node : nodes) {
            //2.a  Check whether its distance from current farthest node (node.dist) equals original diameter.
            node.isEndPointOfDiameter |= node.dist == originalDiameter;
        }
        //2.b Goto the other endpoint of the diameter since the farthest node from a particular node is
        //one of the endpoints of a diameter.
        bfs(endNodeOfDiameter, nodes);
        for (Node node : nodes) {
            node.isEndPointOfDiameter |= node.dist == originalDiameter;
        }
        for (Node node : nodes) {
            System.out.println(node.isEndPointOfDiameter ? originalDiameter + 1 : originalDiameter);
        }

    }

    private static Node farthest(Node[] nodes) {
        Node max = nodes[0];
        for (Node nn : nodes) {
            if (max.dist < nn.dist) {
                max = nn;
            }
        }
        return max;
    }

    private static void bfs(Node from, Node[] nodes) {
        for (Node nn : nodes) {
            nn.dist = -1;
        }
        from.dist = 0;
        Deque<Node> q = new ArrayDeque<>();
        q.offer(from);
        while (!q.isEmpty()) {
            Node cur = q.poll();
            for (Node adj : cur.adjList) {
                if (adj.dist == -1) {
                    adj.dist = cur.dist + 1;
                    q.offer(adj);
                }
            }
        }
    }

    static class Node {
        int val;
        List<Node> adjList;
        int dist;
        boolean isEndPointOfDiameter;

        public Node(int val) {
            this.val = val;
            this.adjList = new ArrayList<>();
            this.isEndPointOfDiameter = false;
        }
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
}
