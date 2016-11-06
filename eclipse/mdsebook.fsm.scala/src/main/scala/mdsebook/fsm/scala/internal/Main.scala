// (c) mddbook, wasowski, tberger
// Executor for the FSM interpreter
// Run using 'sbt run' and select mdsebook.fsm.scala.internal.Main as the
// main class
package mdsebook.fsm.scala.internal

object Main extends App {
  mdsebook.fsm.scala.Interpreter.run (CoffeeMachine.m)
}
