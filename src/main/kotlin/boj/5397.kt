package boj// 5397
import java.io.*
import java.util.LinkedList

fun main(){
    val br = BufferedReader(InputStreamReader(System.`in`))
    for (i in 0 until br.readLine().toInt()){
        val ll = LinkedList<Char>()
        val iter = ll.listIterator()
        br.readLine().forEach {
            when(it){
                '<' -> if(iter.hasPrevious()) iter.previous()
                '>' -> if(iter.hasNext()) iter.next()
                '-' -> if(iter.hasPrevious()){
                    iter.previous()
                    iter.remove()
                }
                else -> {
                    iter.add(it)
                }
            }
        }
        println(ll.toCharArray())
    }
}