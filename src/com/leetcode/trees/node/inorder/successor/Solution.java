package com.leetcode.trees.node.inorder.successor;

public class Solution {
    private static TreeNode inorderSuccessor(TreeNode node){
        TreeNode searchPointer = node;

        while(searchPointer.right != null){
            searchPointer = searchPointer.right;

            while(searchPointer.left != null){
                searchPointer = searchPointer.left;
            }
            return searchPointer;
        }

        while(searchPointer.parent != null && searchPointer.parent.right == searchPointer){
            searchPointer = searchPointer.parent;
        }

        return searchPointer.parent;

    }


    public static void main(String args[]){
        TreeNode root = new TreeNode("root");
        TreeNode a = new TreeNode("a");
        TreeNode b = new TreeNode("b");
        TreeNode c = new TreeNode("c");
        TreeNode d = new TreeNode("d");
        TreeNode e = new TreeNode("e");
        TreeNode f = new TreeNode("f");

        root.left = a;
        root.right = b;

        a.left = c;
        a.right = d;
        a.parent = root;

        b.parent = root;

        c.parent = a;

        d.left = e;
        d.right = f;
        d.parent = a;

        e.parent = d;

        f.parent = d;

    /*
            root
           /     \
          a       b
        /   \
       c     d
            / \
           e   f
    */

        System.out.println("Inorder successor to 'root': " + inorderSuccessor(root).val);
        System.out.println("Inorder successor to 'a': " + inorderSuccessor(a).val);
        System.out.println("Inorder successor to 'b': " + inorderSuccessor(b)); // null, last node in inorder traversal
        System.out.println("Inorder successor to 'c': " + inorderSuccessor(c).val);
        System.out.println("Inorder successor to 'd': " + inorderSuccessor(d).val);
        System.out.println("Inorder successor to 'e': " + inorderSuccessor(e).val);
        System.out.println("Inorder successor to 'f': " + inorderSuccessor(f).val);
    }
}
