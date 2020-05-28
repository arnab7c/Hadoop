/**
 *
 */
package playground

/**
 * @author arnab
 *
 */

// class Rational (val l:Int, val d:Int) // no body, completely valid

class Rational private ( val n:Int, val d:Int ){ // "to make class private - use keyword after class name"
  
  require(this.d !=0,"Zero Denominatior")	// require ensure the validation & fail code before execution
 
  override def toString:String = s"R($n/$d)" // overriding toString method

  // + -> infix overriding
  def +(other:Rational): Rational = new Rational(
		  this.n * other.d + this.d * other.n, this.d * other.d
  )
  
  // Auxiliary constructors are quite limited, they can only call another constructor
  // Better alternative is to use "factory methods" - what is this?
  
  def this(i:Int) = this(i,1) // Auxiliary Constructor
  def +(i:Int): Rational = this + Rational(i) // overloading 
  // if implicit definition is available, + overloading isn't required
  // Rational(1,5) + 5  => Rational(1,5) + Rational(5) -> normal + [infix overriding will solve the problem]
  
}

object Rational {
  /*
   * An object in the same source file with the same name as the class (or trait) - companion object
   * Shares private state and behavior with the class (and vice versa)
   * Scala's alternative to static method
   * Factory methods and private constructors are idiomatic
   */
	def main(args: Array[String]): Unit = {}
	
	// Scala's alternative to static, a good place for factory methods
  
  def apply( n:Int, d:Int ): Rational = new Rational(n,d)
  
  // implicit will help scala to rewrite code if specific method isn't available
  implicit def apply(i:Int): Rational = new Rational(i,1) 
	

	val fifth = new Rational(1,5) // if new is provided, it refers auxiliary constructors
	val five = new Rational(5) // it can still access though the companion class is private
	val six = Rational(6)
	val half = Rational(1,2) // no need for new for companion object reference
	
	/*
	 * half + fifth
	 * half -> new Rational(1,2) returns R(1/2)
	 * + -> half.+(1/5 [other]) => 1 * 5 + 2 * 1, 2 * 5
	 * fifth -> new Rational(1,5) return R(1/5)
	 * 
	 */
	
	println(five + fifth) // this is referring Rational class & auxiliary constructor
	println( six + half) // this is referring companion object
	println( Rational(1,5) + 5 ) // overloading will help here
	println( 5 + Rational(1,5) ) // use implicit - this will rewrite code as Rational(5) + Rational(1,5)
	
}