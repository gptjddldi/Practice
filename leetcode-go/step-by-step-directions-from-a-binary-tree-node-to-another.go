package main

func getDirections(root *TreeNode, startValue int, destValue int) string {
	start, _ := finder(root, startValue, []byte{})
	dest, _ := finder(root, destValue, []byte{})

	idx := 0
	for idx < len(dest) && idx < len(start) {
		if start[idx] != dest[idx] {
			break
		}
		idx++
	}
	dest = dest[idx:]
	str := ""

	for i := 0; i < len(start)-idx; i++ {
		str += "U"
	}
	return str + string(dest)
}

func finder(cur *TreeNode, tar int, prev []byte) ([]byte, bool) {
	if cur == nil {
		return nil, false
	}

	if cur.Val == tar {
		return prev, true
	}

	if cur.Left == nil && cur.Right == nil {
		return nil, false
	}
	if cur.Left != nil {
		tmp := append(prev, 'L')
		if ret, ok := finder(cur.Left, tar, tmp); ok {
			return ret, true
		}
	}
	return finder(cur.Right, tar, append(prev, 'R'))
}
