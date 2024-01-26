// bfs
// edge 좌표에서 cnt 를 넣어줌
val mp = HashMap<Triple<Int,Int,Int>, Int>()
val mod = 1000000007
val dx = arrayOf(0,1,0,-1)
val dy = arrayOf(1,0,-1,0)
fun findPaths(m: Int, n: Int, maxMove: Int, startRow: Int, startColumn: Int): Int {
    val key = Triple(startRow, startColumn, maxMove)
    if(mp[key] != null) return mp.getOrDefault(key, 0)
    if(maxMove == 0) return 0
    var ret = 0
    for(d in 0 .. 3) {
        var nr = startRow + dx[d]
        var nc = startColumn + dy[d]
        if(nr < 0 || nc < 0 || nr >= m || nc >= n) ret ++
        else {
            ret += findPaths(m, n, maxMove - 1, nr, nc)
            ret %= mod
        }
    }
    mp[key] = ret
    return ret
}
