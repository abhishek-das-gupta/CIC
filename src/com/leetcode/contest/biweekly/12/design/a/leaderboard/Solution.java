package com.leetcode.contest.biweekly.twelve.design.a.leaderboard;

import java.io.IOException;
import java.util.*;

class Leaderboard {
    private class Node{
        int id;
        int score;
        public Node(int id, int score){
            this.id = id;
            this.score = score;
        }
        public boolean equals(Object o){
            if(o==null){
                return false;
            }
            if(this==o){
                return true;
            }
            if(o.getClass() != this.getClass()){
                return false;
            }
            Node that = (Node) o;
            if(this.id != that.id || this.score != that.score){
                return false;
            }
            return true;
        }
        public int hashCode(){
            return Objects.hash(id,score);
        }
    }

    private PriorityQueue<Node> heap;
    private Map<Integer,Node> map;
    public Leaderboard() {
        heap = new PriorityQueue<Node>(new Comparator<Node>(){
            @Override
            public int compare(Node o1, Node o2){
                if(o1.score < o2.score){
                    return 1;
                }
                else if(o1.score == o2.score){
                    return 0;
                }
                else{
                    return -1;
                }
            }

        });
        map = new HashMap<Integer,Node>();

    }

    public void addScore(int playerId, int score) {
        if(!map.containsKey(playerId)){
            Node node = new Node(playerId,score);
            map.put(playerId,node);
            heap.add(node);
            //print();
        }
        else{
//            List<Node> list = new ArrayList<>();
//            Node node = map.get(playerId);
//            while(!node.equals(heap.peek())){
//                list.add(heap.poll());
//            }
//            list.add(heap.poll());
//            node.score = score;
//            for(Node aNode : list){
//                heap.add(aNode);
//            }
            Node node = map.get(playerId);
            node.score = score;
        }

    }

    public int top(int K) {
        //System.out.println("Int top(K)");
        //print();
        int sum = 0;
        List<Node> list = new ArrayList<>();
        while(K-- != 0){
            //System.out.println(heap.peek().id + " " + heap.peek().score);
            Node node = heap.poll();
            sum += node.score;
            list.add(node);
        }
        for(Node node : list){
            heap.add(node);
        }
        //System.out.println("sum : " + sum);
        return sum;

    }

    public void reset(int playerId) {
        Node node = map.get(playerId);
        map.remove(playerId);
        heap.remove(node);
        //print();
    }

    private void print(){
        PriorityQueue<Node> pq = new PriorityQueue<Node>(new Comparator<Node>(){
            @Override
            public int compare(Node o1, Node o2){
                if(o1.score < o2.score){
                    return 1;
                }
                else if(o1.score == o2.score){
                    return 0;
                }
                else{
                    return -1;
                }
            }

        });
        pq.addAll(heap);
        System.out.print("[");
        while(pq.size() > 1){
            Node node = pq.poll();
            System.out.print("[" + node.id + "," + node.score + "],");
        }
        System.out.println("[" + pq.peek().id + "," + pq.peek().score + "]" +"]");

    }

    public static void main(String[] args) throws IOException {
//        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
//        String line = in.readLine();
//        String[] actions = line.split(",");
//
//        Scanner sc = new Scanner(System.in);

        Leaderboard o = new Leaderboard();
        o.addScore(1,73);
        o.addScore(2,56);
        o.addScore(3,39);
        o.addScore(4,51);
        o.addScore(5,4);
        System.out.println(o.top(1));
        o.reset(1);
        o.reset(2);
        o.addScore(2,51);
        System.out.println(o.top(3));
    }
}
//["Leaderboard","addScore","addScore","addScore","addScore","addScore","top","reset","reset","addScore","top"]
//        [[],[1,73],[2,56],[3,39],[4,51],[5,4],[1],[1],[2],[2,51],[3]]
/**
 * Your Leaderboard object will be instantiated and called as such:
 * Leaderboard obj = new Leaderboard();
 * obj.addScore(playerId,score);
 * int param_2 = obj.top(K);
 * obj.reset(playerId);
 */