package com.algoexpert.recursion.product.sum

fun main() {
    //[5, 2, [7, -1], 3, [6, [-13, 8], 4]]
    //5 + 2 + (7 - 1)*2 + 3 + (6 + (-13 + 8) * 3 + 4)*2
    //5 + 2  + (7 - 1)* 2 + 3 + 20
    val list = listOf(5, 2, listOf(7, -1), 3, listOf(6, listOf(-13, 8), 4))
    println(productSum(list))
}

private fun productSum(list: List<Any>): Int {
    return dfs(list, 1)
}

private fun dfs(list: List<Any>, depth: Int): Int {
    var sum = 0
    for (i in list.indices){
        sum += if (list[i] is Int) {
            list[i] as Int
        } else {
            dfs(list[i] as List<Any>, depth + 1)
        }
    }
    return sum * depth
}
