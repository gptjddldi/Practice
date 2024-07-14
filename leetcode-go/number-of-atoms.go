package main

import (
	"fmt"
	"slices"
	"sort"
	"strconv"
)

// stack
// ( 열리면 stack 시작. 닫히면 스택에 있는 것과 ) 이후 숫자를 곱함. (문자가 오거나 끝이면 1 곱함)
// [K4]
// [O,N]
// [S,O3] * 2
// [O,N,S2,O6] => [O7,S2,N]
// [O14,S4,N2,K4]
func countOfAtoms(formula string) string {
	sta := []string{}
	cur := ""
	for i := 0; i < len(formula); i++ {
		if formula[i] == '(' {
			sta = append(sta, cur)
			cur = ""
		} else if formula[i] == ')' {
			if i+1 < len(formula) && formula[i+1] >= '0' && formula[i+1] <= '9' {
				a := ""
				for i+1 < len(formula) && formula[i+1] >= '0' && formula[i+1] <= '9' {
					a += string(formula[i+1])
					i++
				}
				digit, _ := strconv.Atoi(string(a))
				fmt.Println(cur, digit)
				cur = multiple(cur, digit)
			}
			cur += sta[len(sta)-1]
			sta = sta[:len(sta)-1]
		} else {
			cur = cur + string(formula[i])
		}
	}
	return helper(cur)
}

func multiple(s string, num int) string {
	ret := ""
	for i := 0; i < len(s); i++ {
		if s[i] >= 'A' && s[i] <= 'Z' {
			ret += string(s[i])
			if i+1 < len(s) && s[i+1] >= 'a' && s[i+1] <= 'z' {
				ret += string(s[i+1])
				i++
			}
			if i+1 == len(s) || (s[i+1] < '0' || s[i+1] > '9') {
				ret += strconv.Itoa(num)
			}
		} else {
			a := ""
			for i < len(s) && s[i] >= '0' && s[i] <= '9' {
				a += string(s[i])
				i++
			}
			i--
			digit, _ := strconv.Atoi(string(a))
			result := digit * num
			ret += strconv.Itoa(result)
		}
	}
	return ret
}

func helper(initial string) string {
	mp := map[string]int{}
	lis := []string{}
	cur := ""
	for i := 0; i < len(initial); i++ {
		if initial[i] >= 'A' && initial[i] <= 'Z' {
			if cur != "" {
				if mp[cur] == 0 {
					lis = append(lis, cur)
				}
				mp[cur]++
				cur = ""
			}
			cur = string(initial[i])
			if i+1 < len(initial) && initial[i+1] >= 'a' && initial[i+1] <= 'z' {
				cur += string(initial[i+1])
				i++
			}
		} else {
			if mp[cur] == 0 {
				lis = append(lis, cur)
			}
			a := ""
			for i < len(initial) && initial[i] >= '0' && initial[i] <= '9' {
				a += string(initial[i])
				i++
			}
			digit, _ := strconv.Atoi(string(a))
			mp[cur] += digit
			cur = ""
			i--
		}
	}
	if cur != "" {
		mp[cur]++
		lis = append(lis, cur)
	}

	sort.Slice(lis, func(i, j int) bool {
		if lis[i][0] != lis[j][0] {
			return lis[i][0] < lis[j][0]
		}
		return lis[i] < lis[j]
	})
	//sort.Strings(lis)

	ret := ""
	for i := 0; i < len(lis); i++ {
		ret += lis[i]
		if mp[lis[i]] > 1 {
			ret = ret + strconv.Itoa(mp[lis[i]])
		}
	}
	fmt.Println(mp)
	return ret
}

func countOfAtoms2(formula string) string {
	type instance struct {
		mp map[string]int
	}
	var (
		count    = 0
		stack    = make([]instance, 1)
		idx      = 0
		cur      = ""
		groupEnd = false
	)

	stack[idx].mp = make(map[string]int)

	flush := func() {
		if count == 0 {
			count = 1
		}
		if groupEnd {
			for elem, v := range stack[idx].mp {
				stack[idx-1].mp[elem] += v * count
			}
			stack[idx].mp = nil
			groupEnd = false
			idx--
		} else if len(cur) > 0 {
			stack[idx].mp[cur] += count
			cur = ""
		}
		count = 0
	}
	for _, ru := range formula {
		switch {
		case ru >= 'A' && ru <= 'Z':
			flush()
			cur = string(ru)
		case ru >= 'a' && ru <= 'z':
			cur += string(ru)
		case ru >= '0' && ru <= '9':
			count = count*10 + int(ru-'0')
		case ru == '(':
			flush()
			idx++
			if idx == len(stack) {
				stack = append(stack, instance{mp: make(map[string]int)})
			}
			stack[idx].mp = make(map[string]int)
		case ru == ')':
			flush()
			groupEnd = true
		}
	}
	flush()

	var names = make([]string, 0, len(stack[0].mp))
	for elem := range stack[0].mp {
		names = append(names, elem)
	}
	slices.Sort(names)

	// prepare output string
	var out = make([]byte, 0, 2000)
	for _, elem := range names {
		out = append(out, []byte(elem)...)
		if stack[0].mp[elem] > 1 {
			out = append(out, []byte(strconv.Itoa(stack[0].mp[elem]))...)
		}
	}

	return string(out)
}
