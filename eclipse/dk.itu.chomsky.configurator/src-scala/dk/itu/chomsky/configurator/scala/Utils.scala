
package dk.itu.chomsky.configurator.scala
import scala.collection.mutable.MutableList
import org.eclipse.emf.common.util.EList
import java.util.function.Consumer

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

  def escapeQuotes(in:String):String =
    in.replace("\"", "\\\"")
    
  def eListToList[A](el:EList[A]) = {
    val mutlist = MutableList[A]()
    el.forEach(new Consumer[A] {
      override def accept(el:A):Unit = {
        mutlist += el
      }
    })
    mutlist.toList
  }
}