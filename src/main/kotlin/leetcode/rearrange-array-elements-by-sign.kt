package leetcode

fun rearrangeArray(nums: IntArray): IntArray {
    val sz = nums.size
    val ret = IntArray(sz)
    var p = 0
    var n = 1
    for(num in nums) {
        if(num > 0){
            ret[p] = num
            p += 2
        } else {
            ret[n] = num
            n += 2
        }
    }
    return ret
}