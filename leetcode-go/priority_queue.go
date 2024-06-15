package main

type heapItem struct {
	value int
	index int
}

type priorityQueue []*heapItem

func (pq priorityQueue) Len() int {
	return len(pq)
}

//	func (pq priorityQueue) Less(i, j int) bool {
//		return pq[i].value < pq[j].value
//	}
func (pq priorityQueue) Less(i, j int) bool {
	if pq[i] == nil || pq[j] == nil {
		return false
	}
	return pq[i].value > pq[j].value
}
func (pq priorityQueue) Swap(i, j int) {
	pq[i], pq[j] = pq[j], pq[i]
	pq[i].index = i
	pq[j].index = j
}

func (pq *priorityQueue) Push(x interface{}) {
	n := pq.Len()
	item := x.(*heapItem)
	item.index = n
	*pq = append(*pq, item)
}

func (pq *priorityQueue) Pop() interface{} {
	old := *pq
	n := len(old)
	item := old[n-1]
	old[n-1] = nil
	item.index = -1
	*pq = old[0 : n-1]
	return item
}
