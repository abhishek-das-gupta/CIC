package com.codeforces.algoshots.rating1000.RemoveDuplicates

import java.util.*
import kotlin.collections.HashSet

fun main() {
    val n = readLine()!!.toInt()
    val a = readLine()!!.split(" ").map { it.toInt() }
    val pq  = PriorityQueue<Pair<Int, Int>>(compareBy{ it.first })
    val set = HashSet<Int>()

    for (i in n-1 downTo 0) {
        if (!set.contains(a[i])) {
            pq.offer(Pair(i, a[i]))
            set.add(a[i])
        }
    }
    val ans = mutableListOf<Int>()
    while (!pq.isEmpty()) {
        ans.add(pq.poll().second)
    }
    println(ans.size)
    println(ans.joinToString(" "))
}