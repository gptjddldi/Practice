// 14503
import java.io.StreamTokenizer

private var st = StreamTokenizer(System.`in`.bufferedReader())
private fun readInt(): Int = with(st) {
    nextToken()
    return nval.toInt()
}

private var cnt = 0

// 북, 동, 남, 서
private val dirR = arrayOf(-1, 0, 1, 0)
private val dirC = arrayOf(0, 1, 0, -1)
fun main() {
    val n = readInt()
    val m = readInt()
    val board = Array(n) { Array(m) { 0 } } // 0 청소 안됨, 1 벽
    val curR = readInt()
    val curC = readInt()
    val curD = readInt()
    repeat(n) { r ->
        repeat(m) { c ->
            board[r][c] = readInt()
        }
    }
    dfs(curR, curC, curD, board)
    print(cnt)
}

fun dfs(r: Int, c: Int, d: Int, board: Array<Array<Int>>) {
    var flag = false
    if (board[r][c] == 0) cnt += 1
    if (board[r][c] != 1) {
//        println("$r , $c, dir: $d")
        board[r][c] = 2

        var nd = d
        for (it in d..d + 3) {
            nd = (nd + 3) % 4
            var nr = r + dirR[nd]
            var nc = c + dirC[nd]
            if (nr >= 0 && nc >= 0 && nr < board.size && nc < board[0].size && board[nr][nc] == 0) {
                flag = true
                dfs(nr, nc, nd, board)
                break
            }
        }
        if (!flag) {
            var nr = r - dirR[d]
            var nc = c - dirC[d]
            if (nr >= 0 && nc >= 0 && nr < board.size && nc < board[0].size && board[nr][nc] != 1) {
                dfs(nr, nc, d, board)
            }
        }
    }
}

// 3 3
// 1 1 0
// 1 1 1
// 1 0 1
// 1 1 1
