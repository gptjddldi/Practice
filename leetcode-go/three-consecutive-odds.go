package main

func threeConsecutiveOdds(arr []int) bool {
	for i := 0; i < len(arr); i++ {
		if arr[i]%2 != 1 {
			continue
		}
		if i >= len(arr)-2 {
			break
		}
		if arr[i+1]%2 == 1 {
			if arr[i+2]%2 == 1 {
				return true
			} else {
				i = i + 2
			}
		}
	}
	return false
}
