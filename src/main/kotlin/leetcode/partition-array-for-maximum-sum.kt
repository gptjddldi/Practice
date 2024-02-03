package leetcode

import kotlin.math.max

fun maxSumAfterPartitioning(arr: IntArray, k: Int): Int {
    val sz = arr.size
    val dp = IntArray(sz) { 0 }
    dp[0] = arr[0]
    for(i in 0 until sz) {
        var cur = 0
        for(j in 1 .. k) {
            if(i - j + 1 >= 0){
                cur = max(cur, arr[i-j+1])
                dp[i] = max(dp[i], (if(i-j>=0) dp[i-j] else 0) + cur * j)
                arr.slice(i-j .. i).max()
            }
        }
    }
    return dp[sz-1]
}

fun maxSumAfterPartitioning2(arr: IntArray, k: Int): Int {
    val sz = arr.size
    val dp = IntArray(sz) { 0 }
    dp[0] = arr[0]
    for(i in 1 until sz) {
        for(j in 1 .. k) {
            if(i-j >= 0){
                dp[i] = max(dp[i], dp[i-j] + arr.slice(i-j+1 .. i).max() * j)
            } else if (i-j == -1) {
                dp[i] = max(dp[i], arr.slice(0..i).max() * j)
            }
        }
    }
    return dp[sz-1]
}