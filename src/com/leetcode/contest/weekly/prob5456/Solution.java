package com.leetcode.contest.weekly.prob5456;

import java.util.*;

class TreeAncestor {
    TreeNode root;
    TreeNode[] nodes;
    Map<Integer,TreeNode> mp;
    public TreeAncestor(int n, int[] parent) {
        nodes = new TreeNode[n];
        mp = new HashMap<>();
        for(int i=0; i<n; ++i){
            if(i == 0){
                nodes[i] = new TreeNode(i);
                mp.put(i, nodes[i]);
                continue;
            }
            if(nodes[i] == null ){
                nodes[i]=new TreeNode(i);
            }
            if(nodes[parent[i]] == null){
                nodes[parent[i]] = new TreeNode(parent[i]);
            }
            if(nodes[parent[i]].left == null){
                nodes[parent[i]].left = nodes[i];
            }else{
                nodes[parent[i]].right = nodes[i];
            }
            nodes[i].parent = nodes[parent[i]];
            mp.put(i, nodes[i]);
            mp.put(parent[i], nodes[parent[i]]);
        }
        root = nodes[0];
        dfs(root);
    }

    public int getKthAncestor(int node, int k) {
        TreeNode cur = mp.get(node);
        while(k > 0 && cur != null){
            cur = cur.parent;
            k--;
        }
        return k > 0  || cur==null ? -1 : cur.val;
    }
    private class TreeNode{
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode parent;
        public TreeNode(int x){
            val = x;
        }
    }
    private void dfs(TreeNode root){
        if(root == null) return;
        System.out.println(root.val + " ");
        dfs(root.left);
        dfs(root.right);
    }

    public static void main(String[] args) {
        TreeAncestor ta = new TreeAncestor(7, new int[]{-1, 0, 0, 1, 1, 2, 2});
        System.out.println(ta.getKthAncestor(3,1));
        System.out.println(ta.getKthAncestor(5,2));
        System.out.println(ta.getKthAncestor(6,3));
    }
}

/**
 * Your TreeAncestor object will be instantiated and called as such:
 * TreeAncestor obj = new TreeAncestor(n, parent);
 * int param_1 = obj.getKthAncestor(node,k);
 */
