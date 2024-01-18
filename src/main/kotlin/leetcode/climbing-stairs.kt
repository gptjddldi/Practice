package leetcode

fun climbStairs(n: Int): Int {
    if (n <= 2) return n
    var p1 = 2
    var p2 = 1

    for(i in 3 until n) {
        val tmp = p1
        p1 += p2
        p2 = tmp
    }
    return p1+p2
}