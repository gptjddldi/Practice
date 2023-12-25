package leetcode
fun numDecodings(s: String): Int {
    val n = s.length
    var p1 = 1
    var p2 = 0
    for(i in n-1 downTo 0) {
        var p = if (s[i] == '0') 0 else p1
        if(i < n-1 && (s[i] == '1' || (s[i] == '2' && s[i+1] < '7')))
            p += p2
        p2 = p1
        p1 = p
    }
    return p1
}


val mp = mutableMapOf<String, Int>()
fun numDecodings2(s: String): Int {
    return repeat(s,1)
}

fun repeat(s: String, cnt: Int): Int {
    if (s.length == 0) return cnt
    if (s[0] == '0') return 0
    if (s.length == 1) return cnt

    if (mp[s] == null) {
        mp[s] = if (s.length >= 2 && s.substring(0,2).toInt() < 27)
            repeat(s.substring(1), cnt) + repeat(s.substring(2), cnt)
        else
            repeat(s.substring(1), cnt)
    }
    return mp[s]!!
}