
package dk.itu.chomsky.configurator.scala

object Utils {

  def instanceOf[A](o:Any):Option[A] =
    try Some(o.asInstanceOf[A])
    catch {
      case e:ClassCastException => None
    }

  private def tailOption(s:String):Option[String] =
    if (s.isEmpty)
      None
    else Some(s.tail)

  private def safeTail(s:String):String = tailOption(s).getOrElse("")

  def template(input:String):String = {
    input.split("\n").map(l => safeTail(l.dropWhile(_ != '|'))).mkString("\n")
  }
}