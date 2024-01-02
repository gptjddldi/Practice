package leetcode

fun findMatrix(nums: IntArray): List<List<Int>> {
    val h = hashMapOf<Int, Int>()
    nums.forEach {
        h[it] = h.getOrDefault(it, 0) + 1
    }
    val m = h.maxOf { it.value }
    val ret = mutableListOf<MutableList<Int>>()
    repeat(m){
        ret.add(mutableListOf<Int>())
    }
    h.forEach { (k,v) ->
        for (i in 0 until v)
            ret[i].add(k)
    }
    return ret
}