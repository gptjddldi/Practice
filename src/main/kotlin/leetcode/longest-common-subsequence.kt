package leetcode

import kotlin.math.max

// dp[i][j] t1[i], t2[j] 까지 봤을 때 최댓값
// return dp[-1][-1]

// dp[i][j] = dp[i-1][j-1] + 1 if t1[i] == t2[j]
// else dp[i][j] = max(dp[i-1][j], dp[i][j-1])
fun longestCommonSubsequence(t1: String, t2: String): Int {
    val s1 = t1.length
    val s2 = t2.length
    val dp = Array(s1+1) { IntArray(s2+1) { 0 } }
    for(i in 0 until s1){
        for(j in 0 until s2) {
            if(t1[i] == t2[j])
                dp[i+1][j+1] = dp[i][j] + 1
            else
                dp[i+1][j+1] = max(dp[i][j+1], dp[i+1][j])
        }
    }

    return dp[s1][s2]
}
