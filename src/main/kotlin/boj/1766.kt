package boj// 1766
import java.io.*
import java.util.TreeSet

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val cnt = br.readLine().split(" ").map { it.toInt() }
    val ret = mutableListOf<Int>()
    val before = mutableMapOf<Int, Int>() // before[i] : i 전에 풀어야 하는 문제
    val after= mutableMapOf<Int, MutableList<Int>>() // after[i] : i 이후에 풀 수 있는 문제
    repeat(cnt[1]){
        val cnt2 = br.readLine().split(" ").map { it.toInt() } // cnt2[0] 을 풀어야 cnt2[1] 을 풀 수 있다
//        if(before[cnt2[1]] == null) before[cnt2[1]] = mutableListOf()
//        before[cnt2[1]]!!.add(cnt2[0])
        before[cnt2[1]] = (before[cnt2[1]]?:0) + 1

        if(after[cnt2[0]] == null) after[cnt2[0]] = mutableListOf()
        after[cnt2[0]]!!.add(cnt2[1])

    }
    val sta = TreeSet<Int>()
    for (i in 1 .. cnt[0]){
        if(before[i] == null) sta.add(i)
    }
    while (!sta.isEmpty()){
        val top = sta.first()
        sta.remove(top)
        ret.add(top)
        after[top]?.forEach {
            before[it] = before[it]!! - 1
            if (before[it] == 0) sta.add(it)
        }
    }
    print(ret.joinToString(" "))
}



//// 1766
//
//import java.io.StreamTokenizer
//import java.util.*
//
//private val st = StreamTokenizer(System.`in`.bufferedReader())
//
//private fun readInt(): Int = with(st) {
//    nextToken()
//    return nval.toInt()
//}
//
//fun boj.boj.boj.boj.boj.main() {
//    val n = readInt()
//    val m = readInt()
//
//    val edges = Array(n+1) { ArrayList<Int>()}
//    val indegrees = IntArray(n+1)
//
//    repeat(m) {
//        val u = readInt()
//        val v = readInt()
//        edges[u] += v
//        indegrees[v]++
//    }
//
//    val pq = PriorityQueue<Int>()
//    for (u in 1..n){
//        if(indegrees[u] == 0) pq += u
//    }
//    val bw = System.out.bufferedWriter()
//    while (pq.isNotEmpty()){
//        val u = pq.poll()
//        bw.append("$u ")
//
//        for (v in edges[u]){
//            indegrees[v] --
//            if(indegrees[v] == 0) pq += v
//        }
//    }
//    bw.flush()
//    bw.close()
//}