package com.leetcode.trees.path.sum.II;

import java.util.ArrayList;
import java.util.List;

public class Solution {

    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        List<List<Integer>> paths = new ArrayList<>();
        //List<TreeNode> aPath = new ArrayList<>()
        pathSum(root, sum, new ArrayList<>(), paths);
        return paths;
    }

    private void pathSum(TreeNode root, int sum, List<Integer> aPath, List<List<Integer>> paths){
        if(root == null){
            return;
        }

        boolean isLeaf = root.left == null && root.right == null;
        if(isLeaf && sum - root.val == 0){
            aPath.add(root.val);
            paths.add(new ArrayList<>(aPath));
            aPath.remove(aPath.size() - 1);
            return;
        }

        aPath.add(root.val);
        if(root.left != null){
            pathSum(root.left, sum-root.val, aPath, paths);
        }

        if(root.right != null){
            pathSum(root.right, sum-root.val, aPath, paths);
        }
        aPath.remove(aPath.size()-1);


    }

    public static void main(String[] args){
        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(4);
        root.right = new TreeNode(8);

        root.left.left = new TreeNode(11);

        root.left.left.left = new TreeNode(7);
        root.left.left.right = new TreeNode(2);

        root.right.left = new TreeNode(13);
        root.right.right = new TreeNode(4);

        root.right.right.left = new TreeNode(5);
        root.right.right.right = new TreeNode(1);

        Solution s = new Solution();
        System.out.println(s.pathSum(root, 22));
    }


}
