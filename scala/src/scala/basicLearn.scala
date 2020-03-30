package scala

class basicLearn {
 // def - to create function definition 
			def square(i:Int) = i * i;
			def cube(i:Int) = i * i * i;
			def double(i:Int) = i * 2;
// 1st parameter of this function is function		
          def sum(func:Int => Int,lb:Int,ub:Int){
          var total=0;
          for(element <- lb to ub){
            total += func(element);
          }
          print(total)
        }
 
    }