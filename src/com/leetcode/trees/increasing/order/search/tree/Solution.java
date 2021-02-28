package com.leetcode.trees.increasing.order.search.tree;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class Solution {
    public TreeNode increasingBST(TreeNode root) {
        String nodesMaterialized =  serializeBST(root);

        Queue<String> nodesLeft = new LinkedList<>();

        nodesLeft.addAll(Arrays.asList(nodesMaterialized.split(",")));

        System.out.println(nodesLeft.toString());

        return increasingBST(nodesLeft);
    }


    private String serializeBST(TreeNode root){
        if(root == null){
            return "null,";
        }
        if(root.left == null && root.right == null){
            return Integer.toString(root.val) + ",";
        }


        String leftSerialized = serializeBST(root.left);
        String rightSerialized = serializeBST(root.right);

        return leftSerialized + root.val + "," + rightSerialized;
    }

    private TreeNode increasingBST(Queue<String> nodesLeft){
        if(nodesLeft.isEmpty()){
            return null;
        }
        String valueOfNode = nodesLeft.poll();

        if(valueOfNode.equals("null")){
            return increasingBST(nodesLeft);
        }

        TreeNode newNode = new TreeNode(Integer.parseInt(valueOfNode));

        newNode.right = increasingBST(nodesLeft);

        return newNode;
    }

    private TreeNode deserialize(String data){
        Queue<String> nodesLeft = new LinkedList<>();
        nodesLeft.addAll(Arrays.asList(data.split(",")));

        return deserialize(nodesLeft);
    }

    private TreeNode deserialize(Queue<String> nodesLeft){
        String valueOfNode = nodesLeft.poll();

        if(valueOfNode.equals("null")){
            return null;
        }

        TreeNode newNode = new TreeNode(Integer.parseInt(valueOfNode));

        newNode.left = deserialize(nodesLeft);
        newNode.right = deserialize(nodesLeft);

        return  newNode;
    }

    public static void main(String[] args){
        Solution sol = new Solution();
        String s = "5,3,6,2,4,null,8,1,null,null,null,7,9";
        TreeNode root = sol.deserialize(s);

        System.out.println(sol.increasingBST(root));
    }
}
