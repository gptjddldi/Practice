package boj

fun main(){
    val br = java.io.BufferedReader(java.io.InputStreamReader(System.`in`))
    val num = br.readLine()
    val arr = Array(10) {0}
    for (ch in num){
        val i = ch.code - 48
        arr[ch.code - 48]++
    }
    arr[6] = (arr[6] + arr[9] + 1) / 2
    arr[9] = 0
    print(arr.max())
}