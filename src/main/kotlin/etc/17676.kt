import java.io.StreamTokenizer
import kotlin.math.min

// 17676

private var st = StreamTokenizer(System.`in`.bufferedReader())

private fun readInt(): Int = with(st) {
    nextToken()
    return nval.toInt()
}

fun main() {
    val tar = readInt()

    val dp = IntArray(50001) { 5 }
    var num = 1
    while (num * num <= 50000) {
        dp[num * num] = 1
        num += 1
    }
    for (i in 1..50000) {
        var j = 1
        while (j < 256 && i + j * j <= 50000) {
            dp[i + j * j] = min(dp[i] + 1, dp[i + j * j])
            j += 1
        }
    }
    println(dp[tar])
}

//import java.io.StreamTokenizer
//import kotlin.math.min
//
//// 17676
//
//private var st = StreamTokenizer(System.`in`.bufferedReader())
//
//private fun readInt(): Int = with(st) {
//    nextToken()
//    return nval.toInt()
//}
//
//fun main() {
//    val tar = readInt()
//    var r = 4
//    for (i in 0..223) {
//        for (j in 0..223) {
//            for (k in 0..223) {
//                if (i * i + j * j + k * k == tar) {
//                    var cnt = 0
//                    if (i > 0) cnt++
//                    if (j > 0) cnt++
//                    if (k > 0) cnt++
//                    r = min(r, cnt)
//                }
//            }
//        }
//    }
//    print(r)
//}
