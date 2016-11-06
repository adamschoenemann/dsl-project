// (c) mddbook, wasowski, tberger
// Tests for the EMFScala adapation code
// Run using 'sbt test'

package mdsebook.fsm.scala.transforms

import scala.collection.JavaConversions._
import mdsebook.fsm.FsmPackage
import mdsebook.fsm.Model
import mdsebook.scala.EMFScala._
import org.eclipse.emf.common.util.Diagnostic
import org.eclipse.emf.common.util.URI
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl
import org.eclipse.emf.ecore.resource.Resource
import org.eclipse.emf.ecore.util.Diagnostician
import org.eclipse.emf.ecore.util.EcoreUtil
import org.eclipse.emf.ecore.xmi.impl.XMIResourceFactoryImpl
import org.scalatest.FlatSpec
import org.scalatest.Matchers
import mdsebook.fsm.scala.Constraints

class AddIdleLoopsSpec extends FlatSpec with Matchers {

  // Initialize EMF

  Resource.Factory.Registry.INSTANCE.
    getExtensionToFactoryMap.put("xmi", new XMIResourceFactoryImpl)
  FsmPackage.eINSTANCE.eClass

  // Set up fixtures. Note: imperative tests destroy fixtures

  val ids = List ("test-00", "test-01", "test-02", "test-03", "test-04", "test-05")
  val uri = ids.map ( t => URI.createURI (s"../mdsebook.fsm/test-files/$t.xmi"))
  val res = uri.map { (new ResourceSetImpl).getResource (_, true) }
  val roots :List[Model] = res.map { _.getContents()(0).asInstanceOf[Model] }

  sealed case class Fixture (root :Model, id :String)
  def fixture (n: Int) = Fixture (
      root = EcoreUtil.copy(roots(n)).asInstanceOf[Model], // yuck
      id = ids(n) )

  // helper methods

  def hasLoops (root: Model) :Boolean =
    EcoreUtil.getAllContents (root,false).forall ( Constraints.idle.check _ )

  def validates (root: Model) :Boolean =
    Diagnostician.INSTANCE.validate (root).getSeverity == Diagnostic.OK

  // tests

  behavior of "AddIdleLoops"

  it should s"add a loop on a single state ${ids(0)}" in {

    val f = fixture (0)

    assert (validates(f.root))
    assert (!hasLoops(f.root))

    AddIdleLoops.run (f.root)

    assert (validates(f.root))
    assert (hasLoops(f.root))

  }

  it should "not add an idle transition if one exists" in {

    val f = fixture (2)
    val size = EcoreUtil.getAllContents (f.root,false).size

    assert (validates(f.root))
    assert (hasLoops(f.root))

    AddIdleLoops.run (f.root)

    assert (validates(f.root))
    assert (hasLoops(f.root))
    EcoreUtil.getAllContents (f.root,false).size shouldBe size

  }


  it should "add idle on more than one state" in {

    val f = fixture (3)
    assert (validates(f.root) && !hasLoops(f.root))
    assert (f.root.getMachines()(0).getStates()(0).getLeavingTransitions().isEmpty)
    assert (f.root.getMachines()(1).getStates()(0).getLeavingTransitions().isEmpty)
    assert (f.root.getMachines()(1).getStates()(1).getLeavingTransitions().isEmpty)

    AddIdleLoops.run (f.root)

    assert (validates(f.root) && hasLoops(f.root))
    assert (f.root.getMachines()(0).getStates()(0).getLeavingTransitions()(0).getInput == "idle")
    assert (f.root.getMachines()(1).getStates()(0).getLeavingTransitions()(0).getInput == "idle")
    assert (f.root.getMachines()(1).getStates()(1).getLeavingTransitions()(0).getInput == "idle")

  }

  it should "not crash on an empty model" in {

    val f = fixture (4)
    assert (validates(f.root))
    AddIdleLoops.run (f.root)
    EcoreUtil.getAllContents(f.root, false).size shouldBe 0

  }

  it should "run on a maximal model (mm-coverage)" in {

    val f = fixture (5)
    assert (validates(f.root))
    assert (!hasLoops(f.root))
    AddIdleLoops.run (f.root)
    assert (validates(f.root))
    assert (hasLoops(f.root))
  }



}
