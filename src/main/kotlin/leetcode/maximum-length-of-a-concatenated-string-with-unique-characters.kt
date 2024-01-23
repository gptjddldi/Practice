import kotlin.math.max

// bf 로 풀 수 있는 거 아님?
class Solution {
    private fun String.allUnique(): Boolean = all(hashSetOf<Char>()::add)
    var ret = 0
    fun maxLength(arr: List<String>): Int {
        tmp(0, arr, "")
        return ret
    }

    private fun tmp(idx: Int, arr: List<String>, str: String) {
        if(str.allUnique())
            ret = max(ret, str.length)
        if (idx == arr.size || !str.allUnique()){
            return
        }
        for (i in idx until arr.size)
            tmp(i+1, arr, str + arr[i])
    }
}