package com.leetcode.linked.list.reorder.list;

import java.util.*;

class Solution {
    ListNode head2 = null;
    public void reorderList(ListNode head1) {
        if(head1 == null || head1.next == null) return;
        middle(head1);
        reverse();
        merge(head1);
    }
    private void middle(ListNode head1) {
        ListNode slow=head1, fast = head1;
        while(fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        head2 = slow.next;
        slow.next = null;
    }
    private void reverse() {
        ListNode next=null, prev = null;
        ListNode cur = head2;
        while(cur != null) {
            next = cur.next;
            cur.next = prev;
            prev = cur;
            cur = next;
        }
        head2 = prev;
    }
    private void merge(ListNode head1) {
        ListNode cur1 = head1, cur2 = head2;
        while(cur1 != null && cur2 != null) {
            ListNode next1 = cur1.next;
            cur1.next = cur2;
            ListNode next2 = cur2.next;
            cur2.next = next1;
            cur1 = next1;
            cur2 = next2;
        }
    }

    public static void main(String[] args) {
        Solution s= new Solution();
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);
        s.reorderList(head);
    }
}