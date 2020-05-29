/**
 * prefix, postfix & infix notation
 * unary operator overloading
 * apply method functionality
 */
package playground

 class Person (val name:String, favoriteMovie: String,age: Int=0){
    
    def likes(movie: String):Boolean = movie == favoriteMovie 
    // if movie parameter same as favoriteMovie then true else false
    
    // Unary operator
    def unary_! : String = s"$name, what's going on?" // overriding ! operator
    def +(title:String) : String = s"$name ( $title )" // overriding + operator
    def unary_+():String = s"$name with age incremented "+(this.age + 1) // overriding + operator
    
    def isAlive: Boolean = true
    
    def apply(): String = s"Hi, my name is $name and my favorite movie is $favoriteMovie" // overriding apply method
    def apply(count:Int): String=s"$name watch $favoriteMovie $count times" // overloading apply method
        
    def learns: String = s"$name learns scala"

  }

object MethodNotations {

  def main(args: Array[String]): Unit = {}
  
  val arnab = new Person("Arnab","Avengers",35) // new person instance named Arnab
  
  println(arnab.likes("Inception")) // calls like method which return boolean
  // infix notation = operator notation, it can be done if method takes single parameter
  println(arnab likes "Avengers") // syntactic sugar
  
  
  val papai=new Person("Papai","Titanic")
  
  //prefix notation - val x & val y are same
  val x = -1
  val y = 1.unary_-
  println(s"Val X = "+x+" ; Val Y = "+y)
  
  // unary prefix only works with - + ~ !
  println(!arnab) // this will call "unary_!" method
  println(arnab + "coder") // this calls "+(title:String)" method
  println(+arnab) // this calls "unary_+()" method
  
  // postfix notation - only available for method without parameter
  println(arnab isAlive)
  println(arnab learns)
  
  // apply method - special method
  println(arnab.apply())
  println(arnab()) // by default, it will call apply
  println(arnab(2))
  

}