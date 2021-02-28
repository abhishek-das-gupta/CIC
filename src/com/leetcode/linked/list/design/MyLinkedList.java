package com.leetcode.linked.list.design;

class MyLinkedList {
    private class ListNode{
        int val;
        ListNode next;

        public ListNode(int val,ListNode next){
            this.val = val;
            this.next = next;
        }
    }

    ListNode sentinel;
    int size;

    /** Initialize your data structure here. */
    public MyLinkedList() {
        sentinel = new ListNode(-1,null);
        size = 0;
    }

    /** Get the value of the index-th node in the linked list. If the index is invalid, return -1. */
    public int get(int index) {
        if(sentinel.next == null){
            return -1;
        }
        if(index >= size() || index < 0){
            return -1;
        }
        ListNode curr = sentinel.next;
        for(int i=0; i<index ; i++){
            curr = curr.next;
        }

        return curr.val;
    }

    /** Add a node of value val before the first element of the linked list. After the insertion, the new node will be the first node of the linked list. */
    public void addAtHead(int val) {
        sentinel.next = new ListNode(val, sentinel.next);
        size++;
    }

    /** Append a node of value val to the last element of the linked list. */
    public void addAtTail(int val) {
        ListNode curr = sentinel.next;
        if(curr == null){
            sentinel.next = new ListNode(val, sentinel.next);
            size++;
            return;
        }
        while(curr.next != null){
            curr = curr.next;
        }
        curr.next = new ListNode(val,curr.next);
        size++;
    }

    /** Add a node of value val before the index-th node in the linked list. If index equals to the length of linked list, the node will be appended to the end of linked list. If index is greater than the length, the node will not be inserted. */
    public void addAtIndex(int index, int val) {
//        if(sentinel.next == null && index != 0){
//            return;
//        }
        if(index < 0){
            addAtHead(val);
            return;
        }
        else if(index ==size()){
            addAtTail(val);
            return;
        }
        else if(index > size()){
            return;
        }
        ListNode curr  = sentinel.next;
        ListNode prev = null;

        for(int i=0; i<index; i++){
            prev = curr;
            curr = curr.next;
        }
        prev.next = new ListNode(val, curr);
        size++;
    }


    /** Delete the index-th node in the linked list, if the index is valid. */
    public void deleteAtIndex(int index) {
        // if(sentinel.next == null){
        //     return;
        // }
        if(index >= size() || index < 0){
            return;
        }
        ListNode curr = sentinel.next;
        ListNode prev = null;
        for(int i=0; i<index; i++){
            prev = curr;
            curr = curr.next;
        }
        prev.next = curr.next;
        size--;
    }

    private int size(){
        return size;
    }

    public static void main(String[] args){
        MyLinkedList list = new MyLinkedList();
        //list.addAtHead(1);
        //list.addAtTail(3);
        list.addAtIndex(-1,0);
        System.out.println(list.get(0));
        list.deleteAtIndex(-1);
        //System.out.println(list.get(1));
    }
}

/**
 * Your MyLinkedList object will be instantiated and called as such:
 * MyLinkedList obj = new MyLinkedList();
 * int param_1 = obj.get(index);
 * obj.addAtHead(val);
 * obj.addAtTail(val);
 * obj.addAtIndex(index,val);
 * obj.deleteAtIndex(index);
 */