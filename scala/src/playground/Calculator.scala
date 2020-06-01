/**
  *
  */
package playground

class Calculator {
	val adder : (Int,Int) => Int = (a,b) => a + b // lambda -> function literals
	val substractor = (_:Int) - (_:Int) 
	// placeholder, replacement for (a,b) => a - b,here types are mandatory cause scala doesn't have something to infer from
	
	
	println(adder(4,5))
	println(substractor(7,4))
	
	val num = 10
	
	val list = ( 1 to num).toList
	val square = list.map(x => x * x) // anonymous function call
	val double = list.map(x => x * 2) // Higher order function
	// Higher order functions are just functions (or methods) that take or return other functions
	// If a method or function does not take or return another function, it is called a first order function
	
	val tripple = list.map(_ * 3) // placeholder, no need to declare type
	
	println("Square -> "+square)  
	println("Double -> "+double)  
	println("Tripple -> "+tripple)
}

object Calculator { // companion object
	def main(args: Array[String]): Unit = {}
	
	val cal = new Calculator()
	
	// yield block, foreach is used and Unit is the result type
	// without yield block, foreach is used and Unit is the result type
	// yield will return value in same unit of last expression
	//The compare: (Int, Int) => Int) is syntactic sugar for Function2[Int,Int, Int] and is the idiomatic Scala way to write a function literal type
	
	def compareNeighbors(xs: List[Int], compare: (Int, Int) => Int): List[Int] = {
				for (pair <- xs.sliding(2)) yield {
					compare(pair(0), pair(1))
				}
		}.toList
	

		
}