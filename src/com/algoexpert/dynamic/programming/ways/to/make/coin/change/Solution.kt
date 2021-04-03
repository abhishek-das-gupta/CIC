package com.algoexpert.dynamic.programming.ways.to.make.coin.change

fun main() {
    val coins = readLine()!!.toInt()
    val denominations = readLine()!!.split(" ").map { it.toInt() }
    //dp[i][j] = given 0..i denominations, how to make the jth amount uniquely ?
    val dp = Array(denominations.size + 1) { IntArray(coins + 1) }

    for (i in 0..denominations.size) {
        for (j in 0..coins) {
            if (i == 0) dp[i][j] = 0
            else if (j == 0) dp[i][j] = 1
            else dp[i][j] = if (j - denominations[i - 1] >= 0) 1 + dp[i][j - denominations[i - 1]] else dp[i - 1][j]
        }
    }
    println(dp[denominations.size][coins])
}