package leetcode

import java.util.*
// dp 아닐까 ?
// greedy 일까?
// 현재 위치에서 ladders 를 사용해야 할지 bricks 를 사용해야 할지 정확히 알 수 있음?
// 만약 index a 까지 간다고 치면, 여기까지의 subs 를 계산할 수 있지, 그리고 bricks 는 가장 작은
// 경우에 사용하고, 가장 큰 경우에 ladder 를 사용하는 거임
// 그렇게 했을 때 못가면 index a-1 을 살펴봄
// 그럼 각각의 sub 리스트가 있고, 여기서 가장큰 n 개를 ladders 로 항상 모두 사용했을 때, 남은 애들의 합과
// bricks 를 비교하면 될까? 그럼 되겠는데?
fun furthestBuilding(heights: IntArray, bricks: Int, ladders: Int): Int {
    val sz = heights.size
    val subs = PriorityQueue<Int>() {a,b -> b-a}
    val l = HashMap<Int,Int>()
    var s = 0L
    for(i in 0 until sz-1) {
        val diff = heights[i+1] - heights[i]
        if (diff > 0) {
            subs.add(diff)
            s += diff
        }
    }

    for(i in 0 until ladders) {
        if (subs.isEmpty()) {
            return sz-1
        }
        val sub = subs.poll()
        l[sub] = l.getOrDefault(sub,0) + 1
        s -= sub
    }

    for(j in sz-1 downTo 1) {
        if (s <= bricks) {
            return j
        }
        val diff = heights[j]- heights[j-1]
        if (diff <= 0) continue

        if(l[diff] ?: 0 > 0) {
            l[diff] = l[diff]!! - 1
            val sub = subs.poll()
            l[sub] = l.getOrDefault(sub,0) + 1
            s -= sub
        } else {
            subs.remove(diff)
            s -= diff
        }
    }
    return 0
}

fun furthestBuilding2(heights: IntArray, bricks: Int, ladders: Int): Int {
    val sz = heights.size
    val pq = PriorityQueue<Int>()
    var leftBricks = bricks
    for(i in 0 until sz - 1) {
        val diff = heights[i+1] - heights[i]
        if(diff < 0) continue
        pq.add(diff)
        if(pq.size > ladders) {
            val p = pq.poll()
            leftBricks -= p
            if(leftBricks < 0) return i
        }
    }
    return sz-1
}

fun furthestBuilding3(heights: IntArray, bricks: Int, ladders: Int): Int {
    val pq = PriorityQueue<Int>()
    var leftBricks = bricks
    heights.asSequence()
        .zipWithNext { a, b -> b - a }
        .forEachIndexed { i, diff ->
            if (diff <= 0) return@forEachIndexed
            pq.add(diff)
            if(pq.size > ladders) {
                leftBricks -= pq.poll()
                if(leftBricks < 0) return i
            }
        }
    return heights.size - 1
}