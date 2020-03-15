package scala

class basicLearn {
  
			def square(i:Int) = i * i
			def cube(i:Int) = i * i * i
			def double(i:Int) = i * 2
		
          def sum(func:Int => Int,lb:Int,ub:Int){
          var total=0
          for(element <- lb to ub){
            total += func(element)
          }
          print(total)
        }
 
    }