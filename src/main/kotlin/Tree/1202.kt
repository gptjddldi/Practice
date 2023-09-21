// 1202
//
// 가벼운 가방에 넣을 수 있는 가장 무거운 것 부터 넣어 봄
// 가벼운 가방에 넣을 수 있는 가장 무거운 물건 포함해서 leftChild 를 보면서 iterate
// 아닌데 ?

// 가벼운 가방부터 시작하는 건 맞음
// 보석 30만개 있는데 ?
// 보석 최대 30만 가방도 최대 30만 ㅋㅋ;
// 적어도 nlog(n) 으로 구해야 함

// 이진 탑색 트리로 구할 수 있는 거?
// 항상 현재 무게 K 이하의 보석들 중 가장 큰 가격을 가진 보석을 선택해야 함.

// 또다른 명제, 가장 가치가 큰 보석부터 시작해서 그 보석을 담을 수 있는 가장 작은 가방을 선택함


// 이런 거임
// 무게 K 이하 중 가장 큰 value 를 리턴하는 자료구조를 찾는 거 ㅋㅋ
// 그래서 dp[k] 를 선택하면 그 value 는 사라지고 dp[k] 는 또 다른 가장 큰 value 를 갖게 되는 거지
// 그래서 우리는 걍 30만 개의 가방에 넣기만 하면 되는 거
// 흠;;

import java.io.*
import java.util.TreeMap
fun main() {
    var ret: Long = 0
    val br = BufferedReader(InputStreamReader(System.`in`))
    val cnt = br.readLine().split(" ").map { it.toInt() }
    var test = mutableListOf<Pair<Int,Int>>()
    val bags = TreeMap<Int, Int>()
    for (i in 0 until cnt[0]){
        val cmd = br.readLine().split(" ").map { it.toInt() }
        val weight = cmd[0]
        val value = cmd[1]
        test.add(Pair<Int,Int>(value, weight))
    }
    test.sortWith(compareBy({ -it.first }, { it.second }))
    for (i in 0 until cnt[1]){
        val cmd = br.readLine().toInt()
        bags[cmd] = (bags[cmd] ?: 0) + 1
    }
    var i = 0
    while (i < cnt[0]){
        val f = test[i]
        val k = bags.ceilingKey(f.second)
        if(k != null){
            ret += f.first
            if (bags[k] == 1) bags.remove(k)
            else bags[k] = bags[k]!! - 1
        }
        i++

    }
    print(ret)
}

// 1. weight,value 쌍 에 대한 카운트 필요함
// 2. value 에 대한 weight 를 저장할 수 있어야 함. 같은 value 에 weight 가 다를 수 있음
//      => weight 를 리스트로 저장할 때 정렬해서 저장해야 함, 이렇게 할 경우 조건 1번은 충족됨
// 3. value 를 기준으로 정렬된 자료구조여야 함
// TreeMap(value, TreeMap(weight, cnt)) << 이런 구조임ㅋ
//2 1
//5 10
//100 100
//11



