package leetcode

fun halvesAreAlike(s: String): Boolean {
    fun String.countV(): Int = count { it in "aeiouAEIOU" }
    return s.substring(0, s.length / 2).countV() ==
            s.substring(s.length/2).countV()
}