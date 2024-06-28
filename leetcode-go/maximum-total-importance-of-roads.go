package main

import "sort"

func maximumImportance(n int, roads [][]int) int64 {
	ret := int64(0)
	lis := make([]int, 50002)
	for _, road := range roads {
		lis[road[0]]++
		lis[road[1]]++
	}
	sort.Sort(sort.Reverse(sort.IntSlice(lis)))
	for i := 0; i < n; i++ {
		ret += int64(lis[i] * (n - i))
		if lis[i] == 0 {
			break
		}
	}
	return ret
}
