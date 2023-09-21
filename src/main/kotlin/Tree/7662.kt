// 7662
import java.io.*
import java.util.*

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val ret = mutableListOf<String>()
    for (i in 1..br.readLine().toInt()){
        val lis = TreeMap<Int, Int>()
        for (j in 1..br.readLine().toInt()){
            val cmd = br.readLine().split(" ")

            if (cmd[0] == "I") lis[cmd[1].toInt()] = (lis[cmd[1].toInt()]?:0) + 1
            else if (!lis.isEmpty()){
                val t = if(cmd[1] == "-1") lis.firstKey() else lis.lastKey()
                if(lis[t] == 1) lis.remove(t) else lis[t] = lis[t]!! - 1
            }

        }
        if (lis.isEmpty()) ret.add("EMPTY")
        else ret.add("${lis.lastKey()} ${lis.firstKey()}")
    }
    ret.forEach { println(it) }
}

//2
//7
//I 16
//I -5643
//D -1
//D 1
//D 1
//I 123
//D -1
//9
//I -45
//I 653
//D 1
//I -642
//I 45
//I 97
//D 1
//D -1
//I 333
//
//
//2
//7
//D 1
//D 1
//D -1
//D 1
//D 1
//I 123
//D -1
//9
//I -45
//I 653
//D 1
//I -642
//I 45
//I 97
//D 1
//D -1
//I 333

//1
//3
//I 40
//I 40
//D -1


//7
//I 16
//I -5643
//D -1
//D 1
//D 1
//I 123
//D -1
//9
//I -45
//I 653
//D 1
//I -642
//I 45
//I 97
//D 1
//D -1
//I 333