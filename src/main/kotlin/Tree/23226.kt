// 23226
import java.io.*
import java.util.*

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val s = TreeSet<Int>()
    var cur: Int = 0
    val ret = mutableListOf<Int>()
    var cnt = br.readLine().split(" ").map { it.toInt() }

    br.readLine().split(" ").forEachIndexed { index, str -> if (str == "1") s.add(index) }

    for (i in 0 until cnt[1]){
        var cmd = br.readLine().split(" ").map { it.toInt() }
        when (cmd[0]){
            3 -> {
                if(s.isEmpty()) ret.add(-1)
                else{
                    val t = s.ceiling(cur)
                    if (t != null) ret.add(t - cur)
                    else ret.add(cnt[0] - cur + s.first())
                }
            }
            1 -> {
                val tar = cmd[1] - 1
                if (!s.remove(tar)) s.add(tar)
            }
            2 -> {
                cur += cmd[1]
                cur %= cnt[0]
            }
        }
    }
    ret.forEach { println(it) }
}
//5 7
//0 0 0 0 0
//3
//1 3
//3
//1 3
//3
//1 3
//3
