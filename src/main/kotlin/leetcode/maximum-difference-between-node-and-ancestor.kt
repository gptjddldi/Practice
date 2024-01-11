package leetcode

import kotlin.math.max
import kotlin.math.min

fun maxAncestorDiff(root: TreeNode): Int =
    recurse(root, root.`val`, root.`val`)

fun recurse(cur: TreeNode, mini: Int, maxi: Int): Int {
    val mini2 = min(cur.`val`, mini)
    val maxi2 = max(cur.`val`, maxi)
    var diff = maxi2 - mini2

    cur.left?.let {
        diff = max(diff, recurse(it, mini2, maxi2))
    }
    cur.right?.let {
        diff = max(diff, recurse(it, mini2, maxi2))
    }
    return diff
}