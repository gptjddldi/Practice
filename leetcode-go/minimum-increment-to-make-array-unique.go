package main

// 1,1,2,2,3,7
// 1,2,3,4,5,7
// 3 + 3 = 6

// O(N)
func minIncrementForUnique(nums []int) int {
	ret := 0
	mini, maxi := 1000000, 0
	hash := make(map[int]int)
	for i := 0; i < len(nums); i++ {
		n := nums[i]
		hash[n]++
		if n <= mini {
			mini = n
		}
		if n >= maxi {
			maxi = n
		}
	}
	var lis []int
	for i := mini; i <= maxi+len(nums); i++ {
		for hash[i] > 1 {
			lis = append(lis, hash[i])
			hash[i]--
		}
		if hash[i] == 0 && len(lis) > 0 {
			ret += i - lis[len(lis)-1]
			lis = lis[:len(lis)-1]
		}
	}
	return ret
}
