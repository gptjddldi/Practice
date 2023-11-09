package boj// 7579
import java.io.StreamTokenizer
import kotlin.math.max

private val st = StreamTokenizer(System.`in`.bufferedReader())

private fun readInt(): Int = with(st) {
    nextToken()
    return nval.toInt()
}

// dp[i] : cost[i] 일때 최대 메모리
//
fun main() {
    val n = readInt()
    val m = readInt()
    val memories = IntArray(n)
    val costs = IntArray(n)
    val dp = IntArray(10100)
    var sz = 0
    var ret = 0
    repeat(n) {
        memories[it] = readInt()
    }
    repeat(n) {
        costs[it] = readInt()
        sz += costs[it]
    }
    repeat(n) {
        for (i in sz downTo costs[it]) {
            dp[i] = max(dp[i], dp[i - costs[it]] + memories[it])
        }
    }
    for (i in 0..sz)
        if (dp[i] >= m) {
            print(i)
            break
        }
}

// 100 10000000
// 100005 100006 100007 100008 100009 100010 100011 100012 100013 100014 100015 100016 100017 100018 100019 100020 100021 100022 100023 100024 100025 100026 100027 100028 100029 100030 100031 100032 100033 100034 100035 100036 100037 100038 100039 100040 100041 100042 100043 100044 100045 100046 100047 100048 100049 100050 100051 100052 100053 100054 100055 100056 100057 100058 100059 100060 100061 100062 100063 100064 100065 100066 100067 100068 100069 100070 100071 100072 100073 100074 100075 100076 100077 100078 100079 100080 100081 100082 100083 100084 100085 100086 100087 100088 100089 100090 100091 100092 100093 100094 100095 100096 100097 100098 100099 100100 100101 100102 100103 100104
// 81 148 106 11 34 84 148 7 96 105 24 57 121 47 3 87 44 197 192 96 6 96 110 7 12 160 26 137 55 95 152 48 170 80 184 92 101 171 67 148 64 36 6 92 125 139 102 48 62 151 80 79 52 18 68 26 112 195 69 104 11 8 189 166 97 163 97 47 195 90 177 4 107 111 28 68 98 100 172 7 41 198 26 169 127 176 118 57 110 123 178 118 26 190 136 45 193 146 184 129

//
// // 7579
// import java.io.StreamTokenizer
// import java.util.concurrent.ConcurrentSkipListMap
// import kotlin.math.min
//
// private val boj.st = StreamTokenizer(System.`in`.bufferedReader())
//
// private fun boj.readInt(): Int = with(boj.st) {
//    nextToken()
//    return nval.toInt()
// }
//
// fun boj.boj.boj.boj.boj.main() {
//    val n = boj.readInt()
//    val m = boj.readInt()
//    val memories = IntArray(n)
//    val costs = IntArray(n)
//    val boj.getMp = ConcurrentSkipListMap<Int, Int> ()
//    var boj.getRet = 10000005
//    repeat(n) {
//        memories[it] = boj.readInt()
//    }
//    repeat(n) {
//        costs[it] = boj.readInt()
//    }
//
//    repeat(n) {
//        val keys = boj.getMp.keys.toList()
//        if (memories[it] >= m) {
//            boj.getRet = min(costs[it], boj.getRet)
//        } else {
//            keys.forEach { k ->
//                if (k + memories[it] >= m) {
//                    boj.getRet = min(costs[it] + boj.getMp[k]!!, boj.getRet)
//                } else {
//                    boj.getMp[k + memories[it]] = min(boj.getMp[k]!! + costs[it], boj.getMp[k + memories[it]] ?: 10000005)
//                }
//            }
//        }
//        boj.getMp[memories[it]] = min(boj.getMp[memories[it]] ?: 10_000_005, costs[it])
//    }
//    println(boj.getRet)
// }
