package main

import (
	"fmt"
)

// Standard library: https://pkg.go.dev/std

func main() {
	// Array
	arrs := [3]int{1, 2, 3}
	fmt.Printf("%v, %T\n", arrs, arrs)
	arrs2 := [...]int{4, 5, 6}
	fmt.Printf("%v, %T\n", arrs2, arrs2)
	var arrs3 [3]int
	arrs3[1] = 10
	fmt.Printf("%v, %T\n", arrs3, arrs3)
	fmt.Printf("%v, %T\n", len(arrs3), arrs3)

	// Slice
	slice := []int{1, 2, 3}
	fmt.Print("Silce \n")
	fmt.Printf("%v, %T\n", slice, slice)
	fmt.Printf("%v, %T\n", cap(slice), slice)
	fmt.Printf("%v, %T\n", len(slice), slice)

}
