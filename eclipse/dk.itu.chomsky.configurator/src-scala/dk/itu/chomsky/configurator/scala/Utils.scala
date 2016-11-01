
package dk.itu.chomsky.configurator.scala

object Utils {

  def instanceOf[A](o:Any):Option[A] =
    try Some(o.asInstanceOf[A])
    catch {
      case e:ClassCastException => None
    }
}