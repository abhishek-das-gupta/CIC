package com.codeforces.algoshots.rating1000.NewTheatreSquare

fun main() {
    var t = readLine()!!.toInt()
    while (t-- > 0) {
        val (n, m, x, y) = readLine()!!.split(" ").map { it.toInt() }
        val arr = mutableListOf<CharArray>()
        for (i in 0 until n) {
            arr.add(readLine()!!.toCharArray())
        }
        var ans = 0
        var i = 0
        while (i < n) {
            var j = 0
            while (j < m) {
                if (arr[i][j] == '*') {
                    j++
                    continue
                } else {
                    if (j + 1 < m && arr[i][j + 1] == '.') {
                        ans += if (2*x < y) {
                            2*x
                        } else {
                            y
                        }
                        j++
                    } else if (j + 1 == m || arr[i][j + 1] == '*') {
                        ans += x
                    }
                }
                j++
            }
            i++
        }
        println(ans)
    }
}