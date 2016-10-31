
package dk.itu.chomsky.configurator.scala

import collection.immutable.StringOps._

trait JSON {
  def serialize(ident:Int):String
}
case class JObject(map:Map[String,JSON]) extends JSON {

  def serialize(ident:Int):String = "{\n" +
    map.toList.map({
      case (k,v) => ("\t" * (ident + 1)) + "\"" + k + "\": " + v.serialize(ident + 1)
    }).mkString(",\n") + "\n" + ("\t" * ident) + "}"
}
case class JArray(list:List[JSON]) extends JSON {
  def serialize(ident:Int):String = list match {
    case Nil => "[]"
    case List(x) => "[" + x.serialize(ident) + "]"
    case _ => "[\n" +
        list.map(("\t" * (ident+1)) + _.serialize(ident + 1))
            .mkString(",\n") + "\n" + ("\t" * ident) + "]"
    }
}
case class JNumber(value:Double) extends JSON {
  def serialize(ident:Int):String = value.toString
}

case class JString(value:String) extends JSON {
  def serialize(ident:Int):String = value
}
case class JBool(value:Boolean) extends JSON {
  def serialize(ident:Int):String = value.toString
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

