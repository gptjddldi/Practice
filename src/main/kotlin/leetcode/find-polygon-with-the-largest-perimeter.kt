package leetcode

fun largestPerimeter(nums: IntArray): Long {
    nums.sort()
    val sz = nums.size
    var ret = -1L
    var acc = 0L
    for(i in 0 until sz) {
        if(i < 2) {
            acc += nums[i]
            continue
        }
        if(acc > nums[i]){
            ret = maxOf(ret, acc + nums[i])
        }
        acc += nums[i]
    }
    return ret
}
