package main

import (
	"fmt"
)

// Standard library: https://pkg.go.dev/std
const (
	red    = 0
	blue   = 1
	yellow = 2
)

const (
	x = iota
	y
	z
)

const (
	_ = iota
	Yz
	Zz
)

func main() {
	const pi float32 = 3.14
	fmt.Println("\n", pi)
	fmt.Printf("%v, %T\n", red, red)
	fmt.Printf("%v, %T\n", x, x)
	fmt.Printf("%v, %T\n", y, y)
	fmt.Printf("%v, %T\n", z, z)
	fmt.Printf("%v, %T\n", Yz, Yz)
	fmt.Printf("%v, %T\n", Zz, Zz)
}
