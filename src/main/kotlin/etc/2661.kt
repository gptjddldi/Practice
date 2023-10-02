// 2661
import java.io.*

private val st = StreamTokenizer(System.`in`.bufferedReader())
private fun readInt(): Int = with(st) {
    nextToken()
    return nval.toInt()
}

private val m = mutableMapOf<String, Boolean>()

fun main() {
    val n = readInt()
    val ret = bt(n, "")
    println(ret)
}

fun bt(cnt: Int, str: String): String {
    if(str.length == cnt){
        return str
    } else {
        var v: String = ""
        arrayOf("1","2","3").forEach {
            if(test(str + it))
                v = bt(cnt, str+it)
            if(v != "") return v
        }
    }
    return ""
}

fun test(str: String): Boolean {
    if (m[str] != null) return m[str]!!
    val sz = str.length
    for (i in 1..sz/2){
        val s1= str.substring(sz-i, sz)
        val s2= str.substring(sz-2*i, sz - i)
        if (s1 == s2) {
            m[str] = false
            return false
        }
    }
    return true
}