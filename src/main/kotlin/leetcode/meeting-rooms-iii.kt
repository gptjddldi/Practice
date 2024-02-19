package leetcode

import java.util.*

// 사용되지 않은 방 중에 룸넘버 낮은 방 이용
// 사용 가능한 방 없으면 계속 기다림
// newMeetings = [start, duration]
// room id: priority queue ( 빈방 리스트 )
// 사용중인 방과 그 방이 언제 비는지 저장해야 함
// 그럼 사실 pq 는 room_id 에 대해서만이 아니라 끝나는 시간과 room_id 에 대한 pq 여야 함
// 아니면 2개의 pq 임
// 하나는 빈방 리스트 (key: room_id) q1 / 다른 하나는 사용중인 룸 (key: end_time) q2
// 빈방이 없으면 q2 의 첫번째 그것만큼 시간 돌리고 그 시간보다 작은 애들 모두 pop 하는 방식으로
fun mostBooked(n: Int, meetings: Array<IntArray>): Int {
    val lis = IntArray(n)
    val q1 = TreeSet<Int>()
    val q2 = TreeMap<Long, TreeSet<Int>>()
    for(i in 0 until n) {
        q1.add(i)
    }
    meetings.sortBy { it[0] }
    var i = 0
    var t = 0L
    while(i < meetings.size) {
        val (start, end) = meetings[i]
        t = maxOf(t, start.toLong())

        while(q2.isNotEmpty() && q2.firstKey() <= t) {
            val (_, values) = q2.pollFirstEntry()
            values.forEach { q1.add(it) }
        }

        if(q1.isNotEmpty()) {
            val x = q1.pollFirst()!!
            lis[x]++
            q2[t+end-start] = q2.getOrDefault(t+end-start, TreeSet()).apply { add(x) }
            i++
        } else {
            t = maxOf(t, q2.firstKey())
        }
    }
    // lis.forEach {println(it)}
    return lis.indices.maxBy { lis[it] }
}
