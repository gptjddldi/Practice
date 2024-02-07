package leetcode

fun frequencySort(s: String): String {
    val freq = s.groupingBy { it }.eachCount()
    return freq.toList().sortedByDescending { it.second }.joinToString("") { it.first.toString().repeat(it.second)}

}

fun frequencySort2(s: String): String {
    val freq = s.groupingBy { it }.eachCount()
    val hash = HashMap<Int, MutableList<String>>()
    for((k,v) in freq) {
        hash[v] = hash.getOrDefault(v, mutableListOf())
        hash[v]!!.add(k.toString())
    }
    val ret = StringBuilder()
    for(i in s.length downTo 0) {
        if(hash.contains(i)) {
            for(c in hash[i]!!) {
                ret.append(c.repeat(i))
            }
        }
    }
    return ret.toString()
}