package main

import "container/heap"

func minDifference(nums []int) int {
	var minHeap MinHeap
	var maxHeap MaxHeap

	heap.Init(&minHeap)
	heap.Init(&maxHeap)

	for _, num := range nums {
		heap.Push(&minHeap, num)
		heap.Push(&maxHeap, num)

		if minHeap.Len() > 4 {
			heap.Pop(&minHeap)
			heap.Pop(&maxHeap)
		}
	}

	mini := make([]int, 0)
	maxi := make([]int, 0)

	for minHeap.Len() > 0 {
		mini = append(mini, heap.Pop(&minHeap).(int))
		maxi = append(maxi, heap.Pop(&maxHeap).(int))
	}

	ret := 1 << 31
	for i := 0; i < len(mini); i++ {
		ret = min(ret, maxi[3-i]-mini[i])
	}
	return ret
}

type Heap struct {
	heap []int
}

func (h *Heap) Len() int {
	return len(h.heap)
}

func (h *Heap) Pop() any {
	old := h.heap
	n := len(old)
	x := old[n-1]
	h.heap = old[0 : n-1]
	return x
}

func (h *Heap) Push(x any) {
	h.heap = append(h.heap, x.(int))
}

func (h *Heap) Swap(i int, j int) {
	h.heap[i], h.heap[j] = h.heap[j], h.heap[i]
}

type MinHeap struct {
	Heap
}

func (h *MinHeap) Less(i int, j int) bool {
	return h.heap[i] < h.heap[j]
}

type MaxHeap struct {
	Heap
}

func (h *MaxHeap) Less(i int, j int) bool {
	return h.heap[i] > h.heap[j]
}
