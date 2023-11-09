package boj// 11725
import java.io.*
import java.util.Stack

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val n = br.readLine().toInt()
    val arr = Array(100002) { ArrayList<Int>() }
    val parents = IntArray(100002) { -1 }
    for (i in 0 until n - 1){
        var cmd = br.readLine().split(" ").map { it.toInt() }
        arr[cmd[0]].add(cmd[1])
        arr[cmd[1]].add(cmd[0])
    }
    val st = Stack<Int>()
    st.add(1)
    while (!st.empty()){
        var cur = st.pop()
        for (next in arr[cur]){
            if (parents[next] > 0) continue
            st.add(next)
            parents[next] = cur
        }
    }
    for (i in 2 until n+1) println(parents[i])
}