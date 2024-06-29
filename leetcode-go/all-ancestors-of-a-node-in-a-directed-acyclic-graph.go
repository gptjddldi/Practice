package main

func getAncestors(n int, edges [][]int) [][]int {
	mp := make([][]int, n)
	ret := make([][]int, n)
	for _, edge := range edges {
		mp[edge[0]] = append(mp[edge[0]], edge[1])
	}
	var dfs func(origin, cur int)
	dfs = func(origin, cur int) {
		for _, child := range mp[cur] {
			if len(ret[child]) > 0 && ret[child][len(ret[child])-1] == origin {
				continue
			}
			ret[child] = append(ret[child], origin)
			dfs(origin, child)
		}
	}
	for i := 0; i < n; i++ {
		dfs(i, i)
	}
	return ret
}
