package leetcode

import kotlin.math.min

fun minOperations(s: String): Int {
    var cnt = 0
    for(i in s.indices) {
        if ((s[i] - '0') != i % 2) cnt ++
    }
    return min(cnt, s.length - cnt)
}

fun minOperations2(s: String): Int {
    var b1 = '0'
    var b2 = '1'
    var c1 = 0
    var c2 = 0
    for(i in s.indices) {
        if (s[i] == b1){
            c1 ++
            b1 = ('1' - s[i]).digitToChar()
        } else b1 = s[i]

        if (s[i] == b2){
            c2 ++
            b2 = ('1' - s[i]).digitToChar()
        } else b2 = s[i]
    }
    return min(c1,c2)
}