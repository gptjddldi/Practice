package leetcode

import java.util.*


fun jobScheduling(startTime: IntArray, endTime: IntArray, profit: IntArray): Int {
    val sortedIndices = endTime.indices.sortedBy { endTime[it] }
    val n = startTime.size

    val sortedStartTime = sortedIndices.map { startTime[it] }.toIntArray()
    val sortedEndTime = sortedIndices.map { endTime[it] }.toIntArray()
    val sortedProfit = sortedIndices.map { profit[it] }.toIntArray()

    val dp = TreeMap<Int,Int>()
    dp[0] = 0

    for (i in 0 until n) {
        val v = dp.floorEntry(sortedStartTime[i]).value + sortedProfit[i]
        if(v > dp.lastEntry().value) dp[sortedEndTime[i]] = v
    }
    return dp.lastEntry().value

}