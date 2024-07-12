package main

func maximumGain(s string, x int, y int) int {
	ret := 0
	if x >= y {
		st, v := help(s, "ab", x)
		ret += v
		_, v = help(st, "ba", y)
		ret += v
	} else {
		st, v := help(s, "ba", y)
		ret += v
		_, v = help(st, "ab", x)
		ret += v
	}
	return ret
}

func help(s string, sub string, x int) (string, int) {
	var score int
	var stack []byte
	for i := 0; i < len(s); i++ {
		if s[i] == sub[1] && len(stack) > 0 && stack[len(stack)-1] == sub[0] {
			stack = stack[:len(stack)-1]
			score += x
		} else {
			stack = append(stack, s[i])
		}
	}
	return string(stack), score
}
