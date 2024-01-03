package leetcode

fun numberOfBeams(bank: Array<String>): Int {
    val cnt = mutableListOf<Int>()
    bank.forEach {
        val c = it.count {it == '1'}
        if (c > 0) cnt.add(c)
    }
    var ret = 0
    for(i in 0 until cnt.size-1) ret += cnt[i]*cnt[i+1]
    return ret
}


fun numberOfBeams2(bank: Array<String>): Int {
    return bank.map { row -> row.count { it == '1' } }
        .filterNot { it == 0 }
        .zipWithNext { curr, next -> curr * next }
        .sum()
}