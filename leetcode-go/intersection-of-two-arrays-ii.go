package main

func intersect(nums1 []int, nums2 []int) []int {
	mp := make([]int, 1001)
	ret := make([]int, 0)
	for _, num := range nums1 {
		mp[num]++
	}
	for _, num := range nums2 {
		if mp[num] > 0 {
			mp[num]--
			ret = append(ret, num)
		}
	}
	return ret
}
