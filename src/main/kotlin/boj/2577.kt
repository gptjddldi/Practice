package boj

// 2577
fun main() {
    val br = java.io.BufferedReader(java.io.InputStreamReader(System.`in`))
    var a  = br.readLine().toInt()
    var b  = br.readLine().toInt()
    var c  = br.readLine().toInt()
    var calc = a * b * c

    val arr = Array(10) { 0 }
    while(calc != 0){
        val mod = calc % 10
        arr[mod]++
        calc /= 10
    }
    arr.forEach { println("$it") }
}