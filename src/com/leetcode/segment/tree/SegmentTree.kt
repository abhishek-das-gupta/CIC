package com.leetcode.segment.tree

import java.lang.Integer.max

class SegmentTree(private val arr: IntArray) {
    private val n = 4 * arr.size
    private val heap = IntArray(n + 1)

    init {
        build(arr, 1, 0, arr.size - 1)
    }

    /**
     * Builds segment tree.
     * */
    private fun build(arr: IntArray, curIndex: Int, low: Int, high: Int) {
        if (low == high) {
            heap[curIndex] = arr[low]
        } else {
            val mid = low + (high - low) / 2
            build(arr, curIndex * 2, low, mid)
            build(arr, curIndex * 2 + 1, mid + 1, high)
            heap[curIndex] = heap[curIndex * 2] + heap[curIndex * 2 + 1]
        }
    }

    fun update(index: Int, `val`: Int) {
        update(1, 0, arr.size - 1, index, `val`)
    }

    private fun update(v: Int, segLow: Int, segHigh: Int, pos: Int, value: Int) {
        if (segLow == segHigh) {
            heap[v] = value
        } else {
            val mid = segLow + (segHigh - segLow) / 2
            if (pos <= mid)
                update(2 * v, segLow, mid, pos, value)
            else
                update(2 * v + 1, mid + 1, segHigh, pos, value)
            heap[v] = heap[2 * v] + heap[2 * v + 1]
        }
    }

    fun sumRange(left: Int, right: Int): Int {
        return rsq(1, 0, arr.size - 1, left, right)
    }

    private fun rsq(v: Int, segLow: Int, segHigh: Int, left: Int, right: Int): Int {
        if (left > right) return 0
        if (left == segLow && right == segHigh) return heap[v]
        val mid = segLow + (segHigh - segLow) / 2
        return rsq(2 * v, segLow, mid, left, Math.min(right, mid)) +
                rsq(2 * v + 1, mid + 1, segHigh, max(mid + 1, left), right)
    }
}