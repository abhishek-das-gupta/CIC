package com.cwru.RateLimiter;

import java.util.*;

public class Solution {
    int[] rateLimiter2(long[] ts, String[] ip, int limit, int window) {
        int n = ts.length;
        int[] res = new int[n];
        Map<String, Integer> mp = new HashMap<>();
        int l = 0, r = 0;

        while (r < n) {
            if (ts[r] - ts[l] <= window) {
                if (mp.containsKey(ip[r])) {
                    if (mp.get(ip[r]) < limit) {
                        mp.put(ip[r], mp.getOrDefault(ip[r], 0) + 1);
                        res[r] = 1;
                    } else {
                        res[r] = 0;
                    }
                } else {
                    mp.put(ip[r], mp.getOrDefault(ip[r], 0) + 1);
                    res[r] = 1;
                }
                r++;
            } else {
                while (l < r && ts[r] - ts[l] > window) {
                    mp.put(ip[l], mp.getOrDefault(ip[l], 0) - 1);
                    if (mp.get(ip[l]) == 0) {
                        mp.remove(ip[l]);
                    }
                    l++;
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(Arrays.toString(s.rateLimiter2(new long[]{1600000000000L, 1600000000001L, 1600000000003L, 1600000000004L, 1600000000005L, 1600000000006L, 1600000000007L, 1600000000009L, 1600000000010L, 1600000000011L, 1600000000013L, 1600000000016L, 1600000000017L, 1600000000018L, 1600000000019L, 1600000000020L, 1600000000021L, 1600000000022L, 1600000000024L, 16000000000250L},
                new String[]{"1.2.2.1",
                        "1.6.2.7",
                        "1.6.2.7",
                        "1.2.2.1",
                        "1.6.2.7",
                        "1.6.2.7",
                        "1.2.2.1",
                        "1.2.2.1",
                        "1.2.2.1",
                        "1.6.2.7",
                        "1.2.2.1",
                        "1.2.2.1",
                        "1.2.2.1",
                        "1.6.2.7",
                        "1.6.2.7",
                        "1.2.2.1",
                        "1.6.2.7",
                        "1.2.2.1",
                        "1.6.2.7",
                        "1.2.2.1"},
                3,
                8
        )));
    }
}
