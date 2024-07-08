package main

func findTheWinner(n int, k int) int {
	if k == 1 {
		return n
	}
	cur := &Node{Val: 1}
	start := cur
	for i := 2; i <= n; i++ {
		cur.Next = &Node{Val: i}
		cur = cur.Next
	}
	cur.Next = start
	cur = start
	for cur.Next != cur {
		for i := 1; i < k-1; i++ {
			cur = cur.Next
		}
		cur.Next = cur.Next.Next
		cur = cur.Next
	}
	return cur.Val
}

type Node struct {
	Val  int
	Next *Node
}
