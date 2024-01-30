package leetcode

import java.util.*

fun evalRPN(tokens: Array<String>): Int {
    val st = Stack<Int>()
    val operators = arrayOf<String>("+", "-", "*","/")
    for(t in tokens) {
        if(operators.contains(t)) {
            val op1 = st.pop()
            val op2 = st.pop()

            val ret  = when(t) {
                "+" -> op2 + op1
                "-" -> op2 - op1
                "*" -> op2 * op1
                "/" -> op2 / op1
                else -> 0
            }
            st.push(ret)

        } else {
            st.push(t.toInt())
        }
    }
    return st.pop()
}