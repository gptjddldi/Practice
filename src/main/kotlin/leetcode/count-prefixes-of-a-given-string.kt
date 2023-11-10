class Solution {
    fun countPrefixes(words: Array<String>, s: String): Int {
        var ret = 0
        words.forEach {
            val sz = it.length
            if (s.length >= sz && it == s.substring(0,sz)) ret ++
        }
        return ret
    }
}
