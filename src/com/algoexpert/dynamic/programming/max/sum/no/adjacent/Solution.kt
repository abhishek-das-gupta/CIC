package com.algoexpert.dynamic.programming.max.sum.no.adjacent

import java.lang.Integer.max

fun main() {
    //[7, 10, 12, 7, 9, 14]
    //[7, 10, 7 + 12, 7 + 12, 7 + 12 + 9, 7 + 12 + 14]
    //dp[i] = max sum with no adjacent including a[i] or not including a[i]
    val a = readLine()!!.split(" ").map { it.toInt() }
    val dp = mutableListOf<Int>()
    dp.add(a[0])
    dp.add(max(dp[0], a[1]))
    for (i in 2 until a.size) {
        dp.add(max(a[i] + dp[i - 2], dp[i - 1]))
    }
    println(dp[a.size - 1])
}