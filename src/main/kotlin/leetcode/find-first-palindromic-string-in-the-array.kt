package leetcode

fun firstPalindrome(words: Array<String>): String {
    for(word in words) {
        if(isPalindromic(word)){
            return word
        }
    }
    return ""
}

private fun isPalindromic(s: String): Boolean {
    val sz = s.length
    for(i in 0 until sz / 2) {
        if(s[i] != s[sz-i-1])
            return false
    }
    return true
}