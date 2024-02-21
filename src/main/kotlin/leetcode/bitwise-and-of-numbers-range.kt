package leetcode
fun rangeBitwiseAnd(left: Int, right: Int): Int {
    var i = 0
    var l = left
    var r = right
    while(l != r) {
        l = l.shr(1)
        r = r.shr(1)
        i ++
    }
    return r.shl(i)
}