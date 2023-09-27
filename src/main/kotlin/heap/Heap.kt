package heap

import java.util.*
interface Collection<E> {
    val count: Int
        get
    val isEmpty: Boolean
        get() = count == 0
    fun append(e: E)
    fun pop(): E?
}

interface Heap<E>: Collection<E> {
    fun peek(): E?
}

abstract class AbstractHeap<E>(): Heap<E> {
    var elements: ArrayList<E> = ArrayList<E>()
    override val count
        get() = elements.size

    override fun peek(): E? {
        return elements.firstOrNull()
    }


    override fun append(e: E) {
        // 맨 뒤에서 시작, 부모와 비교하면서 계속 올라감
        elements.add(e)
        var curIdx = elements.lastIndex
        var parentIdx = parentIndex(curIdx)
        while (compare(e, elements[parentIdx]) > 0 && curIdx > 0){
            Collections.swap(elements, curIdx, parentIdx)
            curIdx = parentIdx
            parentIdx = parentIndex(curIdx)
        }
    }

    override fun pop(): E? { // root element 제거
        if(isEmpty) return null

        Collections.swap(elements, 0, elements.lastIndex)
        elements.removeLast()

        var curIdx = 0
        while(true) {
            var left = leftChildIndex(curIdx)
            var right = rightChildIndex(curIdx)
            var c = curIdx

            if (left < count && compare(elements[left], elements[c]) > 0) c = left
            if (right < count && compare(elements[right], elements[c]) > 0) c = right
            if (c == curIdx) return elements[c]
            Collections.swap(elements, c, curIdx)
            curIdx = c
        }
    }
    abstract fun compare(a: E, b: E): Int

    private fun leftChildIndex(index: Int): Int {
        return index * 2 + 1
    }
    private fun rightChildIndex(index: Int): Int {
        return index * 2 + 2
    }
    private fun parentIndex(index: Int): Int {
        return ( index -1 ) / 2
    }
}
