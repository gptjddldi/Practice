package leetcode

import kotlin.math.min


// dp[i][j]: i,j 까지 왔을 때의 최솟값
fun minFallingPathSum(matrix: Array<IntArray>): Int {
    val sz = matrix.size
    val dp = Array<IntArray>(sz) { IntArray(sz) { 100 } }
    dp[0] = matrix[0]
    for (i in 1 until sz){
        for (j in 0 until sz){
            when (j) {
                0 -> {
                    dp[i][j] = matrix[i][j] + min(dp[i-1][j], dp[i-1][j+1])
                }
                sz -1 -> {
                    dp[i][j] = matrix[i][j] + min(dp[i-1][j-1], dp[i-1][j])
                }
                else -> {
                    dp[i][j] = matrix[i][j] + listOf(dp[i-1][j-1], dp[i-1][j], dp[i-1][j+1]).min()
                }
            }
        }
    }
    return dp[sz-1].min()
}
