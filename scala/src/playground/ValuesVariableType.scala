/**
 * Basic val & var
 * Call by name & call by value
 * String Interpolation
 * Factorial with loop, recursion & tailrecursion
 * Prime with tail recursion
 */
package playground
import scala.annotation.tailrec

object ValuesVariableType extends App{
  
  val a="Arnab" // val is immutable, if no return type is present - scala will interpret by value
  val b:String = "Chatterjee"  // return type String is mentioned
  var x = 100 // var is mutable, not advisable to use   
  
// call by value & call by name 
/* Call by value will evaluate the expression and pass the evaluated value
 * Call by name will pass the expression as is & expression will be evaluated runtime
 */  
  def CallByValue(x:Long):Unit={
  	println("Call by value ==>")
    println("value a -> "+x) // in both case same value will be printed
    println("value b -> "+x) // value of x evaluated, then send to method
  }
  
   def CallByName(x: => Long):Unit={
    println("Call by name ==>")
    println("name a -> "+x) // in both case, different number will be printed
    println("name b -> "+x) // instead of value of x, System.nanoTime() method passed which evaluates run time
  }
 
   CallByValue(System.nanoTime()) 
   CallByName(System.nanoTime()) 
    
// F-interpolator  & Raw interpolator 
   val name = "Arnab"
   val speed = 5.5573f
   println(f"$name%s can run at ${speed + 3}%2.2f m/sec")
   println(raw"$name%s can run at ${speed + 3}%2.2f m/sec")
   
   val num=10000
   
// Factorial function - highly inadvisable
   def Factorial(n:Int):BigInt = {
  	 var v:BigInt = 1	// var needs to be avoided in scala to make the program immutable
  	 var i:Int = 1
  	 while ( i <= n ){	// while loop should be avoided - this needs immutable variable
  		 v = v * i
  		 i += 1	 // this is an expression, not a statement which is not a good functional programming, it is open to the world for modification
  	 }
  	 v
   }
   
   println(s"Factorial of ${num} using loop "+Factorial(num))
    
 // Factorial - with recursion (problem of normal recursion is for big number it throws stack overflow error)
    def RecursionFactorial(n:Int):BigInt = {
      if ( n == 1) 1
      else n * RecursionFactorial(n-1)
    }
   
    	try{
    		println(s"Factorial of ${num} using recursion "+RecursionFactorial(num))
    	}
    catch{
    	case exception:Throwable => println("Exception")
    }
 
 // Factorial - with tail recursion (best way to implement loop in scala, functional programming)
    def TailFactorial(n:Int,r:BigInt=1):BigInt ={
      @tailrec
      def InnerFactorial(n:Int,r:BigInt=1):BigInt= {
        if (n==1) r
        else InnerFactorial(n-1,n*r)
      }
      InnerFactorial(n)
    }
    
    println(s"Factorial of ${num} using tail recursion "+TailFactorial(num))
    
  // Prime - with tail recursion
    def isPrime(n:Int):Boolean = {
      @tailrec
      def isPrimeTail(t:Int,isStillPrime:Boolean):Boolean = 
        if (!isStillPrime) false
        else if (t <= 1 ) true
        else isPrimeTail(t -1, n % t != 0 && isStillPrime)
        
      isPrimeTail (n /2, true)
    }
    
    println("Number 2737 is prime ? " +isPrime(2737))
}