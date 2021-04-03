package com.leetcode.backtracking.different.ways.to.add.parentheses

class Solution {
    fun diffWaysToCompute(expression: String): List<Int> {
        val res = mutableListOf<Int>()
        for (i in expression.indices) {
            val c = expression[i]
            if (c == '+' || c == '-' || c == '*') {
                val operand1 = expression.substring(0, i)
                val operand2 = expression.substring(i + 1)
                val leftResult = diffWaysToCompute(operand1)
                val rightResult = diffWaysToCompute(operand2)
                leftResult.forEach { it1 ->
                    rightResult.forEach { it2 ->
                        val finalResult = when (c) {
                            '+' -> it1 + it2
                            '-' -> it1 - it2
                            else -> it1 * it2
                        }
                        res.add(finalResult)
                    }
                }
            }
        }
        if (res.isEmpty()) {
            res.add(expression.toInt())
        }
        return res
    }
}

fun main() {
    println(Solution().diffWaysToCompute("2-1-1"))
}