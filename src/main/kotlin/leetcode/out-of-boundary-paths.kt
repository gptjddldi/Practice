// bfs
// edge 좌표에서 cnt 를 넣어줌
class Solution {
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
            var nr = curR + dx[d]
            var nc = curC + dy[d]
            if(nr < 0 || nc < 0 || nr >= m || nc >= n) mp[curR][curC]++
            else nq.add(nr to nc)
        }
        return ret
    }
}