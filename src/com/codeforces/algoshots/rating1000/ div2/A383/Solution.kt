package com.codeforces.algoshots.rating1000.div2.A383

fun main() {
    val n = readLine()!!.toInt()
    if (n == 0) {
        println(1)
        return
    }
    val last = when (n % 4) {
        0 -> 6
        1 -> 8
        2 -> 4
        else -> 2
    }
    println(last)
}