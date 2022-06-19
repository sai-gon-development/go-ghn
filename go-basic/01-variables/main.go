package main

import (
	"fmt"
	// Standard library: https://pkg.go.dev/std
	"strconv"
)

var globalVariable int = 100

// Multi Global Variable
var (
	f int    = 20
	d int    = 5
	p string = "Test"
)

//Access modifiers
var Number int = 10000

func main() {
	fmt.Println("Hello World")
	var i = 11
	fmt.Println(i)
	x := 10
	fmt.Println(x)
	fmt.Printf("%v, %T ", x, x)
	fmt.Println("Global variable")
	fmt.Println(globalVariable)
	fmt.Println("Multi Global variable")
	fmt.Println(f)
	fmt.Println(d)
	fmt.Println(p)
	fmt.Println()
	var j string = strconv.Itoa(x)
	fmt.Printf("%v, %T", j, j)
}
