package com.codeforces.algoshots.rating1000.lovely.palindrome

fun main() {
    val n = readLine()!!
    //11 --> 1
    //22 --> 2
    //...
    //1001  -> 10
    println(n + n.reversed())
}