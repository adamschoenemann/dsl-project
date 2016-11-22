
package dk.itu.chomsky.configurator.scala.generators.json

import collection.immutable.StringOps._
import dk.itu.chomsky.configurator.scala.Utils.escapeQuotes

trait JSON {
  def serialize(indent:Int):String
}
case class JObject(map:Map[String,JSON]) extends JSON {

  def serialize(indent:Int):String = "{\n" +
    map.toList.map({
      case (k,v) => ("\t" * (indent + 1)) + "\"" + k + "\": " + v.serialize(indent + 1)
    }).mkString(",\n") + "\n" + ("\t" * indent) + "}"
}
case class JArray(list:List[JSON]) extends JSON {
  def serialize(indent:Int):String = list match {
    case Nil => "[]"
    case List(x) => "[" + x.serialize(indent) + "]"
    case _ => "[\n" +
        list.map(("\t" * (indent+1)) + _.serialize(indent + 1))
            .mkString(",\n") + "\n" + ("\t" * indent) + "]"
    }
}
case class JNumber(value:Double) extends JSON {
  def serialize(indent:Int):String = value.toString
}

case class JString(value:String) extends JSON {
  def serialize(indent:Int):String = "\"" + escapeQuotes(value) + "\""
}
case class JBool(value:Boolean) extends JSON {
  def serialize(indent:Int):String = value.toString
}

case object JNull extends JSON {
  def serialize(indent:Int):String = "null"
}

object JObject {
  def apply(tuples:(String,JSON)*):JObject = JObject(Map(tuples:_*))
}


object JSON {
  object implicits {
    implicit def strToJStr(s:String):JString = JString(s)
    implicit def lstToJArr(lst:List[JSON]):JArray = JArray(lst)
    implicit def mapToObj(map:Map[String,JSON]):JObject = JObject(map)
  }
}

