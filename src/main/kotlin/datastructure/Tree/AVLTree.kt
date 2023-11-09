package datastructure.Tree
import kotlin.math.*

// self-balancing tree
class AVLTree<T: Comparable<T>> {
    var root: AVLNode<T>? = null
    override fun toString(): String {
        return root?.toString() ?: "Empty tree"
    }
    fun insert(value: T){
        root = insert(root, value)
    }

    private fun insert(node: AVLNode<T>?, value: T): AVLNode<T>?{
        node?: return AVLNode(value)
        if (value <= node.value){
            node.leftChild = insert(node.leftChild, value)
        } else{
            node.rightChild = insert(node.rightChild, value)
        }

        val balancedNode = balanced(node)
        balancedNode?.height = max(
            balancedNode?.leftHeight?:0,
            balancedNode?.rightHeight?:0
        ) +1
        return balancedNode
    }

    fun delete(value: T){
        delete(root, value)
    }

    private fun delete(node: AVLNode<T>?, value: T): AVLNode<T>?{
        node ?: return null
        when{
            node.value == value -> {
                if(node.leftChild == null && node.rightChild == null) return null
                if(node.leftChild == null) return node.rightChild
                if(node.rightChild == null) return node.leftChild

                node.rightChild?.min?.value?.let { node.value = it }
                node.rightChild = delete(node.rightChild, node.value)
            }
            node.value < value -> {
                node.rightChild = delete(node.rightChild, value)
            }
            node.value > value -> {
                node.leftChild = delete(node.leftChild, value)
            }
        }

        val balancedNode = balanced(node)
        balancedNode?.height = max(
            balancedNode?.leftHeight?:0,
            balancedNode?.rightHeight?:0
        ) +1
        return balancedNode
    }

    private fun leftRotate(node: AVLNode<T>): AVLNode<T> {
        val pivot = node.rightChild!!
        node.rightChild = pivot.leftChild
        pivot.leftChild = node

        node.height = max(node.leftHeight, node.rightHeight) + 1
        pivot.height = max(pivot.leftHeight, pivot.rightHeight) + 1

        return pivot
    }

    private fun rightRotate(node: AVLNode<T>): AVLNode<T> {
        val pivot = node.leftChild!!
        node.leftChild = pivot.rightChild
        pivot.rightChild = node

        node.height = max(node.leftHeight, node.rightHeight) + 1
        pivot.height = max(pivot.leftHeight, pivot.rightHeight) + 1

        return pivot
    }

    private fun rightLeftRotate(node: AVLNode<T>): AVLNode<T> {
        val rightChild = node.rightChild ?: return node
        node.rightChild = rightRotate(rightChild)
        return leftRotate(node)
    }

    private fun leftRightRotate(node: AVLNode<T>): AVLNode<T> {
        val leftChild = node.leftChild ?: return node
        node.leftChild = leftRotate(leftChild)
        return rightRotate(node)
    }

    private fun balanced(node: AVLNode<T>): AVLNode<T> {
        return when(node.balanceFactor){
            2 -> {
                if(node.leftChild?.balanceFactor == -1) leftRightRotate(node)
                else rightRotate(node)
            }
            -2 -> {
                if(node.rightChild?.balanceFactor == 1) rightLeftRotate(node)
                else leftRotate(node)
            }
            else -> node
        }
    }
}

class AVLNode<T: Comparable<T>>(var value: T) {
    var leftChild: AVLNode<T>? = null
    var rightChild: AVLNode<T>? = null
    var height = 0
    val leftHeight: Int
        get() = leftChild?.height ?: -1
    val rightHeight: Int
        get() = rightChild?.height ?: -1
    val balanceFactor: Int
        get() = leftHeight - rightHeight

    val min: AVLNode<T>?
        get() = leftChild?.min ?: this

    override fun toString(): String {
        return diagram(this)
    }

    private fun diagram(
        node: AVLNode<T>?,
        top: String = "",
        root: String =  "",
        bottom: String =""
    ): String {
        return node?.let {
            if (node.leftChild == null && node.rightChild == null) return "$root${node.value}\n"
            else {
                diagram(node.rightChild, "$top ", "$top┌──", "$top| ") +
                        root + "${node.value}\n" +
                        diagram(node.leftChild, "$bottom│ ", "$bottom└──", "$bottom ")
            }
        } ?: "${root}null\n"
    }

}