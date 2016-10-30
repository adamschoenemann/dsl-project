// // (c) mdsebook, wasowski, tberger

// package mdsebook.fsm.scala

// import scala.collection.JavaConversions._ // for natural access to EList
// import mdsebook.scala.EMFScala._
// import mdsebook.fsm._

// object Constraints {

//   // There must be a loop transition labeled idle for each state
//   // (this one is kept separate, o we can use it in testing trafos)

//   val idle = inv[State] { self =>
//       self.getLeavingTransitions.exists { t =>
//         t.getInput == "idle" && t.getTarget == self }
//     }

//   val invariants: List[Constraint] = List (

//     inv[FiniteStateMachine] { self => self.getStates.contains (self.getInitial) },

//     // Name cannot be empty for any named element.
//     // It is already not null by meta-model constraints

//     inv[NamedElement] { !_.getName.isEmpty },

//     // The state machine is deterministic, so in each state each outgoing
//     // transition has a different label (not very efficient but good enough for a
//     // small example).
//     //
//     // We are using the "implies" operator provided by EMFScala

//     inv[State] { self =>
//       self.getLeavingTransitions.forall { t1 =>
//         self.getLeavingTransitions.forall { t2 =>
//           t1!=t2  implies  t1.getInput!=t2.getInput
//         }
//       }
//     },

//     idle, //include the idle constraint

//     // For each transition, target and source states are in the same state machine

//     inv[Transition] { self =>
//       self.getSource.getMachine == self.getTarget.getMachine
//     },

//     // Evaluation version: maximum 40 states in the model
//     // No sharing of states is guaranteed by containment

//     inv[Model] { self =>
//       self.getMachines.foldLeft(0) { (sum,m) => sum + m.getStates.size } <= 40
//     }

//   )

// }
