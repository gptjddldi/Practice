package leetcode

import kotlin.math.min

// arr 을 d 개의 subArray 로 나눔
// 각 subArray 의 최댓값의 합이 최소가 되도록 함
// 예를 들어 arr: [1,2,6,4,5,6] d: 3
// 인 경우 [1] [2] [6,4,5,6] => 9임

// dp[i][j] : idx i 까지 j 개로 나눴을 때 최솟값
// dp[i][j] = min(dp[j-1][j-1] + maxi[j][i] ~ dp[i-1][j-1] + maxi[i][i])
// 이런 느낌임 ㅋ
// 그럼 dp 와 maxi array 두 개 필요
// maxi[i][j]: idx i ~ j 중 최댓값
// maxi[i][j] =
// return dp[size][d]

fun minDifficulty(arr: IntArray, d: Int): Int {
    val sz = arr.size
    if(sz < d) return -1
    val dp = Array(sz) { (IntArray(d) { Int.MAX_VALUE }) }

    for (i in 0 until sz){
        dp[i][0] = arr.slice(0..i).max()
    }

    for(i in 0 until sz) {
        for (j in 1 until d) {
            for(k in j .. i) {
                if(dp[k-1][j-1] != Int.MAX_VALUE)
                    dp[i][j] = min(dp[i][j], dp[k-1][j-1] + arr.slice(k..i).max())
            }
        }
    }

    return dp[sz-1][d-1]
}