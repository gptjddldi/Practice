package boj

import java.io.StreamTokenizer

// 2346

private val st = StreamTokenizer(System.`in`.bufferedReader())

private fun readInt(): Int = with(st) {
    nextToken()
    return nval.toInt()
}

fun main() {
    val ret = mutableListOf<Int>()
    val cnt = readInt()
    var st = N(0,0)
    var cur = st
    repeat(cnt){
        val n = N(readInt(), it+1, cur)
        cur.next = n
        cur = n
    }
    st = st.next!!
    cur.next = st
    st.prev = cur
    cur = st
    repeat (cnt){
        ret.add(cur.index)
        cur.prev!!.next = cur.next
        cur.next!!.prev = cur.prev
        cur = cur.move(cur.value)!!
    }
    print(ret.joinToString(" "))
}

//5
//3 2 1 -3 -1

data class N(val value: Int, val index: Int, var prev: N? = null, var next: N? = null) {
    fun move(cnt: Int): N?{
        if (next == null || prev == null) return null
        return if (cnt > 0) next!!.move(cnt-1)
        else if (cnt < 0) prev!!.move(cnt + 1)
        else this
    }
}