package com.leetcode.linked.list.partition.list

import java.lang.StringBuilder
import java.util.*
import kotlin.Comparator

/**
 * Example:
 * var li = ListNode(5)
 * var v = li.`val`
 * Definition for singly-linked list.
 * class ListNode(var `val`: Int) {
 *     var next: ListNode? = null
 * }
 */
class Solution {
    fun partition(head: ListNode?, x: Int): ListNode? {
        val dummy1 = ListNode(-1)
        var d1 = dummy1
        val dummy2 = ListNode(-1)
        var d2 = dummy2
        var cur = head

        while (cur != null) {
            if (cur.`val` < x) {
                d1.next = ListNode(cur.`val`)
                d1 = d1.next!!
            } else {
                d2.next = ListNode(cur.`val`)
                d2 = d2.next!!
            }
            cur = cur.next
        }
        d1.next = dummy2.next
        d2.next = null
        return dummy1.next
    }
    class ListNode(var `val`: Int) {
        var next: ListNode? = null

        override fun toString(): String {
            var cur = this
            val writer = StringBuilder()
            while (cur.next != null) {
                writer.append("${cur.`val`}->")
                cur = cur.next!!
            }
            writer.append("${cur.`val`}")
            return writer.toString()
        }
    }
}

fun main() {
    val head = Solution.ListNode(1)
    head.next = Solution.ListNode(4)
    head.next?.next = Solution.ListNode(3)
    head.next?.next?.next = Solution.ListNode(2)
    head.next?.next?.next?.next = Solution.ListNode(5)
    head.next?.next?.next?.next?.next = Solution.ListNode(2)
    var result = Solution().partition(head, 3)
    while (result?.next != null) {
        print("${result.`val`}->")
        result = result.next
    }
    print(result?.`val`)
}