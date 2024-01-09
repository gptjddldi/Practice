package leetcode

fun leafSimilar(root1: TreeNode, root2: TreeNode): Boolean {
    val m1 = mutableListOf<Int>()
    val m2 = mutableListOf<Int>()
    recurse(root1, m1)
    recurse(root2, m2)
    return m1 == m2
}

fun recurse(cur: TreeNode, lis: MutableList<Int>) {
    if(cur.left != null) recurse(cur.left!!, lis)
    if(cur.right != null) recurse(cur.right!!, lis)

    if(cur.left == null && cur.right == null) lis += cur.`val`
}