// 11328

fun main() {
    val br = java.io.BufferedReader(java.io.InputStreamReader(System.`in`))
    var ret: MutableList<String> = mutableListOf()
    val cnt = br.readLine().toInt()
    for (i in 0 until cnt) {
        var l1 = IntArray(26)
        var l2 = IntArray(26)
        val strs = br.readLine().split(" ")
        addChar(l1, strs[0])
        addChar(l2, strs[1])
        if(l1.contentEquals(l2)){
            ret.add("Possible")
        } else{
            ret.add("Impossible")
        }
    }
    ret.forEach { println(it) }
}

fun addChar(lis: IntArray, str: String) {
    for (ch in str){
        lis[ch.code - 'a'.code] ++
    }
}
