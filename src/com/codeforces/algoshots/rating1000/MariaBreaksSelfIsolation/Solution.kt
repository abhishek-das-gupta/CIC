package com.codeforces.algoshots.rating1000.MariaBreaksSelfIsolation

fun main() {
    var t = readLine()!!.toInt()
    while (t-- > 0) {
        val n = readLine()!!.toInt()
        val a = readLine()!!.split(" ").map{ it.toInt() }.sorted()
        var flag = false
        for (i in n-1 downTo 0) {
            if (a[i] <= i + 1) {
                println(i + 2)
                flag = true
                break
            }
        }
        if (!flag) {
            println(1)
        }
    }
}