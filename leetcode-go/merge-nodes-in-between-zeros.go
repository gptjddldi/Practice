package main

type ListNode struct {
	Val  int
	Next *ListNode
}

func mergeNodes(head *ListNode) *ListNode {
	node := head.Next
	acc := 0
	cur := &ListNode{}
	ret := cur
	for node != nil {
		if node.Val == 0 {
			cur.Next = &ListNode{Val: acc, Next: nil}
			cur = cur.Next
			acc = 0
		}
		acc += node.Val
		node = node.Next
	}
	return ret.Next
}
