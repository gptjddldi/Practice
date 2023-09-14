package Tree

class BinarySearchTree<T: Comparable<T>> {
    var root: BinaryTreeNode<T>? = null
    override fun toString(): String {
        return root?.toString() ?: "Empty tree"
    }
    fun insert(value: T){
        root = insert(root, value)
    }

    private fun insert(node: BinaryTreeNode<T>?, value: T): BinaryTreeNode<T>?{
        node?: return BinaryTreeNode(value)
        if (value <= node.value){
            node.leftChild = insert(node.leftChild, value)
        } else{
            node.rightChild = insert(node.rightChild, value)
        }
        return node
    }

    fun delete(value: T){
        delete(root, value)
    }

    private fun delete(node: BinaryTreeNode<T>?, value: T): BinaryTreeNode<T>?{
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
        return node
    }

    fun search(value: T): BinaryTreeNode<T>? {
        var cur = root
        while (cur != null){
            if (cur?.value == value) return cur
            else if (cur?.value!! > value) cur = cur.leftChild
            else if (cur?.value!! < value) cur = cur.rightChild
        }
        return null
    }

}