package boj

import java.io.StreamTokenizer

private val st = StreamTokenizer(System.`in`.bufferedReader())

private fun readInt(): Int = with(st) {
    nextToken()
    return nval.toInt()
}

// 1966

fun main() {
    val cnt = readInt()
    repeat(cnt) {
        val sz = readInt()
        val tar = readInt()
        val arr = IntArray(10) { 0 }
        val q = mutableListOf<Pair<Int, Int>>()
        var ret = 1
        repeat(sz) { i ->
            val im = readInt()
            q.add(Pair(im, i))
            arr[im]++
        }
        while (true) {
            val cur = q.removeFirst()

            if (hasHigher(arr, cur.first)) {
                q.add(cur)
            } else if (cur.second == tar) {
                println(ret)
                break
            } else {
                arr[cur.first]--
                ret += 1
            }
        }
    }
}

fun hasHigher(arr: IntArray, k: Int): Boolean {
    if (k == 9) return false
    for (i in k + 1..9) {
        if (arr[i] > 0) return true
    }
    return false
}
