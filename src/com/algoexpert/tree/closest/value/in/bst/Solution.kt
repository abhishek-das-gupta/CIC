package com.algoexpert.tree.closest.value.`in`.bst

import com.algoexpert.tree.TreeNode
import kotlin.math.abs

fun main() {
    val root = null
    println(visit(root, 12, Pair(-1, Int.MAX_VALUE)))
}

private fun visit(node: TreeNode?, target: Int, pair: Pair) {
    if (node == null) return
    if (pair.dif > abs(node.value - target)) {
        pair.closest = node.value
        pair.dif = abs(node.value - target)
    }
    //if the current node's value is less than target value, then
    //there is no need to traverse current node's left subtree since
    //every difference will be greater than current min difference.
    if (node.value < target) {
        visit(node.right, target, pair)
    }
    //if the current node's value is greater than target value, then
    //there is no need to traverse current node's right subtree since
    //every difference will be greater than current min difference.
    if (node.value > target) {
        visit(node.left, target, pair)
    }
}

private class Pair(var closest: Int, var dif: Int)