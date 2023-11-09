package boj

import java.io.StreamTokenizer
import kotlin.math.abs

private val st = StreamTokenizer(System.`in`.bufferedReader())

private fun readInt(): Int = with(st) {
    nextToken()
    return nval.toInt()
}

// 2467
fun main() {
    val cnt = readInt()
    val lis = mutableListOf<Int>()
    var ret: Int = 2000000001
    var r1 = 0
    var r2 = 0
    repeat(cnt) {
        lis.add(readInt())
    }
    var st = 0
    var ed = cnt - 1
    while (st < ed) {
        val s = lis[st] + lis[ed]
        if (abs(s) <= abs(ret)) {
            ret = abs(s)
            r1 = lis[st]
            r2 = lis[ed]
        }
        if (abs(lis[st]) > abs(lis[ed])) {
            st++
        } else {
            ed--
        }
    }

    print("$r1 $r2")
}
