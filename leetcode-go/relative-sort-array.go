package main

import "sort"

func relativeSortArray(arr1 []int, arr2 []int) []int {
	h := make(map[int]int)
	for i, v := range arr2 {
		h[v] = i
	}
	sort.Slice(arr1, func(i, j int) bool {
		x, y := arr1[i], arr1[j]
		rankX, hasX := h[x]
		rankY, hasY := h[y]
		if hasX && hasY {
			return rankX < rankY
		}
		if hasX || hasY {
			return hasX
		}
		return x < y
	})

	return arr1
}
