package main

import "sort"

func heightChecker(heights []int) int {
	var ret int
	dumps := make([]int, len(heights))
	copy(dumps, heights)
	sort.Ints(heights)
	for i := 0; i < len(heights); i++ {
		if heights[i] != dumps[i] {
			ret++
		}
	}
	return ret
}
