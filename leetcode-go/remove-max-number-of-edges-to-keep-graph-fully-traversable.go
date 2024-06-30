package main

func maxNumEdgesToRemove(n int, edges [][]int) int {
	mp := make([]int, n+1)
	var find func(a int) int
	var union func(a, b int) bool

	find = func(a int) int {
		if a != mp[a] {
			mp[a] = find(mp[a])
		}
		return mp[a]
	}

	union = func(a, b int) bool {
		find_a := find(a)
		find_b := find(b)
		if find_a == find_b {
			return true
		}
		mp[find_a] = mp[find_b]
		return false
	}

	ret := 0
	e1, e2 := 0, 0
	for i := 0; i <= n; i++ {
		mp[i] = i
	}
	for _, edge := range edges {
		if edge[0] == 3 {
			if union(edge[1], edge[2]) {
				ret++
			} else {
				e1++
				e2++
			}
		}
	}

	mp2 := make([]int, n+1)
	for i := 0; i <= n; i++ {
		mp2[i] = mp[i]
	}

	for _, edge := range edges {
		if edge[0] == 1 {
			if union(edge[1], edge[2]) {
				ret++
			} else {
				e1++
			}
		}
	}

	mp = mp2
	for _, edge := range edges {
		if edge[0] == 2 {
			if union(edge[1], edge[2]) {
				ret++
			} else {
				e2++
			}
		}
	}

	if e1 != n-1 || e2 != n-1 {
		return -1
	}
	return ret

}
