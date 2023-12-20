package leetcode
fun buyChoco(prices: IntArray, money: Int): Int {
    var m1 = 102
    var m2 = 103
    prices.forEach {
        if (it < m1) {
            m2 = m1
            m1 = it
        } else if (it < m2) {
            m2 = it
        }
    }
    return if (m1 + m2 > money) money
    else money - (m1 + m2)
}
