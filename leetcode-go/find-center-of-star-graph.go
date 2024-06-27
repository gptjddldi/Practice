package main

func findCenter(edges [][]int) int {
	mp := make(map[int]int)
	for _, edge := range edges {
		mp[edge[0]]++
		mp[edge[1]]++
	}
	return -1
}
