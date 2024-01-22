import kotlin.math.abs

// i-1 번째를 음수로 바꿈
// 이미 음수라면  ret[0] = i
// 양수인 거 찾으면 ret[1] = i+1
fun findErrorNums(nums: IntArray): IntArray {
    val sz = nums.size
    val ret = IntArray(2)
    for(i in 0 until sz) {
        val num = abs(nums[i])
        if(nums[num-1] < 0) {
            ret[0] = num
        }
        else nums[num-1] *= -1
    }
    for(i in 0 until sz) {
        if(nums[i] > 0) ret[1] = i+1
    }
    return ret
}
