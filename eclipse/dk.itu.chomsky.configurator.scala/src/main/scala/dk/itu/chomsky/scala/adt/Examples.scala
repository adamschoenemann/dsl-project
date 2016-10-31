// // (c) mdsebook, wasowski, tberger
// // Demonstrate instantiation for the ADT
// // The object correspond to test case files (instances) for the EMF model

// package mdsebook.fsm.scala.adt

// object Test_00 {

//   import Impure._

//   val a = State ("a", List())
//   val SingleMachine = FiniteStateMachine ("SingleMachine", List(a), a)
//   val test_00 = Model ("test-00", List(SingleMachine))

// }


// object Test_01 {

//   import Impure._

//   val a = State ("a", List())
//   val machine_1 = FiniteStateMachine ("machine_1", List(a), a)

//   val b = State ("b", List())
//   val machine_2 = FiniteStateMachine ("machine_2", List(b), b)

//   val test_01 = Model ("test-01", List(machine_1, machine_2))

// }


// object Test_02 {

//   import Impure._

//   val a = State ("a", null)
//   val c = State ("c", null)
//   val machine_1 = FiniteStateMachine ("machine_1", List(a,c), a)

//   val transition_1 = Transition (input="1", output="o!", source=a, target=a)
//   val transition_2 = Transition (input="2", output="q!", source=a, target=c)
//   val transition_3 = Transition (input="3", output="r!", source=a, target=a)
//   val transition_idle = Transition (input="idle", source=a, target=a)

//   a.leavingTransitions = List(transition_1,transition_2)

//   val b = State ("b", List())
//   val machine_2 = FiniteStateMachine ("machine_2", List(b), b)


//   val test_02 = Model ("test-01", List(machine_1, machine_2))

// }


// object Test_02_Pure {

//   import Pure._

//   val a = "a"
//   val c = "c"
//   val transitions_1 = Map(
//       a -> List(
//         Transition (input="1", output="o!", target=a),
//         Transition (input="2", output="q!", target=c),
//         Transition (input="3", output="r!", target=a),
//         Transition (input="idle", target=a)
//       )
//     )
//   val machine_1 = FiniteStateMachine ("machine 1", List(a,c), transitions_1, a)


//   val b = "b"
//   val transitions_2 = Map ( b -> List ( Transition (b, "idle", null)))
//   val machine_2 = FiniteStateMachine ("machine_2", List(b), transitions_2, b)


//   val test_02 = Model ("test-02-pure", List(machine_1, machine_2))
// }
