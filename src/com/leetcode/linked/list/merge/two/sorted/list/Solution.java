package com.leetcode.linked.list.merge.two.sorted.list;

class Solution {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if(l1==null){
            return l2;
        }
        if(l2==null){
            return l1;
        }
        ListNode dummy = new ListNode(-1);
        ListNode curr = dummy;
        merge(l1,l2,curr);
        return dummy.next;
    }
    private void merge(ListNode l1, ListNode l2, ListNode curr){
        if(l1==null){
            curr.next = l2;
            return;
        }
        if(l2==null){
            curr.next = l1;
            return;
        }

        if(l1.val < l2.val){
            curr.next = l1;
            curr = curr.next;
            merge(l1.next,l2,curr);
        }
        else if(l1.val == l2.val){
            curr.next = l1;
            ListNode next1 = l1.next;
            curr = curr.next;

            curr.next = l2;
            ListNode next2 = l2.next;
            curr = curr.next;
            merge(next1,next2,curr);
        }
        else{
            curr.next = l2;
            curr = curr.next;
            merge(l1,l2.next,curr);
        }
    }

    public static void main(String[] args){
        ListNode l1 = new ListNode(1);
        l1.next = new ListNode(2);
        l1.next.next = new ListNode(4);

        ListNode l2 = new ListNode(1);
        l2.next = new ListNode(3);
        l2.next.next = new ListNode(4);

        Solution sol = new Solution();
        sol.mergeTwoLists(l1,l2);
    }
}