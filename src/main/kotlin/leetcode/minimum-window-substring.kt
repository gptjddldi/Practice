package leetcode
fun minWindow(s: String, t: String): String {
    var i = 0
    var j = 0
    var cnt = t.length
    var min_st = 100005
    var min_len = 100005
    val hash = HashMap<Char, Int>()
    for(word in t) hash[word] = hash.getOrDefault(word, 0) + 1
    while(i<=j && j<s.length) {
        if(hash.containsKey(s[j])) {
            if(hash[s[j]]!! > 0) cnt--
            hash[s[j]] = hash[s[j]]!! - 1
        }
        while(cnt == 0) {
            if(j-i+1 < min_len) {
                min_st = i
                min_len = j-i+1
            }
            if(hash.containsKey(s[i])) {
                hash[s[i]] = hash[s[i]]!! + 1
                if(hash[s[i]]!! > 0) cnt++
            }
            i++
        }
        j++
    }
    if (min_len == 100005) return ""
    return s.slice(min_st until min_st+min_len)
}