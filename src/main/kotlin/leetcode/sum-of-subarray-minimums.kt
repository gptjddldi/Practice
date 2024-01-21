// i번째로 끝나는 경우
// [3,1,2,5,4]
// [3] => 3
// [3,1], [1] => 1+1
// [3,1,2], [1,2], [2] => 1+1+2
// [3,1,2,5], [1,2,5], [2,5], [5]  => 1+1+2+5
// [3,1,2,5,4], [1,2,5,4], [2,5,4], [5,4], [4]  => 1+1+2+4+4
// 1. arr[i] >= arr[i-1] then ret[i] = ret[i-1] + arr[i]
// 2. arr[i] < arr[i-1] then ret[i] = ret[j] + arr[i]*(i-j)
// 여기서 j 는 idx 가 i-1 이하면서 arr[i] 보다 큰것


fun sumSubarrayMins(arr: IntArray): Int {
    val sz = arr.size
    val ret = DoubleArray(sz) { 0.0 }
    val st = mutableListOf<Int>()
    for (i in 0 until sz) {
        while(st.isNotEmpty() && arr[st.last()] > arr[i]) st.removeLast()
        if(st.isNotEmpty()) {
            val j = st.last()
            ret[i] = ret[j] + arr[i] * (i-j)
        } else {
            ret[i] = arr[i] * (i + 1).toDouble()
        }

        st.add(i)
    }
    return (ret.sum() % 1_000_000_007).toInt()
}
