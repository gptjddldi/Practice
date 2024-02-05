package leetcode

fun firstUniqChar(s: String): Int {
    val h = HashMap<Char,Int>()
    for(i in s.indices) {
        val c = s[i]
        if(h.contains(c)) h[c] = 100002
        else h[c] = i
    }
    return if (h.minOf { it.value } == 100002) -1
    else h.minOf { it.value }
}
