package leetcode

fun largestDivisibleSubset(nums: IntArray): List<Int> {
    val lis = mutableListOf<List<Int>>()
    nums.sort()
    nums.forEach { lis.add(listOf(it)) }
    for(i in nums.indices) {
        for(j in 0 until i){
            if(nums[i] % nums[j] == 0 && lis[i].size < lis[j].size+1){
                lis[i] = lis[j] + nums[i]
            }
        }
    }

    return lis.maxBy { it.size }
}

fun helper(n1: Int, n2: Int): Boolean {
    return (n1 % n2 == 0) || (n2 % n1 == 0)
}
