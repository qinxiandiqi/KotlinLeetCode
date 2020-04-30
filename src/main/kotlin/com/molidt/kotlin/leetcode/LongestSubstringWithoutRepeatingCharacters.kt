package com.molidt.kotlin.leetcode

class LongestSubstringWithoutRepeatingCharacters {

    fun lengthOfLongestSubstring(s: String): Int {
        var maxSubLength = 0
        var currentStartIndex = 0
        val charIndexMap = mutableMapOf<Char, Int>()
        s.forEachIndexed { index, c ->
            charIndexMap[c]?.let {
                if (it >= currentStartIndex) {
                    val length = index - currentStartIndex
                    if (length > maxSubLength) {
                        maxSubLength = length
                    }
                    currentStartIndex = it + 1
                }
            }
            charIndexMap[c] = index
        }
        val length = s.length - currentStartIndex
        if (length > maxSubLength) {
            maxSubLength = length
        }
        return maxSubLength
    }
}