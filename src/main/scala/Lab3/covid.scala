package Lab3 

import com.cra.figaro.algorithm.factored.VariableElimination
import com.cra.figaro.language._
import com.cra.figaro.algorithm.sampling._
import com.cra.figaro.library.compound.CPD

object Ex1 {
	def main(args: Array[String]) {
		val febra = Flip(0.06)
		val tuse = Flip(0.04)
		val covid = CPD(febra, tuse,
			(true, true) -> Constant(true),
			(true, false) -> Flip(0.9),
			(false, true) -> Flip(0.5),
			(false, false) -> Flip(0.1))

		covid.observe(true)
		val alg = VariableElimination(febra, tuse)
		alg.start()
		alg.stop()
		println("probabilitatea pentru febra sau tuse " + alg.probability(febra, true))
		println("probabilitatea pentru febra sau tuse " + alg.probability(tuse, true))

		covid.unobserve()

		febra.observe(false)
		tuse.observe(false)
		val alg1 = VariableElimination(covid)
		alg1.start()
		alg1.stop()
		println("probabilitatea pentru febra sau tuse " + alg1.probability(covid, true))

	}
}