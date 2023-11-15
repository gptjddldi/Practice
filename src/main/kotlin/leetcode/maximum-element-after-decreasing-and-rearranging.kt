package leetcode

import kotlin.math.min


// solution 1. with sort
fun maximumElementAfterDecrementingAndRearranging(arr: IntArray): Int {
    var cur = 0
    arr.sort()
    arr.forEach {
        if (it > cur) cur++
    }
    return cur
}

// solution 2. without sort
fun maximumElementAfterDecrementingAndRearranging2(arr: IntArray): Int {
    val cnt = IntArray(arr.size + 1) { 0 }
    arr.forEach {
        cnt[min(arr.size, it)] ++
    }
    var ret = 1
    for (i in 2..arr.size) {
        ret = min(ret + cnt[i], i)
    }
    return ret
}