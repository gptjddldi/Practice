package `Stack and Queue`

class TeStackImpl<E> : TeStack<E>{
    private val lis = arrayListOf<E>()
    override fun pop(): E? {
        if (count == 0) return null
        return lis.removeAt(count - 1)
    }

    override fun push(element: E) {
        lis.add(element)
    }

    override fun peek(): E? {
        return lis.lastOrNull()
    }

    override val count: Int
        get() = lis.size

    companion object {
        fun <E> create(items: Iterable<E>): TeStack<E>{
            val stack = TeStackImpl<E>()
            for (item in items){
                stack.push(item)
            }
            return stack
        }
    }
}

fun main(){
    var lis = listOf(1,2,3,4,5)
    val st = TeStackImpl.create(lis)
    println(st.pop())
    println(st.pop())
    println(st.pop())
    println(st.pop())
    println(st.pop())
}