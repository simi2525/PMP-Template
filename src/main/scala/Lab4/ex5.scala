package Lab4

import com.cra.figaro.language._
import com.cra.figaro.library.atomic.discrete.FromRange
import com.cra.figaro.algorithm.factored.VariableElimination

object Dice2
{
	def main(args: Array[String])
	{
		val die1 = FromRange(1, 7)
		val die2 = FromRange(1, 7)
		val sum = Apply(die1, die2, (die1: Int, die2: Int) => die1 + die2)
		sum.addCondition((sum: Int) => sum > 8)
		println(VariableElimination.probability(die1, 6))

		// val die1 = FromRange(1, 7)
		// val die2 = FromRange(1, 7)
		// val total = Apply(die1, die2, (i1: Int, i2: Int) => i1 + i2)
		// total.addCondition((i: Int) => i > 8)
		// println(VariableElimination.probability(die1, 6))
	}
}