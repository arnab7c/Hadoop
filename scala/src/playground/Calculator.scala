/**
  * Anonymous Function
  * Higher Order Function, partial application of function
  * for - yield
  * closure
  * partial function
  */
package playground

class Calculator {
	val adder : (Int,Int) => Int = (a,b) => a + b // lambda -> function literals
	val substractor = (_:Int) - (_:Int) 
	// placeholder, replacement for (a,b) => a - b,here types are mandatory cause scala doesn't have something to infer from
	
	def add3val : (Int,Int,Int) => Int = (a,b,c) => a+b+c
	
	println(adder(4,5))
	println(substractor(7,4))
	
	val num = 10
	
	val list = ( 1 to num).toList
	val square = list.map(x => x * x) // anonymous function call
	val double = list.map(x => x * 2) // Higher order function
	// Higher order functions are just functions (or methods) that take or return other functions
	// If a method or function does not take or return another function, it is called a first order function
	
	val tripple = list.map(_ * 3) // placeholder, no need to declare type
	
	val adval1 = add3val(_,_,_) // partial application of function
	val adval2 = add3val(5,_:Int,8) // second parameter supplied during call
	val adval3 = add3val // all parameters supplied during call
	
	println("Square -> "+square)  
	println("Double -> "+double)  
	println("Tripple -> "+tripple)
	println("Adval 1-> "+adval1(4,5,6))
	println("Adval 2-> "+adval2(10))
	println("Adval 3-> "+adval3(10,20,30))
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
	
		
	// Closure - A closure is so-called because it encloses around some other state than that passed into the function as parameters	
	// It's better alternative for vars in scala
		
		val total = 70
		
		val parcentage = (x:Int) => (x * 100)/total // this is closure, total is passed from other state
		
		println("Parcentage -> "+parcentage(55))
	
	// Partial Function -> Any block of code with case inside of {}s is a Partial Function
	// A PartialFunction[T, R] extends Function1[T, R] (which is idiomatically written T => R)
	// MatchError thrown if there is no case to handle the input 
		
		def GradeCalculation (x:Int): String = 
			x match {
				case x if ( x >= 90 ) => s"O"
				case x if ( x >= 80 && x < 90 ) => s"E"
				case x if ( x >= 70 && x < 80 ) => s"A"
				case x if ( x >= 60 && x < 70 ) => s"B"
				case x if ( x >= 50 && x < 60 ) => s"C"
				case x if ( x >= 40 && x < 50 ) => s"D"
				case _ => s"F"
			}
			
		
		println("Grade -> "+GradeCalculation(parcentage(10)))
}