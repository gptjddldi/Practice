package leetcode


fun findJudge(n: Int, trust: Array<IntArray>): Int {
    val t1 = IntArray(n+1) { 0 }
    val t2 = IntArray(n+1) { 0 }

    for(t in trust) {
        t1[t[0]] += 1
        t2[t[1]] += 1
    }

    for(i in 1..n) {
        if(t1[i] == 0 && t2[i] == n-1) return i
    }
    return -1
}
