package leetcode

import java.util.*
import kotlin.math.min

// 70 * O(n) ㅋㅋ
fun dailyTemperatures(t: IntArray): IntArray {
    val ret = IntArray(t.size)
    val cnt = IntArray(101)
    for(i in t.size -1 downTo  0) {
        cnt[t[i]] = i
        for(j in t[i]+1 .. 100){
            if(cnt[j] > 0) {
                if(ret[i] == 0) ret[i] = cnt[j] - i
                else ret[i] = min(ret[i], cnt[j] - i)
            }
        }
    }
    return ret
}
// O(n)
fun dailyTemperaturesWithStack(t: IntArray): IntArray {
    val ret = IntArray(t.size)
    val st = Stack<Int>()
    for(i in t.size -1 downTo  0) {
        while(st.isNotEmpty() && t[i] >= t[st.peek()]) st.pop()
        if(st.isNotEmpty()) ret[i] = st.peek() - i
        st.push(i)
    }
    return ret
}