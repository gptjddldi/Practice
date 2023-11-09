package boj// 1158
import java.io.*

fun main(){
    val br = BufferedReader(InputStreamReader(System.`in`))
    val cmd = br.readLine().split(" ").map { it.toInt() }
    val q = ArrayDeque<Int>()
    q.addAll(1..cmd[0])
    var i = 1
    var idx = 0
    var ret = mutableListOf<Int>()
    while(!q.isEmpty()){
        if (i == cmd[1]) {
            ret.add(q[idx])
            q.removeAt(idx)
            i = 1
            if(q.size == idx) idx = 0
        } else{
            i++
            if (q.size <= idx + 1) idx = 0
            else idx++
        }

    }
    print("<${ret.joinToString(", ")}>")
}


//// 1158
//import java.io.*
//
//fun boj.boj.boj.boj.boj.main(){
//    val br = BufferedReader(InputStreamReader(System.`in`))
//    val boj.getRet:MutableList<Int> = mutableListOf()
//    val cmd = br.readLine().split(" ").map { it.toInt() }
//    var head = Node(0)
//    var cur: Node? = null
//    for (i in 1..cmd[0]){
//        val tmpNode = Node(i)
//        if(i==1) head = tmpNode
//        else cur?.next = tmpNode
//        cur = tmpNode
//    }
//    cur?.next = head
//    var tmp = Node(0, head)
//    for (i  in 1 .. cmd[0]){
//        var bef = Node(0)
//        for (j in 0 until cmd[1]){
//            bef = tmp
//            tmp = tmp.next!!
//        }
//        boj.getRet.add(tmp!!.value)
//        bef.next = tmp.next
//    }
//    print("<${boj.getRet.joinToString(", ")}>")
//}
//
//data class Node(val value: Int, var next: Node? = null)