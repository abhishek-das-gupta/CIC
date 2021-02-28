package com.leetcode.trees.trim.bst;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class Solution {
    public TreeNode trimBST(TreeNode root, int L, int R) {
        if(root == null){
            return null;
        }
        if(root.val < L  || root.val > R){
            return deleteBST(root,root.val);
        }

        TreeNode left = trimBST(root.left,L,R);
        TreeNode right = trimBST(root.right,L,R);
        return root;
    }

    private TreeNode deleteBST(TreeNode root,int val){
        if(root.val == val){
            if(root.left == null){
                return root.right;
            }
            else if(root.right == null){
                return root.left;
            }
            TreeNode nextInorderNode = getNextInorder(root.right);
            root.val = nextInorderNode.val;
            root.right = deleteBST(root.right,nextInorderNode.val);
        }
        return root;
    }

    private TreeNode getNextInorder(TreeNode root){
        TreeNode curr = root;
        while(curr.left != null){
            curr = curr.left;
        }
        return curr;
    }

    private String serialize(TreeNode root){
        if(root == null){
            return "null,";
        }

        String leftString = serialize(root.left);
        String rightString = serialize(root.right);
        return root.val + "," + leftString+ rightString;
    }

    private TreeNode deserialize(String data){
        Queue<String> nodesLeft = new LinkedList<>();
        nodesLeft.addAll(Arrays.asList(data.split(",")));
        System.out.println(nodesLeft.toString());
        return deserialize(nodesLeft);
    }
    private TreeNode deserialize(Queue<String> nodesLeft){
        String valueOfNode = nodesLeft.poll();
        if(valueOfNode.equals("null")) {
            return null;
        };
        TreeNode newNode = new TreeNode(Integer.parseInt(valueOfNode));
        newNode.left = deserialize(nodesLeft);
        newNode.right = deserialize(nodesLeft);

        return newNode;
    }

    public static void main(String[] args){
        Solution sol = new Solution();
        String s = "1,0,null,null,2,null,null";
        TreeNode root = sol.deserialize(s);
        root = sol.trimBST(root,1,2);
        System.out.println(sol.serialize(root));
    }
}
