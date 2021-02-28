package com.leetcode.dynamic.programming.question871;

import java.util.*;

public class Solution {
    Map<String,Integer> dp = new HashMap<>();
    public int minRefuelStops(int target, int startFuel, int[][] stations) {
        if (stations.length == 0 || stations[0].length == 0) {
            return startFuel - target >= 0 ? 0 : -1;
        }
        int n = stations.length;
        List<int[]> vii = new ArrayList<>();
        vii.add(stations[0]);
        for(int i=1; i<n; ++i) {
            vii.add(new int[]{stations[i][0]-stations[i-1][0], stations[i][1]});
        }
        vii.add(new int[]{target-stations[n-1][0], 0});
        int res = dfs(startFuel, 0, 0, vii);
        return res == Integer.MAX_VALUE ? -1 : res;
    }

    private int dfs(int curFuel, int curIdx, int stops, List<int[]> vii) {
        if (curIdx == vii.size()-1) {
            if(curFuel - vii.get(curIdx)[0] < 0) {
                return Integer.MAX_VALUE;
            }
            else {
                return stops;
            }
        }

        if(dp.containsKey(curFuel + "-" + curIdx)) {
            return dp.get(curFuel + "-" + curIdx);
        }

        if (curFuel - vii.get(curIdx)[0] < 0) {
            return Integer.MAX_VALUE;
        }

        curFuel -= vii.get(curIdx)[0];
        int withOrWithout = dfs(curFuel + vii.get(curIdx)[1], curIdx + 1, stops + 1, vii);
        withOrWithout = Math.min(withOrWithout, dfs(curFuel, curIdx + 1, stops, vii));

        dp.put(curFuel+"-"+curIdx, withOrWithout);

        return withOrWithout;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        int target = 100;
        int startFuel = 10;
        int[][] stations = {{10, 60}, {20, 30}, {30, 30}, {60, 40}};
        System.out.println(s.minRefuelStops(target, startFuel, stations));
    }
}