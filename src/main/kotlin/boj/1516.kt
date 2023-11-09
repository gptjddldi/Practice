package boj

import java.io.StreamTokenizer
import kotlin.math.max

// 1516

private val st = StreamTokenizer(System.`in`.bufferedReader())

private fun readInt(): Int = with(st) {
    nextToken()
    return nval.toInt()
}
fun main() {
    val cnt = readInt()
    val ind = IntArray(cnt) { 0 }
    val lis = MutableList<MutableList<Int>>(cnt) { mutableListOf() }
    val values = IntArray(cnt) { 0 }
    repeat(cnt) {
        values[it] = readInt()
        var seq = readInt()
        while (seq != -1) {
            ind[it]++
            lis[seq - 1].add(it)
            seq = readInt()
        }
    }

    val queue = ArrayDeque<Int>()
    val ret = IntArray(cnt) { 0 }
    for (i in 0 until cnt)
        if (ind[i] == 0) {
            queue.add(i)
            ret[i] = values[i]
        }

    while (queue.isNotEmpty()) {
        val cur = queue.removeLast()
        for (i in 0 until lis[cur].size) {
            val next = lis[cur][i]
            ind[next]--
            ret[next] = max(ret[next], ret[cur] + values[next])

            if (ind[next] == 0) {
                queue.add(next)
            }
        }
    }
    ret.forEach { println(it) }
}
