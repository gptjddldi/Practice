package main

/**
 * Definition for a binary tree node.
 * type TreeNode struct {
 *     Val int
 *     Left *TreeNode
 *     Right *TreeNode
 * }
 */
func createBinaryTree(descriptions [][]int) *TreeNode {
	mp1 := make(map[int]*TreeNode)
	mp2 := make(map[int]bool)
	for _, desc := range descriptions {
		if mp1[desc[0]] == nil {
			par := &TreeNode{Val: desc[0]}
			mp1[desc[0]] = par
		}
		if mp1[desc[1]] == nil {
			child := &TreeNode{Val: desc[1]}
			mp1[desc[1]] = child
		}

		if desc[2] == 1 {
			mp1[desc[0]].Left = mp1[desc[1]]
		} else {
			mp1[desc[0]].Right = mp1[desc[1]]
		}
		mp2[desc[1]] = true
	}
	var ret *TreeNode
	for _, desc := range descriptions {
		if mp2[desc[0]] != true {
			ret = mp1[desc[0]]
			break
		}
	}
	return ret
}
