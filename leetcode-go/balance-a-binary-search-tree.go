package main

func balanceBST(root *TreeNode) *TreeNode {
	var nodes []int

	var inOrder func(*TreeNode)
	inOrder = func(node *TreeNode) {
		if node == nil {
			return
		}
		inOrder(node.Left)
		nodes = append(nodes, node.Val)
		inOrder(node.Right)
	}

	inOrder(root)

	return buildTree(nodes, 0, len(nodes)-1)
}

func buildTree(nodes []int, start, end int) *TreeNode {
	if start > end {
		return nil
	}

	mid := (start + end) / 2
	node := &TreeNode{Val: nodes[mid], Left: nil, Right: nil}
	node.Left = buildTree(nodes, start, mid-1)
	node.Right = buildTree(nodes, mid+1, end)
	return node
}
