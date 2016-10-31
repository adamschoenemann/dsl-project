// // (c) mdsebook, wasowski, tberger
// // An in-place transformation implemented directly in Scala (no special
// // frameworks).  Translates a finite state machine to a Petri net.  There is
// // presently no runner for this example.

// package mdsebook.fsm.scala.transforms

// import scala.collection.JavaConversions._
// import mdsebook.scala.EMFScala._
// import mdsebook.fsm
// import mdsebook.{ petrinet => pn }

// object FsmToPetriNet extends CopyingTrafo[fsm.Model, pn.Model] {

//   private val pFactory = pn.PetrinetFactory.eINSTANCE

//   // private def convertState (s: fsm.State): pn.Place = pFactory.createPlace before {
//     p => p setName s.getName
//          p setTokenNo 0 }

//   private def convertTransition (places: List[pn.Place]) (t: fsm.Transition): pn.Transition =
//     pFactory.createTransition before { pnt =>
//       pnt setInput t.getInput
//       pnt.getFromPlace addAll (places filter (_.getName == t.getSource.getName))
//       pnt.getToPlace   addAll (places filter (_.getName == t.getTarget.getName))
//     }

//   private def convertStateMachine (in: fsm.FiniteStateMachine): pn.PetriNet =
//     pFactory.createPetriNet before { pn =>
//       pn setName in.getName
//       val places = in.getStates.toList map convertState
//       pn.getPlaces addAll places
//       pn.getTransitions addAll (in.getStates
//         .flatMap (_.getLeavingTransitions) map (convertTransition (places)))

//       // add a token to the place created from initial state
//       places find (_.getName == in.getInitial.getName) foreach (_ setTokenNo 1)

//       // for each end state generate a transition that throws a token away
//       for (s <- fsmEndStates (in)) {
//         val Some (p) = places find (_.getName == s.getName)
//         pFactory.createTransition before { t =>
//           t.getFromPlace += p
//           t setInput ""
//           pn.getTransitions += t
//           p.getOutgoingTransitions += t }
//       }
//     }

//   override def run (in: fsm.Model): pn.Model =
//     pFactory.createModel before {
//       _.getPetrinets addAll (in.getMachines map convertStateMachine) }

//   private def fsmEndStates (m: fsm.FiniteStateMachine): List[fsm.State] =
//     m.getStates.toList filter (_.getLeavingTransitions.isEmpty)

// }
