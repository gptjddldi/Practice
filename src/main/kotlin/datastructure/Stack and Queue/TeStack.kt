package datastructure.`Stack and Queue`

interface TeStack<E> {
    fun push(element: E)
    fun pop(): E?
    fun peek(): E?
    val count: Int
    val isEmpty: Boolean
        get() = count == 0
}
