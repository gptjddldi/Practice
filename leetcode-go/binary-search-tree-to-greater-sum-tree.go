package main

type TreeNode struct {
	Val   int
	Left  *TreeNode
	Right *TreeNode
}

// 오 - 중 - 왼 으로 순회하면서 바꾸면 됨

func bstToGst(root *TreeNode) *TreeNode {
	ret := root
	traverse(root, 0)
	return ret
}

func traverse(current *TreeNode, acc int) int {
	v := acc
	if current == nil {
		return acc
	}
	v = traverse(current.Right, acc)
	current.Val += v
	return traverse(current.Left, current.Val)
}
