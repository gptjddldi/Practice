import java.io.BufferedReader
import java.io.InputStreamReader

// 4375

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    var n = br.readLine()
    while (true) {
        var st = 0
        for (i in 1..n.toInt()) {
            st = st * 10 + 1
            st %= n.toInt()
            if (st == 0) {
                println(i)
                break
            }
        }
        n = br.readLine() ?: break
    }
}
