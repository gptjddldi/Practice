package main

import (
	"sort"
	"strconv"
)

func sortJumbled(mapping []int, nums []int) []int {
	type Jum struct {
		num     int
		jumbled int
	}
	lis := make([]*Jum, 0)
	for i, num := range nums {
		r := 0
		s := strconv.Itoa(num)
		for _, c := range s {
			r = r*10 + mapping[c-'0']
		}
		lis = append(lis, &Jum{num: i, jumbled: r})
	}
	sort.Slice(lis, func(a, b int) bool {
		if lis[a].jumbled == lis[b].jumbled {
			return lis[a].num < lis[b].num
		}
		return lis[a].jumbled < lis[b].jumbled
	})
	res := make([]int, len(lis))
	for i := 0; i < len(res); i++ {
		res[i] = nums[lis[i].num]
	}
	return res
}
