package leetcode

fun isPowerOfTwo(n: Int): Boolean {
    // byte 로 바꿔서 n-1 과 xor 했ㅇ르 때  10000 / 01111 => 11111 이 나와야 함 / 근대 & 연산하면? 어떨까?
    //
    return n > 0 && n.and(n-1) == 0
}