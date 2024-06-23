package main

func longestSubarray(nums []int, limit int) int {
	var maxQ, minQ []int
	left, right := 0, 0
	ret := 0
	for right < len(nums) {
		for len(maxQ) > 0 && nums[right] > nums[maxQ[len(maxQ)-1]] {
			maxQ = maxQ[:len(maxQ)-1]
		}
		for len(minQ) > 0 && nums[right] < nums[minQ[len(minQ)-1]] {
			minQ = minQ[:len(minQ)-1]
		}
		maxQ = append(maxQ, right)
		minQ = append(minQ, right)
		for nums[maxQ[0]]-nums[minQ[0]] > limit {
			left++
			if maxQ[0] < left {
				maxQ = maxQ[1:]
			}
			if minQ[0] < left {
				minQ = minQ[1:]
			}
		}
		ret = max(ret, right-left+1)
		right++
	}
	return ret
}