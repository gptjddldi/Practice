package leetcode

import kotlin.math.min

fun countPalindromicSubsequence(s: String): Int {
    var ret = 0
    val left = IntArray(26) { 100005 }
    val right = IntArray(26) { 0 }
    for (i in s.indices) {
        val ch = s[i].code - 'a'.code
        left[ch] = min(left[ch], i)
        right[ch] = i
    }
    for (i in 0..25) {
        if (right[i] > left[i]) {
            ret += s.substring(left[i] + 1, right[i]).chars().distinct().count().toInt()
        }
    }
    return ret
}
