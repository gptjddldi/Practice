package main

func minKBitFlips(nums []int, k int) int {
	ret := 0
	curFlipCount := 0
	for i := 0; i < len(nums); i++ {
		if i >= k && nums[i-k] == 2 { // i-k 에서 플립했으면 줄여줌
			curFlipCount--
		}
		if curFlipCount%2 == nums[i] { // i-k ~ i-1 까지 플립 몇번했는지와, 지금 value 비교해서 플립이 필요한지 확인
			if i+k > len(nums) {
				return -1
			}
			nums[i] = 2
			curFlipCount++
			ret++
		}
	}

	return ret
}
