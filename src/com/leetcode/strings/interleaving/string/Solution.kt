package com.leetcode.strings.interleaving.string

class Solution {
    fun isInterleave(s1: String, s2: String, s3: String): Boolean {
        val n = s1.length
        val m = s2.length
        val l = s3.length
        if (n + m != l) return false
        //dp[i][j] = is s3[0...i+j] interleaves s1[0...i] and s2[0...j] ?
        var dp = Array(n + 1) { BooleanArray(m + 1) { false } }

        for (i in 0..n) {
            for (j in 0..m) {
                if (i == 0 && j == 0) dp[i][j] = true
                else if (i == 0) dp[i][j] = s2[j - 1] == s3[j - 1] && dp[i][j - 1]
                else if (j == 0) dp[i][j] = s1[i - 1] == s3[i - 1] && dp[i - 1][j]
                else
                    dp[i][j] = (s1[i - 1] == s3[i + j - 1] && dp[i - 1][j]) ||
                            (s2[j - 1] == s3[i + j - 1] && dp[i][j - 1])
            }
        }
        return dp[n][m]
    }
}

fun main() {
    println(Solution().isInterleave("aabcc", "dbbca", "aadbbcbcac"))
}