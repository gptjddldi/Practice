package main

// dp[i]: i 까지 봤을 때 개수
// dp[0]=0 dp[1]=0 ~ dp[5]=0, dp[6]=4, dp[7]=8
func numberOfSubarrays(nums []int, k int) int {
	// dp := make([]int, len(nums)+1)
	var odds []int
	idx := -1
	ret := 0
	for i := 0; i < len(nums); i++ {
		if isOdd(nums[i]) {
			odds = append(odds, i)
		}
		if len(odds) > k {
			idx = odds[0]
			odds = odds[1:]
		}
		if len(odds) == k {
			ret += odds[0] - idx
		}
	}

	return ret
}

func isOdd(num int) bool {
	return num%2 == 1
}
