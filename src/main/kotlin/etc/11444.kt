// 11444
// 도기뉴 항등식
// f(m+n) = f(m-1)f(n) + f(m)f(n-1)
import kotlin.math.*
import java.io.*
val mp = mutableMapOf<Long, Int>()
fun main () {
    var br = BufferedReader(InputStreamReader(System.`in`))
    val tar = br.readLine().toLong()
    mp[0L] = 0
    mp[1L] = 1
    mp[2L] = 1
    println(fibo(tar))
}

fun fibo(n: Long): Int{
    if(mp[n] != null) return mp[n]!!
    val k = n/2
    val fk = fibo(k) % 1_000_000_007
    val fk2 = fibo(k-1) % 1_000_000_007
    var fk3 = (fk + fk2) % 1_000_000_007 // fibo(k+1)
    if (n % 2L == 0L){
        mp[n] = (((fk2 * fk.toLong()) % 1_000_000_007L + (fk * fk3.toLong()) % 1_000_000_007L) % 1_000_000_007L).toInt()
    } else {
        mp[n] = (((fk * fk.toLong()) % 1_000_000_007L + (fk3 * fk3.toLong()) % 1_000_000_007L) % 1_000_000_007L).toInt()
    }
    return mp[n]!!
}

//1_000_000_000_000_000_000