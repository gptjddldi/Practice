package leetcode

fun closeStrings(word1: String, word2: String): Boolean {
    val l1 = IntArray(26) { 0 }
    val l2 = IntArray(26) { 0 }
    word1.forEach { l1[it.code-'a'.code]++ }
    word2.forEach { l2[it.code-'a'.code]++ }
    return l1.indices.filter { l1[it] != 0 } == l1.indices.filter { l2[it] != 0 } && l1.sorted() == l2.sorted()
}

fun closeStrings2(word1: String, word2: String): Boolean {
    val m1 = word1.groupingBy { it }.eachCount()
    val m2 = word2.groupingBy { it }.eachCount()

    return m1.values.sorted() == m2.values.sorted() && m1.keys == m2.keys
}