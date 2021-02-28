package com.leetcode.contest.weekly.displaytable;

import java.util.*;
class Solution {
    public static List<List<String>> displayTable(List<List<String>> orders) {
        List<List<String>> res = new ArrayList<>();
        Map<Integer,Set<String>> mp = new HashMap<>();
        Map<String, Integer> mp2 = new HashMap<>();
        Set<String> set = new HashSet<>();
        for(List<String> order : orders){
            set.add(order.get(2));
            mp.putIfAbsent(Integer.parseInt(order.get(1)), new HashSet<String>());
            mp.get(Integer.parseInt(order.get(1))).add(order.get(2));
            mp2.put(order.get(1) + "&" + order.get(2), mp2.getOrDefault(order.get(1) + "&" + order.get(2),0)+1);
        }
        List<String> header = new ArrayList<>(set);
        Collections.sort(header);
        header.add(0, "Table");
        res.add(new ArrayList<String>(header));
        List<Integer> tables = new ArrayList<>(mp.keySet());
        Collections.sort(tables);
        for(int table : tables){
            List<String> curr = new ArrayList<>(header.size());
            curr.add(Integer.toString(table));
            List<String> tableOrders = new ArrayList<>(mp.get(table));
            Collections.sort(tableOrders);
            int j=0;
            for(int i=1; i<header.size(); ++i){
                if(!mp2.containsKey(table + "&" + header.get(i))){
                    curr.add("0");
                }else{
                    curr.add(Integer.toString(mp2.get(table + "&" + header.get(i))));
                }
            }
            res.add(new ArrayList<>(curr));
        }
        return res;
    }
    public static void main(String[] args){
        String[][] str = {{"David","3","Ceviche"},
                {"Corina","10","Beef Burrito"},
                {"David","3","Fried Chicken"},
                {"Carla","5","Water"},
                {"Carla","5","Ceviche"},
                {"Rous","3","Ceviche"}
        };
        List<List<String>> orders = new ArrayList<>();
        for(int i=0; i<str.length; ++i)
            orders.add(new ArrayList<>(Arrays.asList(str[i])));

        System.out.println(Solution.displayTable(orders));
    }
}