package boj

// 13300
fun main(){
    val br = java.io.BufferedReader(java.io.InputStreamReader(System.`in`))
    var ret = 0
    val c0 = IntArray(6) { 0 }
    val c1 = IntArray(6) { 0 }
    val lis = br.readLine().split(" ").map { it.toInt() }
    for (i in (1..lis[0])){
        val l = br.readLine().split(" ").map { it.toInt() }
        if(l[0] == 1){
            c1[l[1] - 1]++
        } else{
            c0[l[1] - 1]++
        }
    }
    for (i in 0..5){
        ret += c0[i] / lis[1]
        ret += c1[i] / lis[1]

        if(c0[i].mod(lis[1]) > 0) ret++
        if(c1[i].mod(lis[1]) > 0) ret++
    }
    print(ret)
}