// package lab2
//
// import com.cra.figaro.language.{Flip, Select, Dist}
// import com.cra.figaro.library.compound.If
// import com.cra.figaro.algorithm.factored.VariableElimination
// // import com.cra.figaro.library.atomic.continuous.Normal
//
// object HelloWorldFigaro
// {
//   	val sunnyToday = Flip(0.2)
//
//   	val greetingToday = If(sunnyToday,
// 			         	   Select(0.6 -> "Hello, world!", 0.4 -> "Howdy, universe!"),
// 				           Select(0.2 -> "Hello, world!", 0.8 -> "Oh no, not again"))
//
//   	val sideOfBed = Flip(0.5)
//   	val greetingBed = If(sideOfBed,
// 			             Select(0.6 -> "Hello, world!", 0.4 -> "Howdy, universe!"),
// 			             "Oh no, not again")
//
//   	val greeting = Select(greetingToday, greetingBed)
//
//   	val sunnyTomorrow = If(sunnyToday, Flip(0.8), Flip(0.05))
//
//   	val greetingTomorrow = If(sunnyTomorrow,
// 					          Select(0.5 -> "Hello, world!", 0.5 -> "Howdy, universe!"),
// 					          Select(0.1 -> "Hello, world!", 0.9 -> "Oh no, not again"))
//
//   	def predict()
//   	{
//     	val result = VariableElimination.probability(greetingToday, "Hello, world!")
//     	println("Today's greeting is \"Hello, world!\" " + "with probability " + result + ".")
//   	}
//
//   	def infer()
//   	{
// 	    greetingToday.observe("Oh no, not again")
// 	    val result = VariableElimination.probability(sunnyToday, true)
// 	    println("If today's greeting is \"Hello, world!\", today's " +
// 	            "weather is sunny with probability " + result + ".")
//   	}
//
//   	def learnAndPredict()
//   	{
// 	    val result = VariableElimination.probability(greetingTomorrow, "Hello, world!")
// 	    println("If today's greeting is \"Hello, world!\", " +
// 	            "tomorrow's greeting will be \"Hello, world!\" " +
// 	            "with probability " + result + ".")
//  	}
//
//   	def main(args: Array[String])
//   	{
// 	    predict()
// 	    infer()
// 	    learnAndPredict()
//   	}
// }
//
