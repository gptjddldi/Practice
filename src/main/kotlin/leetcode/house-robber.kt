package leetcode

import kotlin.math.max

fun rob(nums: IntArray): Int {
    val sz = nums.size
    var prev1 = 0
    var prev2 = 0
    for(i in 0 until sz) {
        val tmp = prev1
        prev1 = max(prev1, prev2 + nums[i])
        prev2 = tmp
    }

    return prev1
}