package main

// Nlog(N)
// difficulty 에 따라 profit 을 같이 정렬하고,
// dp[i] = max(dp[i-1], profit[k]) (단, difficulty[k] = i)
// 정렬 안 해도 됨 ㅋ

func maxProfitAssignment(difficulty []int, profit []int, worker []int) int {
	h := make(map[int]int)
	for i := 0; i < len(difficulty); i++ {
		h[difficulty[i]] = max(profit[i], h[difficulty[i]])
	}
	end := 0
	for _, d := range worker {
		if d > end {
			end = d
		}
	}
	dp := make([]int, end+1)

	for i := 1; i <= end; i++ {
		dp[i] = dp[i-1]
		if v, ok := h[i]; ok {
			dp[i] = max(dp[i], v)
		}
	}

	res := 0
	for _, w := range worker {
		res += dp[w]
	}
	return res
}
