package boj

// 13300
fun main(){
    val br = java.io.BufferedReader(java.io.InputStreamReader(System.`in`))
    br.readLine()
    val lis = br.readLine().split(" ")
    val target = br.readLine()
    var ret = 0
    for (c in lis){ if (c == target) ret++}
    print(ret)
}