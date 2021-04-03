package com.codeforces.algoshots.rating1000.DonutShops

fun main() {
    var t = readLine()!!.toInt()
    while (t-- > 0) {
        val (a, b, c) = readLine()!!.split(" ").map { it.toLong() }
        //1. cost of buying 1 donut in for cost of  and
        // cost of buying 1 donut from for cost of c.'
        if (a < c) print("1 ")
        else print("-1 ")
        if (b * a > c) println("$b")
        else println("-1")
    }
}