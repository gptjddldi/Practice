package leetcode

fun findLeastNumOfUniqueInts(arr: IntArray, k: Int): Int {
    val freq = arr.groupBy { it }.mapValues { it.value.size }.toList().sortedBy { it.second }
    var acc = 0
    var t = k
    for((_, v) in freq) {
        if(t >= v) {
            t -= v
            acc++
        } else {
            break
        }
    }
    return freq.size - acc

}