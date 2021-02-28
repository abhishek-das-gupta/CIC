package com.cic.recursion.jump.references;

import java.util.Stack;

public class Solution {

    private class Node{
        public int value;
        public Node jump;
        public Node next;

        public Node(int value, Node jump, Node next){
            this.value = value;
            this.jump = jump;
            this.next = next;
        }
    }

    public void setJumpOrder(Node head){
        Integer order = 0;
        setJumpOrderHelper(head,order);
    }

    private void setJumpOrderHelper(Node node, Integer order){
        if(node.value != -1 || node == null){
            return;
        }
        node.value = order++;
        setJumpOrderHelper(node.jump,order);
        setJumpOrderHelper(node.next,order);
    }

    public void setJumpOrderIteratively(Node head){
        Stack<Node> stk = new Stack<>();
        int order = 0;
        stk.push(head);

        while(!stk.isEmpty()){
            Node node = stk.pop();
            if(node != null && node.value == -1){
                node.value = order++;
                stk.push(node.next);
                stk.push(node.jump);
            }
        }
    }
}
