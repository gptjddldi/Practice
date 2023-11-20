package leetcode
import kotlin.math.max

fun minPairSum(nums: IntArray): Int {
    val s = nums.sorted()
    var ret = 0
    for(i in 0 until s.size/2){
        ret = max(ret, s[i] + s[s.size - 1 - i])
    }
    return ret
}
