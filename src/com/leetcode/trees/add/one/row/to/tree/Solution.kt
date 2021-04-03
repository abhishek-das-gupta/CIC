package com.leetcode.trees.add.one.row.to.tree

import java.lang.StringBuilder
import java.util.*

/**
 * Example:
 * var ti = TreeNode(5)
 * var v = ti.`val`
 * Definition for a binary tree node.
 * class TreeNode(var `val`: Int) {
 *     var left: TreeNode? = null
 *     var right: TreeNode? = null
 * }
 */
class Solution {
    fun addOneRow(root: TreeNode?, `val`: Int, depth: Int): TreeNode? {
        if (root == null) return null
        if (depth == 1) {
            val _root = TreeNode(`val`)
            _root.left = root
            return _root
        }
        val q = LinkedList<Pair<TreeNode?, Int>>()
        q.offer(Pair(root, 1))
        var isDepth = false
        while (!q.isEmpty()) {
            val n = q.size
            for (i in 0 until n) {
                val pair = q.poll()
                val cur = pair.first
                if (!isDepth && pair.second == depth -1){
                    isDepth = true
                }
                if (isDepth) {
                    val tmpleft = TreeNode(`val`)
                    if (cur?.left != null) {
                        tmpleft.left = cur.left
                    }
                    cur?.left = tmpleft
                    val tmpRight = TreeNode(`val`)
                    if (cur?.right != null) {
                        tmpRight.right = cur.right
                    }
                    cur?.right = tmpRight
                } else {
                    if (cur?.left != null) {
                        q.offer(Pair(cur.left, pair.second + 1))
                    }
                    if (cur?.right != null) {
                        q.offer(Pair(cur.right, pair.second + 1))
                    }
                }
            }
            if (isDepth) {
                break
            }
        }
        return root
    }
}

fun main() {
    val root = TreeNode(4)
    root.left = TreeNode(2)
    root.right = TreeNode(6)
    root.left?.left = TreeNode(3)
    root.left?.right = TreeNode(1)
    root.right?.left = TreeNode(5)
    Solution().addOneRow(root, 1, 2)
}

class TreeNode (val `val`: Int) {
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