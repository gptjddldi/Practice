package main

import (
	"fmt"
	"bytes"
)

func main() {
	a := []byte("TestKey1")
	b := []byte("TestKey1001")
	fmt.Println(bytes.Compare(a, b))
}
