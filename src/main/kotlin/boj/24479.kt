import java.io.StreamTokenizer

// 24479

private val st = StreamTokenizer(System.`in`.bufferedReader())

private fun readInt(): Int = with(st) {
    nextToken()
    return nval.toInt()
}
val vis = IntArray(100002) { 0 }

fun main() {
    val n = readInt()
    val m = readInt()
    val r = readInt()
    val vertices = Array(n+1) { ArrayList<Int>() }
    repeat(m) {
        val v1 = readInt()
        val v2 = readInt()
        vertices[v1].add(v2)
        vertices[v2].add(v1)
    }
    repeat(n) {
        vertices[it].sort()
    }
    dfs(vertices, r, 1)

    repeat(n) {
        println(vis[it + 1])
    }
}

fun dfs(V: Array<ArrayList<Int>>, R: Int, seq: Int): Int {
    var curSeq = seq
    vis[R] = curSeq++
    V[R].forEach {
        if (vis[it] == 0) {
            curSeq = dfs(V, it, curSeq++)
        }
    }
    return curSeq
}
