package leetcode

import kotlin.math.max

fun minSteps(s: String, t: String): Int {
    val tFreq = t.groupingBy { it }.eachCount()
    val sFreq = s.groupingBy { it }.eachCount()
    return sFreq
        .entries
        .sumOf{ (ch ,cnt) -> max(cnt - tFreq.getOrDefault(ch,0), 0)}
}