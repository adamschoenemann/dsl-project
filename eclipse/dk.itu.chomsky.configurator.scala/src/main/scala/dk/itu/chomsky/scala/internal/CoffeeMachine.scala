// // (c) mdsebook, wasowski, tberger
// // An example in the FSM language implemented as an internal DSL in Scala.

// package mdsebook.fsm.scala.internal
// import mdsebook.fsm.scala.internal.DSL._

// object CoffeeMachine {

//   val m = ( state machine "coffeeMachine"

//     initial "initial"
//       input "coin"    output "what drink do you want?"    and go to "selection"
//       input "idle"                                        and go to "initial"
//       input "break"   output "machine is broken"          and go to "deadlock"
//     end state

//     state "selection"
//       input "tea"     output "serving tea"                and go to "making tea"
//       input "coffee"  output "serving coffee"             and go to "making coffee"
//       input "timeout" output "coin returned; insert coin" and go to "initial"
//       input "break"   output "machine is broken!"         and go to "deadlock"
//     end state

//     state "making coffee"
//       input "done"    output "coffee served. Enjoy!"      and go to "initial"
//       input "break"   output "machine is broken!"         and go to "deadlock"
//     end state

//     state "making tea"
//       input "done"    output "tea served. Enjoy!"         and go to "initial"
//       input "break"   output "machine is broken!"         and go to "deadlock"
//     end state

//     state "deadlock"
//     end state

//   end machine )

// }
