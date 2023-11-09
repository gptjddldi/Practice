package boj// 17299
// 오등큰수
// 마지막부터 시작해서 스택에 저장
import java.io.*
import java.util.Stack

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val cnt = br.readLine().toInt()
    val lis = br.readLine().split(" ").map { it.toInt() }
    val ret = IntArray(cnt)
    val sta = Stack<Int>()
    val mp = mutableMapOf<Int,Int>()

    lis.forEach { mp[it] = (mp[it]?:0) + 1 }
    for (i in cnt-1 downTo  0){
        val it = lis[i]
        while (!sta.empty()){
            val cnt = mp[sta.peek()]!!
            if (cnt > mp[it]!!) break
            sta.pop()
        }
        if(!sta.empty()) ret[i]= sta.peek()
        else ret[i] = -1
        sta.push(it)
    }
    print(ret.joinToString(" "))
}