package com.leetcode.linked.list.odd.even.list;

class Solution {
    public ListNode oddEvenList(ListNode head) {
        if(head == null || head.next == null){
            return head;
        }

        ListNode oddDummy = new ListNode(-1);
        ListNode evenDummy = new ListNode(-10);
        oddEvenList(head,oddDummy,evenDummy);
        ListNode lastNode = getLast(oddDummy.next);
        lastNode.next = evenDummy.next;

        return oddDummy.next;
    }

    private void oddEvenList(ListNode node,ListNode oddDummy, ListNode evenDummy){
        if(node == null){
            return;
        }

        oddDummy.next = node;
        oddDummy = oddDummy.next;
        if(node.next != null){
            ListNode evenNode = node.next;
            //oddDummy = node.next.next;
            evenDummy.next = node.next;
            evenDummy = evenDummy.next;

            oddEvenList(node.next.next, oddDummy, evenDummy);
        }
        else{
            evenDummy.next = null;
        }

    }

    private ListNode getLast(ListNode head){
        if(head.next == null){
            return head;
        }
        return getLast(head.next);
    }

    public static void main(String[] args){
        ListNode head = new ListNode(2);
        head.next = new ListNode(1);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(5);
        head.next.next.next.next = new ListNode(6);
        head.next.next.next.next.next = new ListNode(4);
        head.next.next.next.next.next.next = new ListNode(7);

        Solution s = new Solution();
        s.oddEvenList(head);

    }
}