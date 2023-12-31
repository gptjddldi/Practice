package leetcode

fun restoreArray(adjacentPairs: Array<IntArray>): IntArray {
    val ret = IntArray(adjacentPairs.size + 1) { 0 }
    val mp = mutableMapOf<Int, MutableList<Int>>()
    adjacentPairs.forEach {
        val first = it[0]
        val second = it[1]
        if (mp[first] != null) {
            mp[first]!!.add(second)
        } else {
            mp[first] = mutableListOf(second)
        }

        if (mp[second] != null) {
            mp[second]!!.add(first)
        } else {
            mp[second] = mutableListOf(first)
        }
    }
    var cur = 0
    mp.forEach { (k, v) ->
        if (v.size == 1) cur = k
    }
    for (i in ret.indices) {
        ret[i] = cur
        if (i == ret.size - 1) break
        mp[cur]!!.remove(cur)
        val next = mp[cur]!!.first()
        mp[next]!!.remove(cur)
        cur = next
    }

    return ret
}
