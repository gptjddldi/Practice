package boj

import kotlin.math.abs

// 1919

fun main() {
    var br = java.io.BufferedReader(java.io.InputStreamReader(System.`in`))
    val a1 = IntArray(26)
    val a2 = IntArray(26)
    var ret = 0
    br.readLine().forEach { a1[it.code - 'a'.code]++ }
    br.readLine().forEach { a2[it.code - 'a'.code]++ }
    for (i in 0..25){
        ret += abs(a1[i] - a2[i])
    }
    print(ret)
}
//aabbcc
//xxyybb