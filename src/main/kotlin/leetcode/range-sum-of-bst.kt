package leetcode
class TreeNode(var `val`: Int) {
    var left: TreeNode? = null
    var right: TreeNode? = null
}
fun rangeSumBST(root: TreeNode?, low: Int, high: Int): Int {
    if(root == null) return 0

    return if(root!!.`val` < low) {
        rangeSumBST(root!!.right, low, high)
    } else if (root!!.`val` > high) {
        rangeSumBST(root!!.left, low, high)
    } else {
        root!!.`val` + rangeSumBST(root!!.left, low, high) +
                rangeSumBST(root!!.right, low, high)
    }
}


fun rangeSumBST2(root: TreeNode?, low: Int, high: Int): Int = root?.run {
    if(`val` > high) rangeSumBST2(left, low, high)
    else if(`val` < low) rangeSumBST2(right, low, high)
    else `val` + rangeSumBST2(left, low, high) + rangeSumBST2(right, low, high)
} ?: 0