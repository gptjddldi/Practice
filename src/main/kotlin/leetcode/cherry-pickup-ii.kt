// dp 아닐까요 ?!
// dp[i] : row i 까지 봤을 때 최댓값
// dp[i] = dp[i-1] + max r1 + max r2 ( 직전 상태에서 갈 수 있는 최적인데.. 최대는 아닐듯? )

// dp[i][j][k] = r1: i,j / r2: i,k 위치일 때 최댓값
// dp[i][j][k] = max(dp[i-1][j-1][k-1] ~ dp[i-1][i+1][k+1]) + grid[i][j] + grid[i][k]
// 목표는 max(dp[i])
package leetcode
fun cherryPickup(grid: Array<IntArray>): Int {
    val rowSize = grid.size
    val colSize = grid[0].size
    val dp = Array(rowSize) { Array(colSize) { IntArray(colSize) } }
    dp[0][0][colSize-1] = grid[0][0] + grid[0][colSize-1]
    for(i in 1 until rowSize) {
        for(r1 in 0 .. minOf(i, colSize-1)) {
            for(r2 in maxOf(0, colSize-1-i) until colSize) {
                var m = 0
                for(j in r1-1..r1+1) {
                    for(k in r2-1..r2+1) {
                        if(j in 0 until colSize && k in 0 until colSize) {
                            dp[i][r1][r2] = maxOf(dp[i][r1][r2], dp[i-1][j][k] + grid[i][r1] + if(r1 == r2) 0 else grid[i][r2])
                        }
                    }
                }
            }
        }
    }
    return dp[rowSize-1].maxOf { it -> it.maxOf { it } }
}

