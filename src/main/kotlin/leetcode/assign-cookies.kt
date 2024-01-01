package leetcode

fun findContentChildren(g: IntArray, s: IntArray): Int {
    g.sort()
    s.sort()

    var i = 0
    var j = 0
    var ret  =0
    while (j < s.size && i < g.size) {
        if(g[i] > s[j]) j++
        else {
            ret ++
            i++
        }
    }
    return ret
}