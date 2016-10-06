
trait Named {
  val name:String

  override def toString = name
}

trait Model extends Named {

  val products:Seq[Product]

  def getProduct(name:String):Option[Product]  = products.find(_.name == name)

  override def toString:String = {
    s"Model name: ${name}\nProducts:\n" +
        products.map(_.toString(this)).mkString("\n")
  }

  def updateParam(prod:String, param:String, index:Int):Option[Model]
}

case class SimpleModel(name:String, products:Seq[Product]) extends Model {

  def updateParam(prod:String, param:String, index:Int):Option[Model] = {
    for {
      theproduct <- getProduct(prod)
      newProduct <- theproduct.updateParam(this, param, index)
    } yield copy(products = products.map(p => if (p.name == prod) newProduct else p))
  }
}

trait Product extends Named {

  val parameters:Seq[Parameter]

  def getParam(name:String):Option[Parameter] = parameters.find(_.name == name)

  def toString(model:Model):String = {
    s"\tProduct: ${name}\n\tParameters:\n\t" +
        parameters.map(_.toString(model)).mkString("\n\t")
  }

  def updateParam(model:Model, param:String, index:Int):Option[Product]

}

case class SimpleProduct(name:String, parameters:List[Parameter]) extends Product {

  def updateParam(model:Model, param:String, index:Int):Option[Product] = {
    getParam(param).map(_.set(model, index))
      .map(newParam =>
            copy(parameters = parameters.map(p =>
              if (p.name == param) newParam else p)))
  }

}

trait Parameter extends Named {

  // possible values
  def values(model:Model):Seq[Value]
  val optional:Boolean = false
  val count:Dynamic[Int]
  val _type:Type

  // the selected value(s), because count can be >= 1
  val selected:List[Int]

  def getSelected(model:Model):List[Value] =
    selected.map(index => values(model)(index))

  def getValue(model:Model):Option[Value] = {
    if (count.get(model) != 1)
      throw new RuntimeException("never call getValue if count is not 1")
    else getSelected(model).headOption

  }

  private def selToString(model:Model):String = {
    if (selected.isEmpty)
      "None"
    else getSelected(model).map(_.toString(model)).mkString(",")
  }

  private def valsToString(model:Model):String = {
    "\t\t\t" + values(model)
        .zipWithIndex.map(t => (t._2+1) + ". " + t._1.toString(model))
        .mkString("\n\t\t\t")
  }

  def set(model:Model, index:Int):Parameter

  def toString(model:Model):String = {
    s"\tParameter: ${name}, count: ${count.get(model)}\n" +
    s"\t\tSelected: ${selToString(model)}\n\t\tPossible Values:\n${valsToString(model)}\n "
  }

}

case class SimpleParam(selected:List[Int] = List(), _type:Type,
                       name:String, values:Seq[Value],
                       count:Dynamic[Int] = Constant(1)) extends Parameter {

  def values(model:Model):Seq[Value] = values

  def set(model:Model, index:Int):Parameter =
    if (index >= 0)
      if (count.get(model) == 1)
        copy(selected = List(index))
      else
        copy(selected = selected :+ index)
    else
      copy(selected = Nil)

}

trait Value {
  val _type:Type
  val fields:List[(String,String)]

  def hasField(name:String) = fields.exists(_._1 == name)
  def getField(name:String):Option[String] = fields.find(_._1 == name).map(_._2)

  def fieldToString(field:(String,String)):String = {
    field._1 + " = " + field._2
  }

  def toString(model:Model):String = {
    _type.toString + "(" + fields.map(fieldToString(_)).mkString(",") + ")"
  }
}

trait Field {
  val name:String
  val ptype:Primitive
}
case class ReqField(name:String, ptype:Primitive) extends Field
case class OptField(name:String, ptype:Primitive, defaultVal: Value) extends Field

object implicits {

  implicit def pairToField(pair:(String,Primitive)):Field =
    ReqField(pair._1, pair._2)

  implicit def pairsToFields(lst:List[(String,Primitive)]):List[Field] =
    lst.map(pairToField(_))
}

import implicits._

trait Type extends Named {

  def isType(value:Value):Boolean = value._type.name == this.name
  val fields:List[Field]

}

sealed trait Primitive
case object PNum extends Primitive
case object PText extends Primitive
case object PBool extends Primitive
