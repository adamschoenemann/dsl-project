// // (c) mdsebook, wasowski, tberger
// // The FSM language implemented as an internal DSL in Scala.
// // Only one machine per model, for simplicity.

// package mdsebook.fsm.scala.internal

// object DSL {

//   import scala.collection.JavaConversions._ // for natural access to EList
//   import mdsebook.scala.EMFScala._
//   import mdsebook.fsm._
//   import mdsebook._

//   // Very simple AST algebraic data types (ADT) for internal representation of
//   // the parsed model in Scala. In the last phase of execution we will transform
//   // this to EMF types, so that we gain compatibility with other possible parts
//   // of the tool chain that may be implemented following the external DSL route.

//   sealed case class ModelRep (

//     model:  String,
//     states: List[StateRep] = Nil,
//     tran:   List[TranRep] = Nil,
//     initial: Option[StateRep] = None
//   )

//   sealed case class TranRep (

//     source: StateRep,
//     input:  Option[String] = None,
//     output: Option[String] = None,
//     target: Option[StateRep] = None
//   )

//   type StateRep = String


//   case class EXPECT_INPUT_OR_END (m: ModelRep, s: StateRep) {
//     def input (input: String) :EXPECT_OUTPUT_OR_GO =
//       EXPECT_OUTPUT_OR_GO (m, s, TranRep (source = s, input = Some (input)))
//     def end (state :_STATE) = EXPECT_INITIAL_OR_STATE_OR_END (m)
//   }

//   case class EXPECT_OUTPUT_OR_GO (m: ModelRep, s: StateRep, t: TranRep) {
//     def output (output: String) : EXPECT_AND = EXPECT_AND (m, s, t.copy (output = Some(output)))
//     def and (go :_GO) = EXPECT_TO (m,s,t)
//   }

//   abstract sealed trait _GO
//   case object go extends _GO

//   case class EXPECT_AND (m: ModelRep, s: StateRep, t: TranRep) {
//     def and (go :_GO) = EXPECT_TO (m, s, t)
//   }

//   case class EXPECT_TO (m: ModelRep, s: StateRep, t: TranRep) {
//     def to (name: StateRep) :EXPECT_INPUT_OR_END = {
//       val t1 = t.copy (target = Some(name))
//       val m1 = m.copy (tran = t1::m.tran)
//       EXPECT_INPUT_OR_END (m1, s)
//     }
//   }

//   sealed trait _STATE
//   case object state extends _STATE {
//     def machine (name: String) :EXPECT_INITIAL_OR_STATE_OR_END =
//       EXPECT_INITIAL_OR_STATE_OR_END (ModelRep (name))
//   }

//   sealed trait _MACHINE
//   case object machine extends _MACHINE

//   case class EXPECT_INITIAL_OR_STATE_OR_END (m: ModelRep) {

//     def end (machine :_MACHINE) : fsm.Model = modelRep2Model (m)

//     def initial (s: StateRep) : EXPECT_INPUT_OR_END =
//       EXPECT_INPUT_OR_END (m.copy (initial = Some (s), states = s ::m.states), s)

//     def state (s: StateRep) : EXPECT_INPUT_OR_END =
//       EXPECT_INPUT_OR_END (m.copy (states = s ::m.states ), s)
//   }

//   // A transformation from our ADT representation to Ecore FSM instance

//   private def modelRep2Model (m: ModelRep) : fsm.Model = {

//     val s2tMap = m.tran.map { t => t.source -> t }.toMap

//     def stateRep2State (s: StateRep) : fsm.State = {
//       val S = FsmFactory.eINSTANCE.createState
//       S.setName (s)
//       S
//     }

//     val SS = m.states.map (s => s -> stateRep2State (s)).toMap

//     def tranRep2Transition (t: TranRep) : fsm.Transition = {
//       val T = FsmFactory.eINSTANCE.createTransition
//       t.input.foreach  { T setInput  (_) }
//       t.output.foreach { T.setOutput (_) }
//       t.target.foreach { s => T.setTarget (SS (s)) }
//       T
//     }

//     m.tran.foreach { (t: TranRep) =>
//       SS(t.source).getLeavingTransitions.add (tranRep2Transition (t)) }

//     val M = FsmFactory.eINSTANCE.createModel
//     M.setName (m.model)
//     val FSM = FsmFactory.eINSTANCE.createFiniteStateMachine
//     M.getMachines.add (FSM)
//     FSM.getStates.addAll (SS.values)
//     m.initial.foreach { s => FSM.setInitial (SS(s)) }
//     M
//   }

// }
