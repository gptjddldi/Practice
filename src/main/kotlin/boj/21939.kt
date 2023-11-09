package boj// 21939

// binary search tree
// 2가지 기준: 난이도, 번호
// 같은 난이도, 같은 번호가 들어오는 경우는 없음
//
import java.io.*
import java.util.*
fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val ret = mutableListOf<Int>()
    val t = TreeMap<Int, TreeSet<Int>>()
    val m = mutableMapOf<Int,Int>() // 번호, 난이도
    for (i in 0 until br.readLine().toInt()){
        var c = br.readLine().split(" ").map { it.toInt() }
        if(t[c[1]] == null) t[c[1]] = TreeSet<Int>()
        t[c[1]]!!.add(c[0])
        m[c[0]] = c[1]
    }

    for (i in 0 until br.readLine().toInt()){
        var cmd = br.readLine().split(" ")
        when (cmd[0]){
            "add" -> {
                if(t[cmd[2].toInt()] == null) t[cmd[2].toInt()] = TreeSet<Int>()
                t[cmd[2].toInt()]!!.add(cmd[1].toInt())
                m[cmd[1].toInt()] = cmd[2].toInt()
            }
            "recommend" -> {
                if (cmd[1] == "-1"){
                    val f = t.firstKey()
                    ret.add(t[f]!!.first())
                } else {
                    val f = t.lastKey()
                    ret.add(t[f]!!.last())
                }
            }
            "solved" -> {
                val k = m[cmd[1].toInt()]
                t[k]!!.remove(cmd[1].toInt())
                if(t[k]!!.size == 0) t.remove(k)
            }
        }
    }

    ret.forEach { println(it) }
}