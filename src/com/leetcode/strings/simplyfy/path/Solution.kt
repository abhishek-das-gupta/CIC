package com.leetcode.strings.simplyfy.path

fun main() {
    println(simplifyPath(readLine()!!))
}
/**
 * /a/./b/../../c/
 * /a//b///c/
 * /a/b/c/
 * /a/b/c
 *
 * */
fun simplifyPath(path: String): String {
    val stack = mutableListOf<String>()
    path.split("/").forEach {
        when(it) {
            ".." -> if (stack.isNotEmpty()) stack.removeAt(stack.lastIndex)
            "." -> {
            }
            "" -> {
            }
            else -> stack.add(it)
        }
    }
    return "/" + stack.joinToString("/")
}