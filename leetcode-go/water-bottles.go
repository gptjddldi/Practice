package main

func numWaterBottles(numBottles int, numExchange int) int {
	ret := numBottles
	left := numBottles
	for left >= numExchange {
		a := left / numExchange
		b := left % numExchange
		ret += a
		left = a + b
	}
	return ret
}
