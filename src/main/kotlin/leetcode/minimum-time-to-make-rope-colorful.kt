package leetcode

fun minCost(colors: String, neededTime: IntArray): Int {
    var bf = '1'
    var bfi = -1
    var ret = 0
    for( i in colors.indices) {
        if (colors[i] == bf) {
            if (neededTime[i] < neededTime[bfi]) {
                ret += neededTime[i]
            } else {
                ret += neededTime[bfi]
                bfi = i
            }
        } else {
            bf = colors[i]
            bfi = i
        }
    }
    return ret
}