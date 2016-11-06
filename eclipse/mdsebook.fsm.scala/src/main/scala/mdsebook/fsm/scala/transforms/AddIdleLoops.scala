// (c) mdsebook, wasowski, tberger
// There is presently no runner for this example, but there is a test suite that
// runs the transformations (TransformationsSpec.scala)

package mdsebook.fsm.scala.transforms

import scala.collection.JavaConversions.asScalaBuffer

import mdsebook.fsm
import mdsebook.scala.EMFScala._

// This example is implemented as an in-place transformation directly in Scala
// (no special tools or frameworks).  It adds an idle transition to every state
// it sees.  It uses straightforward imperative programming style, which is
// quite typical of imperative transformation languages.

object AddIdleLoops extends InPlaceTrafo[fsm.Model] {

  import fsm._

  def hasIdle(s: State): Boolean =
    s.getLeavingTransitions.exists { _.getInput == "idle" }

  def addIdle(s: State): Unit = {
    var t = FsmFactory.eINSTANCE.createTransition
    t.setInput("idle")
    t.setTarget(s)
    s.getLeavingTransitions.add(t)
  }

  override def run(M: Model): Unit =
    for (m <- M.getMachines)
      for (s <- m.getStates)
        if (!hasIdle(s)) addIdle(s)

}





