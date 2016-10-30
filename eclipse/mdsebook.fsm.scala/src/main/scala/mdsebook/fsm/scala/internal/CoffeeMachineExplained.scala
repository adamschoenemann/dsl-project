// (c) mdsebook, wasowski, tberger
package mdsebook.fsm.scala.internal

import mdsebook.fsm
import mdsebook.fsm.scala.internal.DSL._

object CoffeeMachineExplained {

  // The following partial expressions of the above example explain how this is
  // built (See also internal.scala).  t4 (below) is also written following Java
  // syntactic convention with parentheses and navigation, to give you an idea
  // how the compiler sees this model.
  //
  // The type of a partial term, is named after the possible next language
  // elements

  val t1: EXPECT_INITIAL_OR_STATE_OR_END =
      state machine "coffeeMachine"

  val t2: fsm.Model =
    ( state machine "coffeMachine"
      end machine )

  val t3: EXPECT_INPUT_OR_END = (
    state machine "coffeeMachine"
      initial "initial"
  )

  val t4 :fsm.Model = (
    state machine "coffeeMachine"
      state "initial"
      end state
    end machine
  )

  // the above example made more explicit syntactically
  val t4withDots =
    state.machine ("coffeeMachine").state ("initial").end (state). end (machine)

  /***
   * Notes for the above
   *
   * - state (first ocurence) is an object in mdsebook.fsm.scala.internal
   *   machine is a unary method taking a string
   * - state (second occurence) is a unary method taking a string.  It is a
   *   method of the type produce by machine
   * - end is a unary method taking a single object parameter.
   * - state (the third occurence) is a singleton object (actually the same
   *   object as in the first occurence)
   * - end is a unary method taking a single object parameter (a different but
   *   similar to the method providing the other end keyword).
   * - machine (the last occurence) is a singleton object serving the role of a
   *   keyword in the internalDSL
   */

  /* We could write it like that also, even with dots, so that it appears more
   * DSLish (Common style in Java and C#) :
   **/

  val t4laidOut =
    state .machine ("coffeeMachine")
      .state ("initial")
      .end (state)

  /**
   * Although in a language where dots and parentheses are unavoidable, we would
   * likely prefer to code the last state as a nullary method or a field
   * obtaining something similar to:
   *
   * state .machine ("coffeeMachine")
   *   .state ("initial")
   * .end .state
   */

  val t5 :EXPECT_OUTPUT_OR_GO = (
    state machine "coffeeMachine"
      initial "initial"
        input "coin"
  )

  val t6 :EXPECT_AND = (
    state machine "coffeeMachine"
      initial "initial"
        input "coin" output "what drink do you want?"
  )

  val t7 :EXPECT_TO = (
    state machine "coffeeMachine"
      initial "initial"
        input "coin" output "what drink do you want?" and go
  )

  val t8 :EXPECT_INPUT_OR_END = (
    state machine "coffeeMachine"
      initial "initial"
        input "coin"output "what drink do you want?" and go to "selection"
  )

  val t9 :EXPECT_OUTPUT_OR_GO = (
    state machine "coffeeMachine"
      initial "initial"
        input "coin"  output "what drink do you want?" and go to "selection"
        input "break"
  )

  val t10 :EXPECT_AND = (
    state machine "coffeeMachine"
      initial "initial"
        input "coin"  output "what drink do you want?" and go to "selection"
        input "break" output "machine is broken"
  )

  val t11 :EXPECT_INPUT_OR_END = (
    state machine "coffeeMachine"
      initial "initial"
        input "coin"  output "what drink do you want?" and go to "selection"
        input "break" output "machine is broken"       and go to  "broken"
  )

  val t12 :EXPECT_INITIAL_OR_STATE_OR_END = (
    state machine "coffeeMachine"
      initial "initial"
        input "coin"  output "what drink do you want?" and go to "selection"
        input "break" output "machine is broken"       and go to  "broken"
      end state
  )

  val t13 :fsm.Model = (

    state machine "coffeeMachine"

      initial "initial"
        input "coin"  output "what drink do you want?" and go to "selection"
        input "break" output "machine is broken"       and go to "broken"
      end state

    end machine
  )

  val t15 =
  ( state machine "coffeeMachine"

      initial "initial"
        input "coin"  output "what drink do you want?" and go to "selection"
        input "break" output "machine is broken"       and go to  "broken"
      end state

      state "initial"
  )

  val t16: fsm.Model =
  ( state machine "coffeeMachine"

      initial "initial"
        input "coin"  output "what drink do you want?" and go to "selection"
        input "break" output "machine is broken"       and go to  "broken"
      end state

      state "selection"
        input "tea"     output "serving tea"                and go to "making tea"
        input "coffee"  output "serving coffee"             and go to "making coffee"
        input "timeout" output "coin returned; insert coin" and go to "initial"
        input "break"   output "machine is broken!"         and go to "broken"
      end state

  end machine )

}
