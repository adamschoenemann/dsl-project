// package mdsebook.fsm.scala

// import scala.collection.JavaConversions._ // convert EList to scala.List
// import mdsebook.fsm


// object Interpreter {

//   def run (m :fsm.Model) :Unit = {
//     // only support a single machine at a time in this interpreter
//     assert (m.getMachines.size == 1)
//     step (m.getMachines.get(0).getInitial)
//   }

//   def step (s: fsm.State) :Unit =  {

//       val inputs = s.getLeavingTransitions map { _.getInput } mkString ", "
//       print (s"\nMachine is in state: ${s.getName}. Input [$inputs]? ")
//       val input = scala.io.StdIn.readLine

//       s.getLeavingTransitions.find { _.getInput == input } match {

//         case Some (t) =>
//           if (t.getOutput != null)
//             println (s"Machine outputs: ${t.getOutput}")
//           step (t.getTarget)

//         case None =>
//           println ("Invalid input!");
//           step (s)
//       }
//   }

// }
