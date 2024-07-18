package main

func countPairs(root *TreeNode, distance int) int {
	ret := 0
	var dfs func(node *TreeNode) []int
	dfs = func(node *TreeNode) []int {
		if node == nil {
			return []int{}
		}
		if node.Left == nil && node.Right == nil {
			return []int{0}
		}
		lefts := dfs(node.Left)
		rights := dfs(node.Right)
		distances := make([]int, 0)
		for i := 0; i < len(lefts); i++ {
			for j := 0; j < len(rights); j++ {
				if lefts[i]+rights[j]+2 <= distance {
					ret++
				}
			}
		}
		for i := 0; i < len(lefts); i++ {
			distances = append(distances, lefts[i]+1)
		}
		for i := 0; i < len(rights); i++ {
			distances = append(distances, rights[i]+1)
		}
		return distances
	}
	dfs(root)
	return ret
}
