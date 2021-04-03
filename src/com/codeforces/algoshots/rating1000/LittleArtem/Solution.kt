package com.codeforces.algoshots.rating1000.LittleArtem

import java.lang.StringBuilder

fun main() {
    var t = readLine()!!.toInt()
    while (t-- > 0) {
        val (n, m) = readLine()!!.split(" ").map{ it.toInt() }
        val sb = StringBuilder()
        for (i in 0 until n) {
            for (j in 0 until m) {
                if (i == 0 && j == 0) {
                    sb.append("W")
                } else {
                    sb.append("B")
                }
            }
            sb.append("\n")
        }
        println(sb.trim())
    }
}