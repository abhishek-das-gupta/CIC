package com.leetcode.trees.flatten.binary.tree.into.linked.list

import java.lang.StringBuilder

class Solution {
    fun flatten(root: TreeNode?): Unit {
        unparse(root)
    }

    private fun unparse(root: TreeNode?): Pair<TreeNode?, TreeNode?>? {
        if (root == null) {
            return null
        }
        if (root.left == null && root.right == null) {
            return Pair(root, root)
        }
        val leftPair = unparse(root.left)
        val rightPair = unparse(root.right)
        return if (leftPair != null && rightPair != null) {
            leftPair.second?.right = rightPair.first
            root.right = leftPair.first
            root.left = null
            Pair(root, rightPair.second)
        } else if (leftPair == null) {
            Pair(root, rightPair?.second)
        } else {
            root.right = leftPair.first
            root.left = null
            Pair(root, leftPair.second)
        }
    }
    companion object {
        class TreeNode(var `val`: Int) {
            var left: TreeNode? = null
            var right: TreeNode? = null

            override fun toString(): String {
                val writer = StringBuilder()
                unparse(writer, this)
                return writer.toString()
            }

            private fun unparse(writer: StringBuilder, node: TreeNode?) {
                if (node == null) {
                    writer.append("null")
                    return
                }
                writer.append(node.`val`)
                writer.append("(")
                writer.append(unparse(writer, node.left))
                writer.append(", ")
                writer.append(unparse(writer, node.right))
                writer.append(")")
            }
        }
    }

}

fun main() {
    val root = Solution.Companion.TreeNode(1)
    root.left = Solution.Companion.TreeNode(2)
//    root.right = Solution.Companion.TreeNode(5)
//    root.left?.left = Solution.Companion.TreeNode(3)
//    root.left?.right = Solution.Companion.TreeNode(4)
//    root.right?.right = Solution.Companion.TreeNode(6)
    Solution().flatten(root)
}