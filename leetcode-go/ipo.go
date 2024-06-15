package main

import (
	"container/heap"
	"sort"
)

func findMaximizedCapital(k int, w int, profits []int, capital []int) int {
	type pair struct {
		profit  int
		capital int
	}

	pairs := make([]pair, len(profits))
	for i := range pairs {
		pairs[i] = pair{profits[i], capital[i]}
	}

	sort.Slice(pairs, func(i, j int) bool {
		return pairs[i].capital < pairs[j].capital
	})

	var pq priorityQueue
	heap.Init(&pq)

	for i := 0; i < k; i++ {
		for len(pairs) > 0 && pairs[0].capital <= w {
			heap.Push(&pq, &heapItem{
				value: pairs[0].profit,
			})
			pairs = pairs[1:]
		}
		if pq.Len() == 0 {
			break
		}
		item := heap.Pop(&pq).(*heapItem)
		w += item.value
	}
	return w
}
