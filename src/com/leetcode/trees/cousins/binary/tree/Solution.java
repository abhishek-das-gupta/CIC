package com.leetcode.trees.cousins.binary.tree;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

class Solution {

    private class Cousin{

            public int depth;
        public TreeNode parent;

        public Cousin(){
            depth = -1;
            parent = null;
        }
        @Override
        public boolean equals(Object o){
            if(o == null){
                return false;
            }
            if(this == o){
                return true;
            }
            if(this.getClass() != o.getClass()){
                return false;
            }
            Cousin that = (Cousin) o;
            if(this.depth == -1 || that.depth == -1){
                return false;
            }

            if(this.depth == that.depth && this.parent != that.parent){
                return true;
            }
            return false;
        }
        @Override
        public int hashCode(){
            return Objects.hash(depth,parent);
        }
    }

    private Cousin doDFS(TreeNode root, int depth, int cousin,Cousin obj){
        if(root == null){
            return null;
        }
        if(root.left != null && root.left.val == cousin){
            obj.parent  = root;
            obj.depth = depth+1;
            return obj;
        }
        if(root.right !=null && root.right.val == cousin){
            obj.parent  = root;
            obj.depth = depth+1;
            return obj;
        }
        if(obj.depth != -1 && obj.parent != null) {
            return doDFS(root.left, depth + 1, cousin,obj);
        }

        if(obj.depth != -1 && obj.parent != null) {
            return doDFS(root.right, depth + 1, cousin,obj);
        }
        return obj;
    }

    public boolean isCousins(TreeNode root, int x, int y) {
        if(root == null){
            return false;
        }



        Cousin xCousin = new Cousin();
        xCousin = doDFS(root, 0, x, xCousin);

        Cousin yCousin = new Cousin();
        yCousin = doDFS(root, 0, y, yCousin);

        return xCousin.equals(yCousin);


    }

    public static void main(String[] args){
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);

        root.left.right = new TreeNode(4);
        root.right.right = new TreeNode(5);

        Solution sol = new Solution();
        System.out.println(sol.isCousins(root, 5, 4));
    }
}
