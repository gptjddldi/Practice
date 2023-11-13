package leetcode

fun sortVowels(s: String): String {
    val lis = mutableListOf<Char>()
    val arr = IntArray(10) { 0 }
    val vowels = arrayOf('A', 'E', 'I', 'O', 'U', 'a', 'e', 'i', 'o', 'u')
    s.forEach {
        if (vowels.contains(it)) lis.add(it)
    }
    lis.sort()
    var t = ""
    var j = 0
    for (i in s.indices) {
        if (vowels.contains(s[i])) {
            t += lis[j]
            j++
        } else {
            t += s[i]
        }
    }
    return t
}
