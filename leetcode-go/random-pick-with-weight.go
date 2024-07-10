package main

import "math/rand"

type RandomPick struct {
	sum int
	w   []int
	w2  []int
}

func Constructor(w []int) RandomPick {
	s := 0
	w2 := make([]int, len(w))
	copy(w2, w)
	for idx, i := range w {
		s += i
		if idx == 0 {
			continue
		}
		w2[idx] += w2[idx-1]
	}
	return RandomPick{sum: s, w: w, w2: w2}
}

func (rp *RandomPick) PickIndex() int {
	r := rand.Float64()
	tar := r * float64(rp.sum)
	com := 0.0
	for idx, val := range rp.w {
		com += float64(val)
		if com >= tar {
			return idx
		}
	}
	return -1
}
func (rp *RandomPick) PickIndex2() int {
	l := len(rp.w2)
	r := rand.Intn(rp.w2[l-1]) + 1
	left, right := 0, l-1
	for left < right {
		mid := (left + right) / 2
		if rp.w2[mid] == r {
			return mid
		} else if rp.w2[mid] < r {
			left = mid + 1
		} else {
			right = mid
		}
	}
	return left
}

/**
 * Your Solution object will be instantiated and called as such:
 * obj := Constructor(w);
 * param_1 := obj.PickIndex();
 */
