package com.leetcode.arrays.find.peak.element

class Solution {
    fun findPeakElement(nums: IntArray): Int {
        var peak = Int.MIN_VALUE
        var idx = -1
        for (i in nums.indices) {
            val tmpPeak = maxOf(if (i - 1 < 0) Int.MIN_VALUE else nums[i - 1], nums[i],
                    if (i + 1 == nums.size) Int.MIN_VALUE else nums[i + 1])
            if (tmpPeak == nums[i] && tmpPeak > peak) {
                peak = tmpPeak
                idx = i
            }
        }
        return idx
    }
}