package leetcode

fun maxProductDifference(nums: IntArray): Int {
    var a1 = -2
    var a2 = -1
    var b1 = 10004
    var b2 = 10003
    nums.forEach {
        if(it > a1) {
            a2 = a1
            a1 = it
        } else if (it > a2) {
            a2 = it
        }

        if (it < b1) {
            b2 = b1
            b1 = it
        } else if (it < b2) {
            b2 = it
        }
    }
    return a1*a2 - b1*b2
}