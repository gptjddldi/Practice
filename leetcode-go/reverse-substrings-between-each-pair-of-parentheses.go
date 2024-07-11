package main

func reverseParentheses(s string) string {
	stack := []string{}
	curr := ""
	for _, ch := range s {
		if ch == '(' {
			stack = append(stack, curr)
			curr = ""
		} else if ch == ')' {
			curr = rev(curr)
			p := stack[len(stack)-1]
			stack = stack[:len(stack)-1]
			curr = p + curr
		} else {
			curr += string(ch)
		}
	}
	return curr
}

func rev(s string) string {
	r := []rune(s)
	i, j := 0, len(r)-1
	for i < j {
		r[i], r[j] = r[j], r[i]
		i++
		j--
	}
	return string(r)
}
