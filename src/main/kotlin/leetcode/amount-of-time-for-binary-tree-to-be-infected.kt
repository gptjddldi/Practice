package leetcode

import kotlin.math.max
var ret = 0
fun amountOfTime(root: TreeNode?, start: Int): Int {
    traverse(root, start)
    return ret
}

fun traverse(cur: TreeNode?, start: Int): Pair <Boolean, Int>{
    if(cur == null) return false to 0

    val p1 = traverse(cur.left, start)
    val p2 = traverse(cur.right, start)

    if (cur.`val` == start) {
        ret = max(ret, max(p1.second, p2.second))
        return true to 0
    }

    if (p1.first) {
        ret = max(ret, p1.second + p2.second + 1)
        return true to p1.second + 1
    } else if (p2.first){
        ret = max(ret, p1.second + p2.second + 1)
        return true to p2.second + 1
    }

    return false to 1 + max(p1.second, p2.second)
}