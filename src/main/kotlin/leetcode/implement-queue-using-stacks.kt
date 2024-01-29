package leetcode

class MyQueue() {
    val s1 = mutableListOf<Int>()
    val s2 = mutableListOf<Int>()

    fun push(x: Int) {
        s1.add(x)
    }

    fun pop(): Int {
        if(s2.isEmpty()) {
            while(s1.isNotEmpty()) {
                s2.add(s1.removeLast())
            }
        }
        return s2.removeLast()
    }

    fun peek(): Int {
        if(s2.isEmpty()) {
            while(s1.isNotEmpty()) {
                s2.add(s1.removeLast())
            }
        }
        return s2.last()
    }

    fun empty(): Boolean {
        return s1.isEmpty() && s2.isEmpty()
    }
}

/**
 * Your MyQueue object will be instantiated and called as such:
 * var obj = MyQueue()
 * obj.push(x)
 * var param_2 = obj.pop()
 * var param_3 = obj.peek()
 * var param_4 = obj.empty()
 */