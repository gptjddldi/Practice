
class LinkedList<K>: Iterable<K>, Collection<K> {
    private var head: Node<K>? = null
    private var tail: Node<K>? = null
    override var size = 0
    override fun isEmpty(): Boolean {
        return size == 0
    }

    override fun containsAll(elements: Collection<K>): Boolean {
        for (element in elements){
            if (!contains(element)) return false
        }
        return true
    }

    override fun contains(element: K): Boolean {
        for (value in this){
            if (value == element) return true
        }
        return false
    }

    override fun iterator(): Iterator<K> {
        return LinkedListIterator<K>(this)
    }

    override fun toString(): String {
        return head.toString()
    }
    fun push(value: K): Node<K>? {
        head = insertBefore(value, head)

        if(tail == null) tail = head
        return head
    }
    fun append(value: K): Node<K>? {
        if(isEmpty()) return push(value)

        tail = insertAfter(value, tail)
        return tail
    }
    private fun insertAfter(value: K, node: Node<K>?): Node<K> {
        val newNode = Node<K>(value, prev=node, next=node?.next)
        node?.next = newNode
        size++
        return newNode
    }

    private fun insertBefore(value: K, node: Node<K>?): Node<K> {
        val newNode = Node<K>(value, prev=node?.prev, next=node)
        node?.prev = newNode
        size++
        return newNode
    }
    fun pop() {
        head?.let { removeAt(it) }
        head = head?.next
    }
    fun removeLast() {
        tail = tail?.let { removeAt(it) }
        tail = tail?.prev
    }
    fun removeAt(node: Node<K>): Node<K> {
        if(node.prev != null) node.prev!!.next = node.next
        if(node.next != null) node.next!!.prev = node.prev

        size--

        return node
    }

    fun nodeAt(value: K): Node<K>? {
        var cur = head
        while (cur != null){
            if (cur.value == value) { return cur }
            cur = cur.next
        }
        return null
    }
    fun getHead(): Node<K>? {
        return head
    }
}


data class Node<K>(var value: K, var next: Node<K>? = null, var prev: Node<K>? = null) {
    override fun toString(): String {
        return if (next != null){
            "$value <-> ${next.toString()}"
        } else{
            "$value"
        }
    }
}

class LinkedListIterator<K>(private val list: LinkedList<K>): Iterator<K> {
    private var idx = 0
    private var curNode: Node<K>? = null
    override fun hasNext(): Boolean {
        return idx < list.size
    }

    override fun next(): K {
        if (!hasNext()) throw ArrayIndexOutOfBoundsException()
        curNode = if (idx == 0) list.getHead()
        else curNode?.next
        idx ++
        return curNode!!.value
    }
}