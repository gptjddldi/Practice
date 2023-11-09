package datastructure.`Stack and Queue`

// Using ArrayList

//class TeQueueImpl<E>: TeQueue<E> {
//    private val lis = arrayListOf<E>()
//
//    override fun enqueue(element: E) {
//        lis.add(element)
//    }
//
//    override fun dequeue(): E? {
//        if (isEmpty) return null
//        return lis.removeAt(0)
//    }
//
//    override fun peek(): E? {
//        return lis.firstOrNull()
//    }
//
//    override val count: Int
//        get() = lis.size
//}

// Using LinkedList
//class TeQueueImpl<E>: TeQueue<E>{
//    private val lis = LinkedList<E>()
//    override fun enqueue(element: E) {
//        lis.addLast(element)
//    }
//
//    override fun dequeue(): E? {
//        return lis.removeFirstOrNull()
//    }
//
//    override fun peek(): E? {
//        return lis.firstOrNull()
//    }
//
//    override val count: Int
//        get() = lis.size
//}

// using ring buffer
//class TeQueueImpl<E>: TeQueue<E> {
//    private val rbf = RingBuffer<E>(4)
//    override fun enqueue(element: E) {
//        rbf.write(element)
//    }
//
//    override fun dequeue(): E? {
//        return rbf.read()
//    }
//
//    override fun peek(): E? {
//        return rbf.read()
//    }
//
//    override val count: Int
//        get() = rbf.count
//
//}

// using two stack
class StQueueImpl<E>: TeQueue<E> {
    private val leftStack = TeStackImpl<E>()
    private val rightStack = TeStackImpl<E>()

    private fun transferStack() {
        var cur = rightStack.pop()
        while (cur != null ){
            leftStack.push(cur)
            cur = rightStack.pop()
        }
    }
    override fun enqueue(element: E) {
        rightStack.push(element)
    }

    override fun dequeue(): E? {
        if(leftStack.isEmpty) transferStack()
        return leftStack.pop()
    }

    override fun peek(): E? {
        if(leftStack.isEmpty) transferStack()
        return leftStack.peek()
    }

    override val count: Int
        get() = leftStack.count + rightStack.count

}

fun main() {
    println("hello world")
    val q = StQueueImpl<Int>().apply {
        enqueue(2)
        enqueue(4)
//        println(peek())
        println(dequeue())
        println(dequeue())
        println(dequeue())
        println(count)
    }

}