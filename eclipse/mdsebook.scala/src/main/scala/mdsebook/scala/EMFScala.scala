package mdsebook.scala

import scala.collection.JavaConverters.asScalaIteratorConverter
import scala.reflect.ClassTag

import org.eclipse.emf.ecore.EObject

object EMFScala {


  // EMF iterators to Scala iterators

  implicit def asScalaTreeIteratorConverter[A]
    (x: org.eclipse.emf.common.util.TreeIterator[A])
      : Iterator[A] = x.asScala

  // An implies operator for more elegant constraints

  class BooleanOps (a: Boolean) { def implies(b : => Boolean) = !a || b }
  implicit def booleanOps (a : Boolean) = new BooleanOps (a)

  // Support for constraints

  sealed trait Constraint {

    def check (o: EObject) :Boolean

    // These methods can help to filter constraints by types to avoid executing
    // them for performance reasons, or to avoid message clutter

    def appliesTo (o :EObject) :Boolean
    def appliesToAny (os :List[EObject]) :Boolean

  }

  final case class Inv[T <: EObject] private (
    p: T => Boolean, ct: ClassTag[T]) extends Constraint
  {

    // Use this to build more complex constraints from smaller pieces

    def &&[S <: EObject] (that: Inv[S])
      (implicit ct :ClassTag[T with S]) :Inv[T with S] =
      Inv[T with S] (x => p(x) && that.p(x), ct)

    // Since invariants are "invariant" (no pun intendeted), to follow the
    // ClassTag[T] implementation, we add this method to help up casting a bit:
    // The method implements the contravariant casting, so specializing the
    // context type is allowed.

    def inCtx[S <: T] (implicit cts: ClassTag[S]) :Inv[S] = Inv[S] (p,cts)

    // Use this method to check the constraint on any ECore instance object.
    // If the object is not in the context, the constraint will pass (hold)
    // vacously.

    def check (o: EObject) :Boolean = !appliesTo (o) || p(o.asInstanceOf[T])

    def appliesTo    (o :EObject) :Boolean = instanceOf[T] (o) (ct)
    def appliesToAny (os :List[EObject]) :Boolean = os.exists (appliesTo _)

  }

  private object Inv {

    def instanceOf[T] (o: Any) (ct :ClassTag[T]) :Boolean =
      ct.runtimeClass.isInstance(o)

    // A convenience constructor (also protecting the actual class
    // representation for future evolution)

    def inv[T <: EObject] (p: T => Boolean) (implicit ct : ClassTag[T]) :Inv[T] =
      Inv[T] (p,ct)

  }

  // Support for transformations

  trait InPlaceTrafo[T] {

    def run (m: T) :Unit

  }

  // Delegations for easier importing

  def inv[T <: EObject] (check: T => Boolean) (implicit ct: ClassTag[T]) :Inv[T] =
    Inv.inv[T] (check) (ct)

  def instanceOf[T] (o: Any) (implicit ct: ClassTag[T]) :Boolean =
    Inv.instanceOf[T] (o) (ct)

}
