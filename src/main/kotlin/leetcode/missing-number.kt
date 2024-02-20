package leetcode

fun missingNumber(nums: IntArray): Int {
    val sz = nums.size
    return (sz) * (sz+1) / 2 - nums.sum()
}

