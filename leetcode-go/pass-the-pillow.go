package main

func passThePillow(n int, time int) int {
	i := (time % (2*n - 2)) + 1
	if i <= n {
		return i
	}
	return n - (i - n)
}
