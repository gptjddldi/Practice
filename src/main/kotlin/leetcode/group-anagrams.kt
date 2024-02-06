package leetcode

fun groupAnagrams(strs: Array<String>): List<List<String>> {
    val mp = HashMap<String, MutableList<String>>()
    for(str in strs) {
        val s = str.toCharArray().sorted().joinToString("")
        mp[s] = mp.getOrDefault(s, mutableListOf())
        mp[s]!!.add(str)
    }
    return mp.values.toList()
}