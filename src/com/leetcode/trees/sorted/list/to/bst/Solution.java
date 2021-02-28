package com.leetcode.trees.sorted.list.to.bst;

class Solution {
    public TreeNode sortedListToBST(ListNode head) {
        return sortedListToBST(head, getLast(head,null));

    }

    private TreeNode sortedListToBST(ListNode left, ListNode right){
        if(left == right || right.next == left){
            return null;
        }

        ListNode mid = getMiddle(left,right);
        TreeNode root = new TreeNode(mid.val);

        root.left = sortedListToBST(left, mid);
        root.right = sortedListToBST(mid.next, right);

        return root;

    }


    private ListNode getMiddle(ListNode left, ListNode right){
        ListNode fast = left;
        ListNode slow = left;
        while(fast != right && fast.next != null && fast.next != right){
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    private ListNode getLast(ListNode left, ListNode rightNext){
        ListNode last = left;
        while(last.next != rightNext){
            last = last.next;
        }
        return last;
    }

    public static void main(String[] args){
        ListNode head = new ListNode(-10);
        head.next = new ListNode(-3);
        head.next.next = new ListNode(0);
        head.next.next.next = new ListNode(5);
        head.next.next.next.next = new ListNode(6);

        Solution sol = new Solution();
        System.out.println(sol.sortedListToBST(head));
    }
}
