package leetcode

import kotlin.math.max

// O(N^2)
fun lengthOfLIS(nums: IntArray): Int {
    val dp = IntArray(2500) { 1 }

    for (i in nums.size - 1 downTo 0) {
        for(j in i+1 until nums.size) {
            if (nums[j] > nums[i])
                dp[i] = max(dp[i], dp[j] + 1)
        }
    }
    return dp.max()
}

// O(Nlog(N))
// 솔루션 봤슴;
fun lengthOfLIS2(nums: IntArray): Int {
    val lis = mutableListOf<Int>()
    for(num in nums) {
        var idx = lis.binarySearch(num)
        if (idx < 0) idx = -idx - 1
        if (idx == lis.size) lis += num else lis[idx] = num
    }

    return lis.size
}