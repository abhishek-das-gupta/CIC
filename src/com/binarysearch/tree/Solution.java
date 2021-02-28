package com.binarysearch.tree;


import java.util.LinkedList;
import java.util.Queue;

class Solution {
    public int solve(Tree root) {
        if (root == null) {
            return 0;
        }
        Queue<Tree> q = new LinkedList<>();
        q.offer(root);
        int result = 0;
        while(!q.isEmpty()) {
            int n = q.size();
            int l = 0, r = 0;
            boolean isLeftMost = false;
            for (int i=0; i<n; ++i) {
                Tree cur = q.poll();
                if (cur != null && !isLeftMost) {
                    isLeftMost = true;
                    l = i;
                    if (cur != null) {
                        q.offer(cur.left);
                        q.offer(cur.right);
                    }
                    continue;
                }
                if (isLeftMost && cur != null) {
                    r = i;
                }
                if (cur != null) {
                    q.offer(cur.left);
                    q.offer(cur.right);
                }
            }
            //System.out.println(l + " " + r);
            result = Math.max(result, r - l + 1);
        }
        return result;
    }
}