package datastructure.Tree;
import kotlin.math.max

typealias Visitor2<T> = (BinaryTreeNode<T>?) -> Unit
class BinaryTreeNode<T> (var value: T) {
    var leftChild: BinaryTreeNode<T>? = null
    var rightChild: BinaryTreeNode<T>? = null

    override fun toString(): String {
        return diagram(this)
    }
    private fun diagram(
        node: BinaryTreeNode<T>?,
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

    fun inOrder(visit: Visitor2<T>) {
        leftChild?.inOrder(visit)
        visit(this)
        rightChild?.inOrder(visit)
    }
    fun postOrder(visit: Visitor2<T>) {
        if(leftChild != null) leftChild!!.inOrder(visit)
        if(rightChild != null) rightChild!!.inOrder(visit)
        visit(this)
    }
    fun preOrder(visit: Visitor2<T>) {
        visit(this)
        if(leftChild != null) leftChild!!.inOrder(visit)
        if(rightChild != null) rightChild!!.inOrder(visit)
    }

    fun preOrderWithNull(visit: Visitor2<T>) {
        visit(this)
        leftChild?.preOrderWithNull(visit) ?: visit(null)
        rightChild?.preOrderWithNull(visit) ?: visit(null)
    }

    fun height(node: BinaryTreeNode<T>? = this): Int{
        return node?.let { 1 + max(height(node.leftChild), height((node.rightChild))) } ?: -1
    }

    // pre-order
    fun serialize(): MutableList<T?>{
        val ret = mutableListOf<T?>()
        preOrderWithNull { ret.add(it?.value) }
        return ret
    }

    // pre-order
    fun deserialize(lis: MutableList<T?>): BinaryTreeNode<T?>?{
        val v = lis.removeAt(lis.size-1) ?: return null
        val root : BinaryTreeNode<T?> = BinaryTreeNode(v)
        root.leftChild = deserialize(lis)
        root.rightChild = deserialize(lis)
        return root
    }

    fun optimizedDeserialize(lis: MutableList<T?>): BinaryTreeNode<T?>?{
        return deserialize(lis.asReversed())
    }
    val min: BinaryTreeNode<T>?
        get() = leftChild?.min ?: this
}

