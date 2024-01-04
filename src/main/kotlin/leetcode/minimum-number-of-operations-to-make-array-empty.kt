package leetcode

fun minOperations(nums: IntArray): Int {
    val h = HashMap<Int,Int>()
    nums.forEach {
        h[it] = h.getOrDefault(it, 0) + 1
    }
    var ret = 0
    h.forEach { (k,v) ->
        if (v == 1) return -1
        else ret += calc(v)
    }
    return ret
}

fun calc(num: Int): Int{
    return if(num % 3 == 0) num / 3
    else num / 3 + 1
}