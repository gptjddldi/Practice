/*
2437
backtracking ? 2^1000 인가요?
dp[i]: i 를 사용했을 때 최솟값
어떻게 하면 만들 수 없는 최솟값을 찾을 수 있을까요?
1. 만들 수 있는 모든 값들을 만들고, 1부터 찾기 => 2^n 아닌가?
2. 1부터 이 값을 만들 수 있는지 판별하기
흐므

dp[i] i 까지 봤을 때 만들 수 있는 값?!

1 1 2 3 6 7 30


1 3 5 7 9
인 경우에
1 만들 수 있음
2 만들 수 없음

1 2 3 5 7  9
인 경우에
1 만들 수 있음
2 만들 수 있음
3 만들 수 있음
4 만들 수 있음
5 만들 수 있음
6 만들 수 있음
7 ㅇ
8 ㅇ
9 ㅇ
10 ㅇ
9를 봤을 때는 1 ~ 8 을 만들 수 있다는 가정 하에 9 를 보게 됨
그럼 주어진 수로 9를 만들 수 있냐 없냐만 체크하면 됨, 그럼 주어진 수가 1 ~ 9 사이면 됨
흠..

1 2 4
이렇게 있음
1 가능
2 가능
3 가능
4 << 이게 어떤 구성요소로 쓰였는지 어떻게 체크함?
5 << 1 + 4 의 조합인 걸 어떻게 알 수 있음?

arr[i] : i 를 만드는데 필요한 것들 ( 리스트 )

1 2 3

1 가능 / arr[1] = [1]
2 가능 / arr[2] = [2]
3 가능 / arr[3] = [arr[2] + 1], [3]
4 가능 / arr[4] = arr[3] + [1], arr[2] + [2], arr[1] + 2, arr[0] + 4

4가 가능한지 체크한다는 것은 1,2,3 이 된다는 것이고 arr[1] arr[2] arr[3] 이 있다는 거고....


1 2 5
인 경우
1
2
3
4 <<<<< 안됨
1 1 2 5
1
2
3
4
5
6


그니까
정렬해서 sum 을 구하는데 sum + 1 < arr[i] 인 경우 sum + 1 을 만들 수 없음
*/

import java.io.StreamTokenizer

private val st = StreamTokenizer(System.`in`.bufferedReader())

private fun readInt(): Int = with(st) {
    nextToken()
    return nval.toInt()
}
fun main() {
    val n = readInt()
    val lis = mutableListOf<Int>()
    repeat(n) { lis.add(readInt()) }
    lis.sort()
    var s = 0
    var ret = 1
    for (i in 0 until lis.size) {
        if (lis[i] > s + 1) {
            break
        }
        s += lis[i]
        ret = s + 1
    }
    println(ret)
}
