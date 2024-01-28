// [1,3,2]
// inverse pair: (1,2)
// [2,1,3]
// inverse pair: (0,1)

// decreasing 부분이 있으면 inverse pair 을 만들 수 있음
// k 개의 decreasing 을 가지는 list 를 구하면 됨

// 3,0
// [1,2,3] [1,3,2] [2,1,3] ,[2,3,1] ,[3,1,2], [3,2,1]
// => [1,2,3]

// 3,1
// => [1,3,2], [2,1,3]
// => 2,1 + 2,0
// => 1,1 + 1,0 + 2,0

// 3,2
// => [2,3,1], [3,1,2]

// 4,2
// [1,2,3,4] ,[1,2,4,3], [1,3,2,4], [1,3,4,2], [1,4,2,3], [1,4,3,2]
// [2,1,3,4], [2,1,4,3], [2,3,1,4], [2,3,4,1], [2,4,1,3], [2,4,3,1]
// [3,1,2,4], [3,1,4,2], [3,2,1,4], [3,2,4,1], [3,4,1,2], [3,4,2,1]
// [4,1,2,3], [4,1,3,2], [4,2,1,3], [4,2,3,1], [4,3,1,2], [4,3,2,1]
// => [1,3,4,2], [1,4,2,3], [2,1,4,3], [2,3,1,4], [3,1,2,4] 5개

// dp[i][j]: n = i+1 이고 k = j 일 때 개수
// return dp[n][k]
// dp[i][j] = dp[i-1][j] + dp[i-1][j-1] ~ dp[i-1][0]
fun kInversePairs(n: Int, k: Int): Int {
    if (k == 0) return 1
    val modulo = 1000000007
    val dp = Array(n) { LongArray(k+1) { 0L } }
    for(i in 0 until n) dp[i][0] = 1L
    for(i in 1 until n) {
        for(j in 1 .. k) {
            dp[i][j] = ((dp[i][j-1] + dp[i-1][j]) % modulo) -
                    (if(j-i-1 >= 0) dp[i-1][j-i-1] else 0L)
            if(dp[i][j] < 0) dp[i][j] = modulo + dp[i][j]
        }
    }
    return dp[n-1][k].toInt()
}
