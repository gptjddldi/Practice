package `Stack and Queue`

interface TeQueue<E> {
    fun enqueue(element: E)
    fun dequeue(): E?
    fun peek(): E?
    val count: Int
    val isEmpty: Boolean
        get() = count == 0
}