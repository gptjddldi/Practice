package boj

// 1406
fun main(){
    val br = java.io.BufferedReader(java.io.InputStreamReader(System.`in`))
    val ll = java.util.LinkedList<Char>()
    br.readLine().map { ll.add(it) }
    var iter = ll.listIterator(ll.size)
    val cnt = br.readLine().toInt()
    for (i in 0 until cnt){
        val cmd = br.readLine()
        when(cmd){
            "L" -> if (iter.hasPrevious()) iter.previous()
            "D" -> if (iter.hasNext()) iter.next()
            "B" -> if (iter.hasPrevious()) {
                iter.previous()
                iter.remove()
            }
            else -> {
                iter.add(cmd[2])
            }
        }
    }
    var sb = StringBuilder()
    for (i in ll){
        sb.append(i)
    }
    print(sb)
}