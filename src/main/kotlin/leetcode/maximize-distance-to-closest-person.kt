import kotlin.math.max

class Solution {
    fun maxDistToClosest(seats: IntArray): Int {
        var ret = 0
        var i = 0
        var cnt = 0

        while(i < seats.size) {
            if(seats[i] == 0) {
                cnt++
            } else {
                if(seats[0] == 0 && ret == 0) ret = cnt
                else ret = max(ret, (cnt+1)/2 )
                cnt = 0
            }
            i++
        }
        ret = max(ret, cnt)

        return ret
    }
}
