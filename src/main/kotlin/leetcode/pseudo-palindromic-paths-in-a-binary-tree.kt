package leetcode

var cnt = 0

fun pseudoPalindromicPaths (root: TreeNode): Int {
    recurse(root, 0)
    return cnt
}

fun recurse(cur: TreeNode?, v: Int) {
    if (cur == null) return
    var vv = v.xor(1 shl cur.`val`)
    if (cur.left == null && cur.right == null){
        if(vv.and(vv-1) == 0) cnt ++
    } else {
        recurse(cur.left, vv)
        recurse(cur.right, vv)
    }
}


fun pseudoPalindromicPaths2 (root: TreeNode): Int {

    fun dfs(cur: TreeNode?, v:Int):Int = cur?.run {
        var vv = v.xor(1 shl cur.`val`)
        if (cur.left == null && cur.right == null){
            if(vv.and(vv-1) == 0) 1 else 0
        } else {
            dfs(cur.left, vv) + dfs(cur.right, vv)
        }
    } ?: 0
    return dfs(root, 0)
}