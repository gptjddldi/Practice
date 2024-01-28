package leetcode

fun subarraySum(nums: IntArray, k: Int): Int {
    val h = HashMap<Int,Int>()
    h[0] = 1
    var ret = 0
    var s = 0
    for(num in nums) {
        s += num
        ret += h.getOrDefault(s-k, 0)
        h[s] = h.getOrDefault(s, 0) + 1
    }
    return ret
}
