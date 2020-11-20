package Lab4

import com.cra.figaro.language._
import com.cra.figaro.algorithm.sampling._
import com.cra.figaro.algorithm.factored._
import com.cra.figaro.library.compound._

object Exercitiul1 {
	val sunnyToday = Flip(0.2)
	
	val greetingToday = If(sunnyToday,
		Select(0.6 -> "Hello, world!", 0.4 -> "Howdy, universe!"),
		Select(0.2 -> "Hello, world!", 0.8 -> "Oh no, not again!"))

//	val sunnyTomorrow = If(sunnyToday, Flip(0.8), Flip(0.05))
//
//	val greetingTomorrow = If(sunnyTomorrow,
//		Select(0.6 -> "Hello, world!", 0.4 -> "Howdy, universe!"),
//		Select(0.2 -> "Hello, world!", 0.8 -> "Oh no, not again"))

	val bedSide = Flip(0.4)
	val greeting = Chain(bedSide, (side: Boolean) =>
                  if(!side)
                        {Constant("Oh no, not again!")}
             			else
                  	    greetingToday

              // if(sunny)
              //           { Select(0.6 -> "Hello, world!", 0.4 -> "Howdy, universe!")}
              //     else
              //           {Select(0.2 -> "Hello, world!", 0.8 -> "Oh no, not again")}
                                
      )
	

def main(args: Array[String])
{
	val result = VariableElimination.probability(greeting, "Oh no, not again!")
    println("Today’s greeting Hello, world " + result)

	greeting.observe("Oh no, not again!")
	println(VariableElimination.probability(sunnyToday, true))
}

}
//
//Atomic elements:
//Flip
//Select
//
//Compound elements:
//If
//
//Dependinte intre elemente
//Apply
//Chain
