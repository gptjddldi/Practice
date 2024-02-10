package leetcode
fun countSubstrings(s: String): Int {
    val sz = s.length
    val dp = Array(sz) { BooleanArray(sz) }
    for(i in sz-1 downTo 0) {
        dp[i][i] = true
        for(j in i+1 until sz) {
            if(s[i] == s[j]) {
                if(j == i+1) dp[i][j] = true
                else if (dp[i+1][j-1]) dp[i][j] = true
            }
        }
    }
    return dp.sumOf { it.count { it } }
}

fun main() {
    println(countSubstrings("aba"))

}