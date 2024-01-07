package leetcode

fun numberOfArithmeticSlices1(nums: IntArray): Int {
    if (nums.size < 3) return 0
    var i = 0
    var j = 2
    var ret = 0
    var cur = 0
    var f = false
    while(j < nums.size && i +2 <= j) {
        if(nums[i+1] - nums[i] == nums[j] - nums[j-1]) {
            cur = j - i + 1
            j++
            if(j == nums.size) ret += calc2(cur)
        }
        else {
            ret += calc2(cur)
            cur = 0
            i = j-1
            j++
        }
    }
    return ret
}

fun calc2(n: Int): Int{
    if (n < 3) return 0
    return (n-2) * (n - 1) / 2
}

// ### dp
fun numberOfArithmeticSlices(nums: IntArray): Int {
    if (nums.size < 3) return 0
    val dp = IntArray(nums.size) { 0 }
    if (nums[1] - nums[0] == nums[2] - nums[1]) dp[2] = 1
    var ret = dp[2]

    for(i in 3 until nums.size) {
        if(nums[i-1] - nums[i-2] == nums[i] - nums[i-1]) dp[i] = dp[i-1] + 1
        ret += dp[i]
    }

    return ret
}
