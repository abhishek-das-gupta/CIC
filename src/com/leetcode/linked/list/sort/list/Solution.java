package com.leetcode.linked.list.sort.list;

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode sortList(ListNode head) {
        if(head == null || head.next == null){
            return head;
        }

        ListNode prev = findMidsPrevious(head);
        ListNode mid = prev.next;

        prev.next = null;

        ListNode leftSortedList = sortList(head);
        ListNode rightSortedList = sortList(mid);

        ListNode dummy = new ListNode(-1);

        merge(leftSortedList, rightSortedList, dummy);

        return dummy.next;


    }

    private void merge(ListNode left, ListNode right, ListNode dummy){
        if(left == null ){
            dummy.next = right;
            return;
        }
        else if(right == null){
            dummy.next = left;
            return;
        }

        if(left.val <= right.val){
            dummy.next = left;
            dummy = dummy.next;
            merge(left.next, right,dummy);
        }
        else{
            dummy.next = right;
            dummy = dummy.next;
            merge(left, right.next,dummy);
        }

    }

    private ListNode findMidsPrevious(ListNode head){
        ListNode prev = null;
        ListNode slow = head;
        ListNode fast = head;

        while(fast != null && fast.next != null){
            prev = slow;
            slow = slow.next;
            fast = fast.next.next;
        }

        return prev;
    }


    public static void main(String[] args){
        ListNode head = new ListNode(4);
        head.next = new ListNode(2);
        head.next.next = new ListNode(1);
        head.next.next.next = new ListNode(3);

        Solution s = new Solution();
        s.sortList(head);
    }
}