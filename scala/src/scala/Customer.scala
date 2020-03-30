/**
 *
 */
package scala
import scala.io.Source;

/**
 * @author Arnab.Linux@gmail.com
 * @Problem 
 * 1.Fetch list of unique states from where customer belong
 * 2.Fetch number of customer from each state in chronological order
 * 3.Fetch total number of customer  
 */
class Customer {
  // Name & path of source file
  val f_name="/Users/arnab/data/retail_db/customers/part-00000"
  
  def customerOperation{
    // read data from file & store as list
    	val customerInfo=Source.fromFile(f_name).getLines.toList	
    	
 // get list of distinct States from where Customer came
    	// split file , separator and take data where 7th position is not null
    	val stateInfo=customerInfo.filter( stateItem => stateItem.split(",")(7) != null)
    	val stateList=stateInfo.map(state => state.split(",")(7)).toSet.toSeq.sorted
    	System.out.println("Number of state : "+stateList.count((c) => c !=null))
    	stateList.foreach((s) => System.out.print(s+" "))
    	System.out.println("\n");
    	
 // get the number of customer from each state
    	val stateOccurance=stateInfo.map(state => state.split(",")(7))
    	val result=stateOccurance.groupBy(identity).mapValues(_.size)
    	System.out.println("Number of customer from each state : ")
    	result.foreach((s) => System.out.println("\t"+s._1+"->"+s._2))
    	
 // get total number of customer
    	System.out.println("Number of total customer : "+customerInfo.size)
  }

}