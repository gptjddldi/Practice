package leetcode

fun numBusesToDestination(routes: Array<IntArray>, source: Int, target: Int): Int {
    if (source == target) return 0
    var ret = 1
    val h = mutableMapOf<Int, MutableList<Int>>()
    val vis = mutableMapOf<Int, Boolean>()
    for (r in routes.indices) {
        for (i in routes[r]) {
            val route = h.getOrDefault(i, mutableListOf())
            route.add(r)
            h[i] = route
        }
    }
    val queue = mutableListOf<Int>()
    h[source]!!.forEach {
        queue.add(it)
        vis[it] = true
    }

    while (queue.isNotEmpty()) {
        val sz = queue.size
        for (i in 0 until sz) {
            val curRoute = queue.removeFirst()
            routes[curRoute].forEach {
                if (it == target) return ret

                for (nextRoute in h[it]!!) {
                    if (vis[nextRoute] != true) {
                        vis[nextRoute] = true
                        queue.add(nextRoute)
                    }
                }
            }
        }
        ret++
    }
    return -1
}
