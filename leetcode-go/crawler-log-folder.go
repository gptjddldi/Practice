package main

func minOperations(logs []string) int {
	ret := 0
	for _, log := range logs {
		if log == "./" {
			continue
		} else if log == "../" {
			ret = max(ret-1, 0)
		} else {
			ret++
		}
	}
	return ret
}
