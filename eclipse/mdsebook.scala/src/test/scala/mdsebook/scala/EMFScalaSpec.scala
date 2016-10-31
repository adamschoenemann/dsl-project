// (c) mddbook, wasowski, tberger
// Tests for the EMFScala adapation code
// Run using 'sbt test'
package mdsebook.scala

import EMFScala._
import mdsebook.fsm.FiniteStateMachine
import mdsebook.fsm.FsmFactory
import mdsebook.fsm.FsmPackage
import mdsebook.fsm.NamedElement
import mdsebook.fsm.State
import org.eclipse.emf.common.util.URI
import org.eclipse.emf.ecore.EObject
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl
import org.eclipse.emf.ecore.resource.Resource
import org.eclipse.emf.ecore.util.EcoreUtil
import org.eclipse.emf.ecore.xmi.impl.XMIResourceFactoryImpl
import org.scalatest.FlatSpec
import org.scalatest.Matchers


class EMFScalaSpec extends FlatSpec with Matchers {


  behavior of "instanceOf"

  // fixture

  trait Alpha
  class A
  class AAlpha extends A with Alpha
  class B extends A
  class BAlpha extends AAlpha
  class C extends B
  class CAlpha extends BAlpha
  object Bobject extends BAlpha {}
  val iA = new A
  val iAAlpha = new AAlpha
  val iBAlpha = new BAlpha
  val iB = new B

  it should "filter direct instances and instances of subclasses" in {

    // first some sanity checks using a similar machinery of scalatest

    iA shouldBe an [A]
    iB shouldBe  a [B]
    iB shouldBe an [A]
    iB should not be a [C]
    iA should not be a [B]

    iAAlpha shouldBe an [Alpha]
    iAAlpha shouldBe an [A]
    iBAlpha shouldBe an [Alpha]

    iAAlpha should not be an [BAlpha]
    Bobject shouldBe a [BAlpha]
    Bobject should not be a [CAlpha]

    // now testing this with our simple API

    assert ( instanceOf[A](iA))
    assert ( instanceOf[B](iB))
    assert ( instanceOf[A](iB))
    assert (!instanceOf[C](iB))
    assert (!instanceOf[B](iA))

    assert ( instanceOf[Alpha](iAAlpha))
    assert ( instanceOf[A](iAAlpha))
    assert ( instanceOf[Alpha](iBAlpha))

    assert (!instanceOf[BAlpha](iAAlpha))
    assert ( instanceOf[BAlpha](Bobject))
    assert (!instanceOf[CAlpha](Bobject))
  }


  behavior of "Inv"

  // initialize the fixture files

  Resource.Factory.Registry.INSTANCE.
    getExtensionToFactoryMap.put("xmi", new XMIResourceFactoryImpl)

  // initialize the package (a standard hack)
  FsmPackage.eINSTANCE.eClass

  val fnas = List[String] ( "../mdsebook.fsm/test-files/test-00.xmi",
                            "../mdsebook.fsm/test-files/test-01.xmi",
                            "../mdsebook.fsm/test-files/test-02.xmi"  )

  val uri :List[URI] = fnas.map (URI.createURI _)
  val res = uri.map { new ResourceSetImpl().getResource (_, true) }
  val con = res.map { EcoreUtil.getAllProperContents[EObject] (_, false) }

  val factory = FsmFactory.eINSTANCE
  val emptyFSM : FiniteStateMachine = factory.createFiniteStateMachine

  // now cons should contain all the contents of all the test cases

  it should "type-check and compile" in {
    inv[FiniteStateMachine] { _ => true } // !_.getName.isEmpty }
  }

  it should "properly catch empty and null names" in {

    val c = inv[FiniteStateMachine]
    { m => m.getName != null && !m.getName.isEmpty }

    // I assert for each of the files separately for better error reporting

    assert ( con(0).forall { eo => c.check (eo) } )
    assert ( con(1).forall { eo => c.check (eo) } )
    assert ( con(2).forall { eo => c.check (eo) } )

    // we also need a failing test-case and so we have it

    assert ( !c.check (emptyFSM) )
    emptyFSM.setName ("")
    assert ( !c.check (emptyFSM) )
    emptyFSM.setName ("Test")
    assert ( c.check (emptyFSM) )

  }

  behavior of "Conjoined constraints"

  def valid[T] :T => Boolean = _ => true
  def incon[T] :T => Boolean = _ => false

  it should "type-check and compile (invariant)" in {

    inv[FiniteStateMachine] (valid) &&
    inv[FiniteStateMachine] (incon) check
    emptyFSM shouldBe false

  }

  it should "type-check and compile (covariant check)" in {

    inv[NamedElement] (valid) check emptyFSM shouldBe true
    inv[NamedElement] (incon) check emptyFSM shouldBe false

  }

  it should "type-check and compile (conjunction of constraints)" in {

    // tests along the inheritance hierarchy
    val i1: Inv[FiniteStateMachine] =
        inv[NamedElement] (valid) && inv[FiniteStateMachine] (valid)
    val i2: Inv[FiniteStateMachine] =
        inv[FiniteStateMachine] (valid) && inv[NamedElement] (valid)
    val i3: Inv[FiniteStateMachine] =
        inv[FiniteStateMachine] (incon) && inv[NamedElement] (valid)

    i1 check emptyFSM shouldBe true
    i2 check emptyFSM shouldBe true
    i3 check emptyFSM shouldBe false

    // A test across the inheritance hierarchy.  This is a bit strange.  It
    // remains to be checked how it would work with multiple inheritance in
    // Ecore. Created an issue about that
    inv[FiniteStateMachine] (valid) && inv[State] (valid)

  }

  it should "be contravariant: allow down-cast only to narrower contexts" in {

    // invariant:
    val i1 = inv[FiniteStateMachine] (valid) : Inv[FiniteStateMachine]
    i1 check emptyFSM shouldBe true

    // contravariant:
    val i2 = inv[NamedElement] (valid).inCtx[FiniteStateMachine] : Inv[FiniteStateMachine]
    i2 check emptyFSM shouldBe true

    // covariant (should not compile):
    // inv[FiniteStateMachine] (valid) : Inv[NamedElement]

  }

  behavior of "implies"

  it should "follow the truth table of implication" in {

     (true  implies true ) shouldBe true
     (true  implies false) shouldBe false
     (false implies true ) shouldBe true
     (false implies false) shouldBe true

  }

  it should "be lazy in the second argument" in {

     (false implies ???) shouldBe true
     intercept[scala.NotImplementedError] (true implies ???)

  }

}
