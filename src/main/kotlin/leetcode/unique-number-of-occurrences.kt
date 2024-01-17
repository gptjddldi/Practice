package leetcode

fun uniqueOccurrences(arr: IntArray): Boolean {
    return arr.toList().groupingBy{ it }.eachCount().values.groupingBy { it }.eachCount().all {it.value == 1}
}