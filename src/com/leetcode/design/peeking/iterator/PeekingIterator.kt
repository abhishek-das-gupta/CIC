package com.leetcode.design.peeking.iterator

class PeekingIterator(iterator: Iterator<Int>) : Iterator<Int> {
    private var index = 0
    private val list = iterator.asSequence().toList()

    fun peek(): Int {
        return list[index]
    }

    override fun next(): Int {
        return list[index++]
    }

    override fun hasNext(): Boolean {
        return index < list.size
    }
}