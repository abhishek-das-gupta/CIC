package com.leetcode.backtracking.numbers.with.same.consecutive.difference;

import java.util.*;

class Solution {
    List<Integer> res = new ArrayList<>();
    public int[] numsSameConsecDiff(int N, int K) {
        dfs(0, N, K, new StringBuilder());
        int[] ans = new int[res.size()];
        for(int i=0; i<ans.length; ++i) ans[i] = res.get(i);
        return ans;
    }
    private void dfs(int cur, int N, int K, StringBuilder sb) {
        if(cur == N) {
            res.add(Integer.parseInt(sb.toString()));
            return;
        }
        char[] arr = {'0','1','2','3','4','5','6','7','8','9'};
        for(int i=0; i<10; ++i) {
            if(cur == 0 && i == 0  && N > 1) continue;
            if(sb.length() > 0 &&
                    Math.abs((arr[i]-'0') - (sb.charAt(sb.length()-1)-'0')) != K) continue;
            sb.append(arr[i]);
            dfs(cur+1, N, K, sb);
            sb.deleteCharAt(sb.length()-1);
        }
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(Arrays.toString(s.numsSameConsecDiff(3, 7)));
    }
}