package main

import (
	"testing"

	"github.com/stretchr/testify/assert"
)

func TestRandomPick(t *testing.T) {
	rp := Constructor([]int{1, 2, 3, 4})
	cnt := make([]int, 4)
	trials := 1000000
	for i := 0; i < trials; i++ {
		idx := rp.PickIndex()
		cnt[idx]++
	}

	for i := 0; i < 4; i++ {
		assert.InDelta(t, (trials/rp.sum)*rp.w[i], cnt[i], 10000)
	}
}

func TestRandomPick2(t *testing.T) {
	rp := Constructor([]int{1, 2, 3, 4})
	cnt := make([]int, 4)
	trials := 1000000
	for i := 0; i < trials; i++ {
		idx := rp.PickIndex2()
		cnt[idx]++
	}

	for i := 0; i < 4; i++ {
		assert.InDelta(t, (trials/rp.sum)*rp.w[i], cnt[i], 10000)
	}
}
