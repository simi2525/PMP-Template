// In Monopoly, doubles happen when you roll two fair six-sided dice and both
// dice show the same number. If you roll three doubles in a row, you go to jail.
// Write a Figaro program to compute the probability that this will happen to you
// on any given turn.

package Lab4

import com.cra.figaro.language._
import com.cra.figaro.library.atomic.discrete.FromRange
import com.cra.figaro.algorithm.factored.VariableElimination

object Dice3
{
	def main(args: Array[String])
	{
		val die1 = FromRange(1, 7)
		val die2 = FromRange(1, 7)
		val die3 = FromRange(1, 7)
		val die4 = FromRange(1, 7)
		val die5 = FromRange(1, 7)
		val die6 = FromRange(1, 7)
		val equal1 = Apply(die1, die2, (die1: Int, die2: Int) => die1 == die2)
		val equal2 = Apply(die3, die4, (die3: Int, die4: Int) => die3 == die4)
		val equal3 = Apply(die5, die6, (die5: Int, die6: Int) => die5 == die6)

		val doubles = Apply(die1, die3, die5, (d1: Int, d2: Int, d3: Int) => (d1, d2, d3))
		doubles.addCondition((doubles: (Int, Int, Int)) => doubles._1 != doubles._2 && doubles._2 != doubles._3 && doubles._1 != doubles._3)

		val jail = Apply(equal1, equal2, equal3, (e1: Boolean, e2: Boolean, e3: Boolean) => e1 && e2 && e3)
		println(VariableElimination.probability(jail, true))


		// def doubles =
		// {
		// 	val die1 = FromRange(1, 7)
		// 	val die2 = FromRange(1, 7)
		// 	die1 === die2
		// }
		// val jail = doubles && doubles && doubles
		// println(VariableElimination.probability(jail, true))

	}
}