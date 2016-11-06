// (c) mddbook, wasowski, tberger
// Tests for the EMFScala adapation code
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
import org.scalatest.FlatSpec
import org.scalatest.Matchers

import mdsebook.scala.EMFScala

import mdsebook.fsm
import mdsebook.{ petrinet => pn }

class FsmToPetriNetSpec extends FlatSpec with Matchers {

  // Initialize EMF

  Resource.Factory.Registry.INSTANCE.
    getExtensionToFactoryMap.put("xmi", new XMIResourceFactoryImpl)
  fsm.FsmPackage.eINSTANCE.eClass
	pn.PetrinetPackage.eINSTANCE.eClass
	
  // Set up fixtures. Note: imperative tests destroy fixtures
  
  val ids = List ("test-00", "test-01", "test-02", "test-03", "test-04", "test-05")
  val fnames = ids map (t => s"../mdsebook.fsm/test-files/$t.xmi")
  val roots :List[fsm.Model] = fnames map {EMFScala loadFromXMI[fsm.Model] _} 
  
  sealed case class Fixture (root :fsm.Model, id :String)

  def fixture (n: Int) = Fixture (
      root = EcoreUtil.copy(roots(n)).asInstanceOf[fsm.Model], // yuck
      id = ids(n) )

  // helper methods

  def validates (root: pn.Model): Boolean =
    Diagnostician.INSTANCE.validate (root).getSeverity == Diagnostic.OK

  // tests

  behavior of "FsmToPetriNet"

  it should s"results should always validate in the new metamodel" in {

    val out = List range (0,5) map fixture map { FsmToPetriNet run  _.root }
    out foreach { o => validates (o) shouldBe true }
  }
  
  it should s"save results of each transformations into new pn xmi format" in {
    
    val out = List range (0,5) map fixture map { f => f.id -> (FsmToPetriNet run  f.root) }
    out foreach { m => (EMFScala.saveAsXMI (s"test-out/${m._1}.pn.xmi") (m._2)) }
    
    // let's see whether they load without errors

    val reloaded = out map { m => EMFScala.loadFromXMI[pn.Model](s"test-out/${m._1}.pn.xmi") }
    reloaded foreach { m => validates (m) shouldBe true }
     
  }

}
