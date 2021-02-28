package com.leetcode.trees.all.possible.full.binary.trees;

import java.util.ArrayList;
import java.util.List;

class Solution {
    List<TreeNode> res = new ArrayList<>();
    public List<TreeNode> allPossibleFBT(int N) {
        if(N % 2 == 0) return res;
        TreeNode root = new TreeNode(0);
        dfs(root,root,1,N);
        return res;
    }
    private void dfs(TreeNode node, TreeNode root, int ct, int N){
        if(ct==N){
            res.add(root);
            return;
        }
        if(ct == 1){
            node.left = new TreeNode(0);
            node.right = new TreeNode(0);
            ct += 2;
            dfs(node.left, root,ct,N);
            dfs(node.right,root,ct+2,N);
        }
        else{
            node.left = new TreeNode(0);
            node.right = new TreeNode(0);
            ct += 2;
            if(ct == N){
                dfs(node,root,ct,N);
            }
            else {
                dfs(node.left, root, ct, N);
                dfs(node.right, root, ct, N);
            }
            ct -= 2;
            node.left = null;
            node.right = null;
        }
    }
    public static void main(String[] args){
        int N = 7;
        Solution s = new Solution();
        s.allPossibleFBT(N);
    }
}