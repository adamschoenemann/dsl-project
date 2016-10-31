
package dk.itu.chomsky.configurator.scala

object Utils {

  def instanceOf[A](o:Any):Option[A] =
    if (o.isInstanceOf[A])
      Some(o.asInstanceOf[A])
    else None
}