package main

import (
	"fmt"
)

// Standard library: https://pkg.go.dev/std
/**
* 1 Boolean
* 2 Numerics
*   2.1 Integer
*      signed integer: int8 int16 int32 int64
*      unsigned integer: uint8 uint16 uint32 uint64
*   2.2 Float: float32 float64
*   2.3 Complex: complex64 complex128
* 3 Text
*   3.1 String: string
*   3.2 Byte -> UTF-8 byte
*   3.3 Rune -> UTF-32
**/
func main() {
	var helloWorld string = "Hello World"
	var b []byte = []byte(helloWorld)
	var c []rune = []rune(helloWorld)
	fmt.Println("Byte")
	fmt.Printf("%v %T\n", b, b)
	fmt.Println("Rune")
	fmt.Printf("%v %T", c, c)
}
