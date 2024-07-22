package main

import "sort"

type Person struct {
	name   string
	height int
}

func sortPeople(names []string, heights []int) []string {
	var people []Person
	for i := 0; i < len(names); i++ {
		people = append(people, Person{name: names[i], height: heights[i]})
	}
	sort.Slice(people, func(i, j int) bool {
		return people[i].height > people[j].height
	})
	ret := make([]string, len(names))

	for i := 0; i < len(people); i++ {
		ret[i] = people[i].name
	}
	return ret
}
