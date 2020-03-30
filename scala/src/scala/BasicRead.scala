package scala;
import scala.io.Source;

class BasicRead {
  def readFile{
	val orderItems = Source.fromFile("/Users/arnab/data/retail_db/order_items/part-00001");
	orderItems.take(10).foreach(print)
  }
}