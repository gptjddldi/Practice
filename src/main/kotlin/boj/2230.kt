package boj// 2230
// 정렬하고 찾으면 됨
import java.io.*
import kotlin.math.min

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    var ret =  2_000_000_000
    val cnt = br.readLine().split(" ").map { it.toInt() }
    val arr = IntArray(cnt[0])
    for (i in 0 until cnt[0])
        arr[i] = br.readLine().toInt()
    arr.sort()
    var st = 0
    var ed = 1
    while (st <= ed && ed < cnt[0]){
        while (ed < cnt[0] -1  && arr[ed] - arr[st] < cnt[1]) ed ++
        if (arr[ed] - arr[st] < cnt[1]) break
        ret = min(ret, arr[ed] - arr[st])
        st ++
    }
    print(ret)
}