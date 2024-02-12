package leetcode

fun majorityElement(nums: IntArray): Int {
    var cnt = 0
    var ret = 0
    for(num in nums) {
        if (cnt == 0) ret = num
        if (ret == num) cnt ++
        else cnt --
    }
    return ret
}