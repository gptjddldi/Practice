// 1106
// dp[i] = j : i원으로 j 명 수용가능
// dp[
import java.io.*
import kotlin.math.*
fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val cnt = br.readLine().split(" ").map { it.toInt() }
    val al = IntArray(100002) { 0 }
    val lis = mutableListOf<Pair<Int,Int>>()
    repeat(cnt[1]){
        val cmd = br.readLine().split(" ").map { it.toInt() }
        lis.add(Pair(cmd[0], cmd[1]))
    }
    lis.forEach {(cost, person) ->
        for (i in 0 until 100002){
            if(i - cost >= 0)
                al[i] = max(al[i], al[i-cost] + person)
        }
    }
    for (i in 0 until 100002){
        if (al[i] >= cnt[0]) {
            print(i)
            break
        }
    }
}
