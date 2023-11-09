package datastructure.Tree

import kotlin.collections.*

class TreeNode<T>(val value: T) {
    private val children: MutableList<TreeNode<T>> = mutableListOf()

    fun add(child: TreeNode<T>) {
        children.add(child)
    }

    fun forEachDepthFirst(visit: Visitor<T>) {
        visit(this)
        children.forEach{ it.forEachDepthFirst(visit) }
    }

    fun forEachLevelOrder(visit: Visitor<T>){
        visit(this)
        val queue = ArrayDeque<TreeNode<T>>()

        children.forEach{ queue.addFirst(it) }
        var node = queue.removeLastOrNull()
        while(node != null){
            visit(node)
            node.children.forEach { queue.addFirst(it) }
            node = queue.removeLastOrNull()
        }
    }

    fun printLevelOrder(visit: Visitor<T>){
        visit(this)
        println("")
        val queue = ArrayDeque<TreeNode<T>>()

        children.forEach{ queue.addFirst(it) }
        var node = queue.removeLastOrNull()
        while(node != null){
            val sz = queue.size
            for (i in 0..sz){
                visit(node!!)
                node.children.forEach { queue.addFirst(it) }
                node = queue.removeLastOrNull()
            }
            println("")
        }
    }

    fun search(value: T): TreeNode<T>?{
        var ret: TreeNode<T>? = null
        forEachDepthFirst {
            if(it.value == value) ret = it
        }
        return ret
    }
}

typealias Visitor<T> = (TreeNode<T>) -> Unit