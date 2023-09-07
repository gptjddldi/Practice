import java.io.BufferedReader
import java.io.InputStreamReader

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))

    val str = br.readLine()
    val arr = Array(26) { 0 }
    for (c in str){
        arr[c - 'a'] ++
    }
    arr.forEach { print("$it ")}
}