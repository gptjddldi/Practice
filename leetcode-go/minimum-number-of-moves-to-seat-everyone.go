package main

import "sort"

func minMovesToSeat(seats []int, students []int) int {
	ret := 0
	sort.Ints(seats)
	sort.Ints(students)
	for i := 0; i < len(seats); i++ {
		ret += abs(seats[i] - students[i])
	}
	return ret
}

func abs(i int) int {
	if i < 0 {
		return -i
	}
	return i
}
