import java.io.*

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val cnt = br.readLine().toInt()
    val lis = mutableListOf<Pair<Int,Int>>() // 걸리는 시간, 마감 시간
    for (i in 0 until cnt){
        var cmd = br.readLine().split(" ").map { it.toInt() }
        lis.add(Pair(cmd[0], cmd[1]))
    }
    lis.sortBy { it.second }
    var st = 0
    var ed = 0
    lis.forEach { (takes, before) ->
        if(st ==0 && ed == 0){
            st = before - takes
            ed = before
        } else {
            ed += takes
        }

        if (ed > before){
            st -= ed - before
            ed = before
        }
        if (st < 0){
            println(-1)
            return
        }
    }
    if (st >= 0) println(st)
}
//3
//3 5
//8 14
//12 25
