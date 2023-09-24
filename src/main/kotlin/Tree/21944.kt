// 21944

// 문제 번호, 난이도, 분류
// 기준은 난이도와 문제 번호
// 분류 =>
import java.io.*
import java.util.*

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val tm = TreeMap<Int, TreeSet<Int>>() // 난이도, 번호
    val tm2 = mutableMapOf<Int, TreeMap<Int,TreeSet<Int>>>() // 분류 (번호,난이도)
    val mp = mutableMapOf<Int, Pair<Int,Int>>() // 번호, (난이도, 분류)
    val ret = mutableListOf<Int>()
    for (i in 0 until br.readLine().toInt()){
        val cmd = br.readLine().split(" ").map { it.toInt() }
        ins(cmd[0], cmd[1], cmd[2], tm, tm2, mp)
    }

    for (i in 0 until br.readLine().toInt()){
        val cmd = br.readLine().split(" ")
        when (cmd[0]){
            "recommend" -> {
                if (cmd[2] == "1") ret.add(tm2[cmd[1].toInt()]!![tm2[cmd[1].toInt()]!!.lastKey()]!!.last())
                else ret.add(tm2[cmd[1].toInt()]!![tm2[cmd[1].toInt()]!!.firstKey()]!!.first())
            }
            "recommend2" -> {
                if (cmd[1] == "1") ret.add(tm[tm.lastKey()]!!.last())
                else ret.add(tm[tm.firstKey()]!!.first())
            }
            "recommend3" -> {
                if (cmd[1] == "1") {
                    val k = tm.ceilingKey(cmd[2].toInt())
                    if(k == null) ret.add(-1)
                    else ret.add(tm[k]!!.first())
                }
                else {
                    val k = tm.lowerKey(cmd[2].toInt())
                    if(k == null) ret.add(-1)
                    else ret.add(tm[k]!!.last())
                }
            }
            "add" -> {
                ins(cmd[1].toInt(), cmd[2].toInt(), cmd[3].toInt(), tm, tm2, mp)
            }
            "solved" -> {
                val N = cmd[1].toInt()
                val L = mp[N]!!.first
                val G = mp[N]!!.second
                mp.remove(N)
                tm[L]!!.remove(N)
                tm2[G]!![L]!!.remove(N)
                if (tm[L]!!.size == 0) tm.remove(L)
                if (tm2[G]!![L]!!.size == 0) tm2[G]!!.remove(L)
                if (tm2[G]!!.size == 0) tm2.remove(G)
            }
        }
    }
    ret.forEach { println(it) }
}

fun ins(N: Int, L: Int, G: Int, tm: TreeMap<Int, TreeSet<Int>>, tm2: MutableMap<Int, TreeMap<Int, TreeSet<Int>>>, mp: MutableMap<Int, Pair<Int,Int>>){
    mp[N] = Pair(L, G)

    tm[L] = tm[L]?:TreeSet<Int>()
    tm[L]!!.add(N)

    tm2[G] = tm2[G] ?: TreeMap<Int,TreeSet<Int>>()
    tm2[G]!![L] = tm2[G]!![L]?:TreeSet<Int>()
    tm2[G]!![L]!!.add(N)
}

