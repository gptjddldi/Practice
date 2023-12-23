package leetcode
fun isPathCrossing(path: String): Boolean {
    var c1 = 0
    var c2 = 0
    val mp = mutableMapOf<Pair<Int,Int>, Boolean>()
    mp[c1 to c2] = true
    path.forEach {
        if (it == 'N') c1++
        else if (it == 'S') c1--
        else if (it == 'E') c2++
        else c2--

        if(mp[c1 to c2] != null) return true
        mp[c1 to c2] = true
    }
    return false
}
