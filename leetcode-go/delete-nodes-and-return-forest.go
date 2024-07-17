package main

func delNodes(root *TreeNode, to_delete []int) []*TreeNode {
	roots := make([]*TreeNode, 0)
	roots = append(roots, root)
	var deleteTree func(root *TreeNode, d int) bool
	deleteTree = func(root *TreeNode, d int) bool {
		if root == nil {
			return false
		}
		if root.Val == d {
			if root.Left != nil {
				roots = append(roots, root.Left)
			}
			if root.Right != nil {
				roots = append(roots, root.Right)
			}
			return true
		}
		if deleteTree(root.Left, d) {
			root.Left = nil
		}
		if deleteTree(root.Right, d) {
			root.Right = nil
		}
		return false
	}

	for _, d := range to_delete {
		l := len(roots)
		for i := 0; i < l; i++ {
			if deleteTree(roots[i], d) {
				roots = append(roots[:i], roots[i+1:]...)
				l--
			}
		}
	}

	return roots
}
