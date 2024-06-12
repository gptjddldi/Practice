package main

func sortColors(nums []int) {
	var r, g, b int
	for _, v := range nums {
		if v == 0 {
			r++
		} else if v == 1 {
			g++
		} else {
			b++
		}
	}
	for i := 0; i < len(nums); i++ {
		if i < r {
			nums[i] = 0
		} else if i < r+g {
			nums[i] = 1
		} else {
			nums[i] = 2
		}
	}
}
