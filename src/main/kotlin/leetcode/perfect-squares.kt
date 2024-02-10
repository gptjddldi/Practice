package leetcode

import kotlin.math.min
import kotlin.math.pow

// dp[i] = min(dp[i-1], dp[i-4], dp[i-9] ... (최대 100개 )) + 1

fun numSquares(n: Int): Int {
    val dp = IntArray(n+1) { 10002 }
    dp[0] = 0
    for(i in 1..n) {
        for(j in 1..i){
            val sq = j.toDouble().pow(2)
            if(sq <= i)
                dp[i] = min(dp[i], dp[i-sq.toInt()]+1)
            else break
        }
    }
    return dp[n]
}
