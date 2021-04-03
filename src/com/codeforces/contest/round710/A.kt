package com.codeforces.contest.round710

fun main() {
    val t = readLine()!!.toInt()
    repeat(t) {
        var (n, m, x) = readLine()!!.split(" ").map { it.toLong() }
        x--
        val col = x / n
        val row = x % n
        println(row * m + col + 1)
    }
}