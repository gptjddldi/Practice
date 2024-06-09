package main

// prefix sum
// nums = [4,5,0,-2,-3,1], k = 5
// 4: {4: 1} ret = 0
// 5: {4: 2, 0: 1} ret = 1
// 0: {4: 3, 0: 2} ret += 1 + hash[0] = 3
// -2: {}
// 0 부터 i 까지 합을 k 로 나눈 나머지를 저장함
func subarraysDivByK(nums []int, k int) int {
	ret := 0
	s := 0
	hash := make(map[int]int)
	hash[0] = 1
	for i := 0; i < len(nums); i++ {
		s = (s + nums[i]) % k
		if s < 0 {
			s += k
		}

		ret += hash[s]
		hash[s] += 1
	}
	return ret
}
