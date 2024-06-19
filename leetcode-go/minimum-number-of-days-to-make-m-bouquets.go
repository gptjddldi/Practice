package main

func minDays(bloomDay []int, m int, k int) int {
	if m*k > len(bloomDay) {
		return -1
	}
	mini, maxi := 1000000000, 0
	for i := 0; i < len(bloomDay); i++ {
		if mini > bloomDay[i] {
			mini = bloomDay[i]
		}
		if maxi < bloomDay[i] {
			maxi = bloomDay[i]
		}
	}
	for mini < maxi {
		mid := (mini + maxi) / 2
		flowers := 0
		cnt := 0
		for j := 0; j < len(bloomDay); j++ {
			if bloomDay[j] <= mid {
				flowers++
				if flowers == k {
					flowers = 0
					cnt++
				}
			} else {
				flowers = 0
			}
		}
		if cnt >= m {
			maxi = mid
		} else {
			mini = mid + 1
		}
	}
	return mini
}
