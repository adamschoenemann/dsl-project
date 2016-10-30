// (c) mddbook, wasowski, tberger
// Run using 'sbt test'
package mdsebook.fsm.scala.transforms

import scala.collection.JavaConversions._

import org.eclipse.emf.common.util.Diagnostic
import org.eclipse.emf.common.util.URI
import org.eclipse.emf.ecore.resource.Resource
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl
import org.eclipse.emf.ecore.util.Diagnostician
import org.eclipse.emf.ecore.util.EcoreUtil
import org.eclipse.emf.ecore.xmi.impl.XMIResourceFactoryImpl
import org.scalatest.FreeSpec
import org.scalatest.Matchers
import java.io.PrintWriter
import mdsebook.scala.EMFScala._
import mdsebook.fsm

class FsmCodeGeneratorSpec extends FreeSpec with Matchers {

  fsm.FsmPackage.eINSTANCE.eClass
  val m :fsm.Model = loadFromXMI ("../mdsebook.fsm/test-files/CoffeeMachine.xmi")

  "FsmToJava" - {

    "just run the trafo for manual inspection"  in {
      val java = FsmCodeGenerator compileToJava m.getMachines.get(0)
      new PrintWriter("test-out/CoffeeMachine.java") { write(java); close }

      val dot = FsmCodeGenerator compileToDot m.getMachines.get(0)
      new PrintWriter("test-out/CoffeeMachine.dot") { write(dot); close }
    }

  }

}
