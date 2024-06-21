package main

func maxSatisfied(customers []int, grumpy []int, minutes int) int {
	ret := 0
	for i := 0; i < len(customers); i++ {
		if grumpy[i] == 0 {
			ret += customers[i]
		}
	}
	l := 0
	for i := 0; i < minutes; i++ {
		if grumpy[i] == 1 {
			ret += customers[i]
		}
	}
	maxi := ret
	for i := minutes; i < len(customers); i++ {
		if grumpy[i] == 1 {
			ret += customers[i]
		}
		if grumpy[l] == 1 {
			ret -= customers[l]
		}
		l++
		if ret > maxi {
			maxi = ret
		}
	}
	return maxi
}
