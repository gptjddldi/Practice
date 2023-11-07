import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.Collections

// 14891

var arr = arrayOf(List(8) { 0 }, List(8) { 0 }, List(8) { 0 }, List(8) { 0 })

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    arr[0] = br.readLine().map { it.digitToInt() }
    arr[1] = br.readLine().map { it.digitToInt() }
    arr[2] = br.readLine().map { it.digitToInt() }
    arr[3] = br.readLine().map { it.digitToInt() }

    val cnt = br.readLine().toInt()
    repeat(cnt) {
        val cmd = br.readLine().split(" ").map { it.toInt() }
        help(cmd[0] - 1, cmd[1], 0)
    }

    print(arr[0][0] + 2 * arr[1][0] + 4 * arr[2][0] + 8 * arr[3][0])
}

fun help(tar: Int, direct: Int, before: Int) {
    if (tar > 0 && arr[tar][6] != arr[tar - 1][2] && (before == 0 || before == -1)) {
        help(tar - 1, -direct, -1)
    }
    if (tar < 3 && arr[tar][2] != arr[tar + 1][6] && (before == 0 || before == 1)) {
        help(tar + 1, -direct, 1)
    }
    Collections.rotate(arr[tar], direct)
}
