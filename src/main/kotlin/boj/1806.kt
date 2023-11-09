package boj// 1806
import java.io.*
import kotlin.math.min

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val tar = br.readLine().split(" ")[1].toInt()
    val arr = br.readLine().split(" ").map { it.toInt() }
    var ret = 100002
    var st = 0
    var ed = 0
    var s = arr[0]
    while (st < arr.size){
        while (st <= ed && ed < arr.size - 1 && s < tar) s += arr[++ed]
        if(s >= tar) {
            ret = min(ret, ed - st + 1)
        }
        s -= arr[st++]
    }
    if (ret != 100002) print(ret)
    else print(0)
}