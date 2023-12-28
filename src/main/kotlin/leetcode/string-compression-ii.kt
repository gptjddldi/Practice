package leetcode

import kotlin.math.min

// dp[i][k] : 최대 k 개를 삭제했을 때 s[0~i] 의 최소 길이
fun getLengthOfOptimalCompression(s: String, k: Int): Int {
    val sz = s.length
    val dp = Array(110) { IntArray(110) { 9999 } }
    dp[0][0] = 0
    for (i in 1..s.length) {
        for (j in 0..k) {
            if(j>0) dp[i][j] = dp[i-1][j-1]
            var cnt = 0
            var del = 0
            for (l in i downTo 1) {
                if(s[l-1] == s[i-1]) cnt++
                else del++
                if(j>=del) dp[i][j] = min(dp[i][j], dp[l-1][j-del] + 1 +cnt(cnt))
            }
        }
    }
    return dp[s.length][k]
}

fun cnt(cnt: Int): Int{
    return if (cnt >= 100) 3
    else if (cnt >= 10) 2
    else if (cnt >= 2) 1
    else 0
}