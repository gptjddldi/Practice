package main

func nodesBetweenCriticalPoints(head *ListNode) []int {
	result := []int{-1, -1}

	prev := head.Val
	current := head.Next
	index := 1

	firstCritical := -1
	lastCritical := -1
	minDistance := 1<<31 - 1 // int32 최대값
	prevCritical := -1

	for current != nil && current.Next != nil {
		next := current.Next.Val

		isCritical := (current.Val < prev && current.Val < next) ||
			(current.Val > prev && current.Val > next)

		if isCritical {
			if firstCritical == -1 {
				firstCritical = index
			} else {
				if prevCritical != -1 {
					minDistance = min(minDistance, index-prevCritical)
				}
			}
			prevCritical = index
			lastCritical = index
		}

		prev = current.Val
		current = current.Next
		index++
	}

	if lastCritical-firstCritical > 0 {
		result[0] = minDistance
		result[1] = lastCritical - firstCritical
	}

	return result
}
