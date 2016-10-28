// (c) mdsebook, wasowski, tberger
// Use an ADT instead of a meta-model/Ecore
package mdsebook.fsm.scala.adt

object Pure {

  // A pure variant, for pure functional programming, (almost) Haskell style.
  // This is fairly easy to construct with parser.

  sealed abstract trait ModelElement

  abstract trait NamedElement {
    val name :String
  }

  case class Model (name :String, machines :List[FiniteStateMachine])
    extends NamedElement with ModelElement

  case class FiniteStateMachine (
    name :String,
    states: List[String],
    transitions: Map[String,List[Transition]],
    initial: String
  ) extends NamedElement with ModelElement

  case class Transition (target: String, input: String, output: String=null)
    extends ModelElement

}
