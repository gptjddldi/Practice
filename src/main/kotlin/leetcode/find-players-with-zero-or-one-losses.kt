package leetcode

fun findWinners(matches: Array<IntArray>): List<List<Int>> {
    val winner = matches.map { it[0] }.sorted()
    val looser = matches.map { it[1] }.sorted()
    return listOf((winner.toSet() - looser.toSet()).toList(), looser.groupingBy { it }.eachCount().filter { (k,v) -> v == 1 }.keys.sorted().toList())
}

fun findWinners2(matches: Array<IntArray>): List<List<Int>> {
    val mp= hashMapOf<Int,Int>()
    val mp2= hashMapOf<Int,Int>()
    matches.forEach { mp[it[1]] = mp.getOrDefault(it[1], 0) + 1 }
    matches.forEach { mp2[it[0]] = mp.getOrDefault(it[0], 0) + 1 }

    return listOf(mp2.keys.sorted() - mp.keys.sorted().toSet(), mp.keys.filter{mp[it] == 1}.sorted())
}

