package etc
import java.io.BufferedReader
import java.io.InputStreamReader
import kotlin.math.max

// 16637
// etc.bt 가 아닌가?
// 괄호를 넣고 etc.calc 에서 스택
private var r = -99999999
fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val cnt = br.readLine().toInt()
    bt(br.readLine(), 0)
    println(r)
}

fun bt(s: String, idx: Int) {
    if (idx + 1 >= s.length) {
        r = max(calc(s), r)
    } else {
        if (idx % 2 == 0 && idx + 3 <= s.length) {
            bt("${s.substring(0,idx)}(${s.substring(idx, idx + 3)})${s.substring(idx + 3)}", idx + 6)
        }
        bt(s, idx + 2)
    }
}

fun calc(s: String): Int {
    var ret = 0
    var op = '+'
    var i = 0

    do {
        var it = s[i]
        when (it) {
            '+', '-', '*' -> {
                op = it
            }
            else -> {
                val n = if (it == '(') {
                    i += 4
                    calc(s.substring(i - 3, i))
                } else {
                    it.code - '0'.code
                }
                when (op) {
                    '+' -> ret += n
                    '-' -> ret -= n
                    '*' -> ret *= n
                }
            }
        }
    } while (++i < s.length)
    return ret
}
