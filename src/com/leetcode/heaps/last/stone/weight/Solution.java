package com.leetcode.heaps.last.stone.weight;

import java.util.Comparator;
import java.util.PriorityQueue;

class Solution {
    public int lastStoneWeight(int[] stones) {
        PriorityQueue<Integer> heap = new PriorityQueue<Integer>(stones.length, new Comparator<Integer>(){
            @Override
            public int compare(Integer o1, Integer o2){
                if(o1 < o2){
                    return 1;
                }else if(o1 == o2){
                    return 0;
                }else{
                    return -1;
                }
            }
        });

        for(int val : stones){
            heap.add(val);
        }

        while(!heap.isEmpty() && heap.size() != 1){
            int x = heap.poll();
            int y = heap.poll();
            if(x == y){
                continue;
            }else{
                y = Math.abs(x-y);
                System.out.println(heap.toString());
                heap.add(y);
                System.out.println(heap.toString());
            }
        }

        return heap.size() == 0 ? 0 : heap.peek();
    }

    public static void main(String[] args){
        Solution sol = new Solution();
        int [] stones = {2,7,4,1,8,1};
        System.out.println(sol.lastStoneWeight(stones));
    }
}