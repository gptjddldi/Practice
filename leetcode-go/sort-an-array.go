package main

func sortArray(nums []int) []int {
	if len(nums) <= 1 {
		return nums
	}

	mid := len(nums) / 2
	left := make([]int, mid)
	right := make([]int, len(nums)-mid)

	copy(left, nums[:mid])
	copy(right, nums[mid:])

	left = sortArray(left)
	right = sortArray(right)

	return merge(left, right)
}

func merge(left, right []int) []int {
	ret := make([]int, 0)
	for len(left) > 0 && len(right) > 0 {
		if left[0] > right[0] {
			ret = append(ret, right[0])
			right = right[1:]
		} else {
			ret = append(ret, left[0])
			left = left[1:]
		}
	}
	ret = append(ret, left...)
	ret = append(ret, right...)

	return ret
}
