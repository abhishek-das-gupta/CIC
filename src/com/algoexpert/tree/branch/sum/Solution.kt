package com.algoexpert.tree.branch.sum

import com.algoexpert.tree.TreeNode

fun main() {
    val root = TreeNode(1, null, null)
    root.left = TreeNode(2, null, null)
    root.right = TreeNode(3, null, null)
    root.left!!.left = TreeNode(4, null, null)
    root.left!!.right = TreeNode(5, null, null)
    root.right!!.left = TreeNode(6, null, null)
    root.right!!.right = TreeNode(7, null, null)
    root.left!!.left!!.left = TreeNode(8, null, null)
    root.left!!.left!!.right = TreeNode(9, null, null)
    root.left!!.right!!.left = TreeNode(10, null, null)
    println(getBranchSum(root).joinToString(",","[", "]"))
}

fun getBranchSum(root: TreeNode?): List<Int> {
    val result = mutableListOf<Int>()
    visit(root, 0, result)
    return result
}

private fun visit(node: TreeNode?, curSum: Int, branchSums: List<Int>) {
    if (node == null) return
    if (node.left == null && node.right == null) {
        (branchSums as MutableList<Int>).add(curSum + node.value)
        return
    }
    visit(node.left, curSum + node.value, branchSums)
    visit(node.right, curSum + node.value, branchSums)
}
