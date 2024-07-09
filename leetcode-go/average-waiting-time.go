package main

func averageWaitingTime(customers [][]int) float64 {
	waiting := 0
	time := 0
	for _, c := range customers {
		if time > c[0] {
			waiting += time - c[0]
		} else {
			time = c[0]
		}
		waiting += c[1]
		time += c[1]
	}
	return float64(waiting) / float64(len(customers))
}
