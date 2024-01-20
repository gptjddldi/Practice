package leetcode

import kotlin.math.pow

// constraint: n^2 보다 빨라야 함

// arr[i] 가 가장 작은 값인 경우를 몇개인지 세야 하나?
// 일단 arr[i] 가 포함된 subArray 가 몇개인지 셀 수 있음
// arr[i] 가 주변 어떤 범위 내에서 최솟값인지 알아야 함
// O(N) 으로 할 수 있나?
// [11,81,94,43,3] 에서 11은 0 ~ 3 범위에서 최솟값임
// 81은 1 ~ 2 범위에서 최소
// 94는 2 ~ 2
// 43은 1 ~ 3
//  3은 0 ~ 4
// 그래서 결과는 11 * 4 + 81 * 2 + 94 + 43 * 3 + 3 * 5
// 근데 어느 범위에서 최솟값인지 구하는 과정 << 이게 nlog(n) 일듯

// 그럼 다시 [11,81,3,94,43] 인 경우는 또 다를 것임
// 11: 0~1 => 2개
// 81: 1~1 => 1개
//  3: 0~4 => 9개 << 이걸 어떻게 세지
// 94: 3~3 => 1개
// 43: 3~4 => 2개

// i ~ j 에서 idx: k 를 포함하는 subarray 의 개수 (i <= k =< j)


// dp[i] : j~k 사이에서 최솟값을 갖는 arr[i]
fun sumSubarrayMin(arr: IntArray): Int {
    val sz = arr.size
    val ret = IntArray(sz) { 0 }
    val st = mutableListOf<Int>(0)
    for (i in 0 until sz) {
        while(ret[st.last()] > arr[i]) st.removeFirst()
        val j = st.last()
        ret[i] = ret[j] + arr[i] * (i-j)
        st.add(i)
    }
    return ret.sum() % (10.0.pow(9) + 7.0).toInt()
}

fun main() {
    val i = intArrayOf(3,1,2,4)
    println(sumSubarrayMin(i))
}