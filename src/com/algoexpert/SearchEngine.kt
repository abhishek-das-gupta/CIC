package com.algoexpert

fun main() {
    while (true) {
        var s: String? = readLine() ?: break
        val sb = StringBuilder()
        var i = 0
        if (s != null) {
            while (i < s.length) {
                if (s[i] == '\\' && i + 1 < s.length) {
                    if (s[i + 1] == 'b' && sb.isNotEmpty()) {
                        sb.deleteCharAt(sb.length - 1)
                    }
                    if (s[i + 1] == 'n') {
                        println(sb)
                        sb.setLength(0)
                    }
                    i++
                } else {
                    sb.append(s[i])
                }
                i++
            }
        }
    }
}