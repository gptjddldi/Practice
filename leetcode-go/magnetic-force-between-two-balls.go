package main

import "sort"

func maxDistance(position []int, m int) int {
	sort.Ints(position)
	mini, maxi := 1, 1000000000
	for mini < maxi {
		diff := (mini + maxi) / 2
		cnt := 1
		prev := position[0]
		for i := 1; i < len(position); i++ {
			if position[i]-prev >= diff {
				cnt++
				prev = position[i]
			}
		}
		if cnt >= m {
			mini = diff + 1
		} else {
			maxi = diff
		}
	}
	return mini - 1
}
