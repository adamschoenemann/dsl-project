// // (c) mdsebook, wasowski, tberger
// // Use an ADT instead of a meta-model/Ecore
// package mdsebook.fsm.scala.adt

// object Impure {

//   // An impure implementation with case classes, Java style.
//   sealed abstract trait ModelElement

//   abstract trait NamedElement {
//     val name :String
//   }

//   case class Model (name :String, machines :List[FiniteStateMachine])
//     extends NamedElement with ModelElement

//   case class FiniteStateMachine (
//     name :String,
//     states: List[State],
//     initial: State
//   ) extends NamedElement with ModelElement

//   case class State (name :String, var leavingTransitions: List[Transition])
//     extends NamedElement with ModelElement

//   case class Transition (
//     target: State,
//     source: State,
//     input: String,
//     output: String=null
//   ) extends ModelElement

// }




