package leetcode

fun makeEqual(words: Array<String>): Boolean {
    val cnt = IntArray(26) { 0 }
    words.forEach {
        it.forEach { c -> cnt[c - 'a']++}
    }
    cnt.forEach {
        if(it % words.size != 0) return false
    }
    return true
}