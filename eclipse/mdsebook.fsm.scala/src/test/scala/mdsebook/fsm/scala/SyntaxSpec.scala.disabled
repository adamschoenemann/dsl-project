// (c) mddbook, wasowski, tberger
// Run using 'sbt test'

package mdsebook.fsm.scala.syntax

import java.io.FileReader

import mdsebook.fsm.scala.adt.Pure._
import org.scalatest.FlatSpec
import org.scalatest.Matchers


class SyntaxSpec extends FlatSpec with Matchers {
  behavior of "PackRat parser"

  it should "Parse the CoffeeMachine example" in {

    val fname  = "../mdsebook.fsm/test-files/CoffeeMachine.fsm"
    val parser = new FsmPureASTParser
    val reader = new FileReader (fname)
    val result = parser.parseAll[Model] (parser.modelParser (fname), reader)

    result match {

      case parser.Success (ast,_) =>

        ast.name shouldBe fname

        ast.machines.size shouldBe 1
        val m = ast.machines(0)
        m.name shouldBe "CoffeeMachine"

        m.states.size shouldBe 5
        m.states.toSet should
          equal (Set("initial", "brewingTea", "brewingCoffee", "broken", "selection"))

        m.transitions("selection").size shouldBe 4
        m.transitions("brewingCoffee").size shouldBe 2
        m.transitions("broken").size shouldBe 0

        val ts :List[Transition] = m.transitions("initial")
        ts.map (t => t.target).toSet should
          equal (Set( "selection", "broken"))

      case _ =>
        info (result.toString)
        fail (s"Parsing $fname failed!")
    }
  }

}
