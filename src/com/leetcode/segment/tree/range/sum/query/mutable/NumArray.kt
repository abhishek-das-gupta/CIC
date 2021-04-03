package com.leetcode.segment.tree.range.sum.query.mutable

import com.leetcode.segment.tree.SegmentTree

class NumArray(nums: IntArray) {
    private val st = SegmentTree(nums)

    fun update(index: Int, `val`: Int) {
        st.update(index, `val`)
    }

    fun sumRange(left: Int, right: Int): Int {
        return st.sumRange(left, right)
    }

}

fun main() {
    val numArray = NumArray(intArrayOf(9, -8))
    numArray.update(0, 3)
    println(numArray.sumRange(1, 1))
    println(numArray.sumRange(0, 1))
    numArray.update(1, -3)
    println(numArray.sumRange(0, 1))
}