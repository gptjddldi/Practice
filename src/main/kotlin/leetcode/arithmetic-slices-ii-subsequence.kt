package leetcode

// dp[i]: i 번째가 마지막일 때의 개수
// 근데 subarray 가 아니라 subsequence 임

// i 번째가 마지막일 때 그 개수는 어떻게 찾는가?
// i 보다 작은 것들의 개수를 봐야겠지?
// 그것들의 개수를 보는데 걔내들은 그 안에 difference 가 있을텐데, nums[i] 가 그 diff 를 만족해야 함
// 예를들면 dp[j] = 1 이면 nums[i] - nums[j] 가 dp[j] 를 구성하는 그것들과 맞아야 함
// 근데 만약 dp[j] = 2 이고 두 개의 diff 가 다른 경우도 있을 수 있음
// 그럼 어떻게 구분함?
// 그래서 dp 에는 diff 와 개수 모두를 저장해야 함
// dp[j] = (2, 3) 이런 식임.. 그래서
// for k in 0 ~ i-1
// if (dp[k][nums[i] - nums[k]]) dp[n][nums[i] - nums[k]] = dp[k][nums[i] - nums[k]] + 1
// 이런 느낌임
fun numberOfArithmeticSlices2(nums: IntArray): Int {
    val len = nums.size
    if (len < 3) return 0
    var ret = 0L
    val dp = Array<HashMap<Long,Long>>(len) { hashMapOf<Long,Long>() }
    for (i in 0 until len) {
        for (j in 0 until i) {
            var diff = nums[i].toLong() - nums[j].toLong()
            dp[i][diff] = dp[i].getOrDefault(diff, 0) + 1
            if(dp[j][diff] != null){
                dp[i][diff] = dp[i][diff]!! + dp[j][diff]!!
                ret += dp[j][diff]!!
            }

        }
    }
    return ret.toInt()
}


