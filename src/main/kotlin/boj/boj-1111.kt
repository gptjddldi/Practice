package boj

import java.io.*

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val cnt = br.readLine().toInt()
    val lis = br.readLine().split(" ").map { it.toInt() }
    println(sol(lis))
}

fun sol(lis: List<Int>): String{
    if(lis.size == 1) return "A"
    if(lis.toSet().size == 1) return lis[0].toString()
    if(lis.size == 2) return "A"
    if(lis[0] == lis[1]) return "B"
    if ((lis[1] - lis[2]) % (lis[0] - lis[1]) != 0) return "B"
    var a = (lis[1] - lis[2]) / (lis[0] - lis[1])
    var b = lis[1] - a * lis[0]
    for (i in 1 until lis.size){
        if(lis[i] != a * lis[i-1] + b) return "B"
    }
    return (lis.last() * a + b).toString()
}
