// 15663
import java.io.*


val ret = mutableListOf<String>()
fun main() {
    var br = BufferedReader(InputStreamReader(System.`in`))
    val cmd = br.readLine().split(" ").map { it.toInt() }
    val lis = mutableSetOf<Int>()
    var used = IntArray(10002)

    br.readLine().split(" ").map { it.toInt() }.forEach {
        lis.add(it)
        used[it] ++
    }

    bt(lis.sorted(), cmd[1], "", used, 0)

//    ret.forEach { println(it) }
}

fun bt(lis: List<Int>, size: Int, str: String, used: IntArray, cur: Int) {
    if (cur == size){
        println(str.replaceFirst(" ",""))
    } else {
        lis.forEach {
            if(used[it] != 0) {
                used[it] -= 1
                bt(lis, size, "$str $it", used, cur + 1)
                used[it] += 1
            }
        }
    }
}