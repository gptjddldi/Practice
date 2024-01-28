fun numSubmatrixSumTarget(matrix: Array<IntArray>, target: Int): Int {
    var ret = 0
    val Row = matrix.size
    val Col = matrix[0].size
    for(i in 0 until Row) {
        for(j in 1 until Col) {
            matrix[i][j] += matrix[i][j-1]
        }
    }
    for(i1 in 0 until Col) {
        for(i2 in i1 until Col) {
            var s = 0
            val mp = HashMap<Int,Int>()
            mp[0] = 1
            for(j1 in 0 until Row) {
                s += matrix[j1][i2] - (if(i1 > 0) matrix[j1][i1-1] else 0)
                ret += mp.getOrDefault(s - target, 0)
                mp[s] = mp.getOrDefault(s, 0) + 1
            }
        }
    }
    return ret
}
