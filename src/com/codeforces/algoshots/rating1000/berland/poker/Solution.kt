package com.codeforces.algoshots.rating1000.berland.poker

fun main() {
    var t = readLine()!!.toInt()
    while (t-- > 0) {
        val (n, m, k) = readLine()!!.split(" ").map { it.toInt() }
        val share: Int = n / k
        if (share >= m) {
            println(m)
        } else {
            var y =  (m - share) / (k - 1)
            if ((m - share) % (k - 1) != 0) {
                y++
            }
            println(share - y)
        }
    }
}