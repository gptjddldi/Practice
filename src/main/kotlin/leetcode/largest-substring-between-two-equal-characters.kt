package leetcode

import kotlin.math.max

fun maxLengthBetweenEqualCharacters(s: String): Int {
    val arr = IntArray(26) { -1 }
    var ret = -1
    for(i in s.indices) {
        val c = s[i] - 'a'
        if(arr[c] >= 0) ret = max(i - arr[c] - 1, ret)
        else arr[c] = i
    }
    return ret
}