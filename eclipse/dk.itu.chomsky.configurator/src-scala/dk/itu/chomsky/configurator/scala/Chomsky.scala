
package dk.itu.chomsky.configurator.scala

import dk.itu.chomsky.configurator.model._
import org.eclipse.emf.common.util.EList
import scala.collection.mutable.MutableList
import java.util.function.Consumer
import Utils.instanceOf

object implicits {

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

import implicits._

sealed trait ExprTy
case object TyInt extends ExprTy
case object TyBool extends ExprTy

object ConstInt {
  def unapply(expr:Expr):Option[Int] =
    instanceOf[ConstInt](expr).map(_.getValue)
}
object ConstBool {
  def unapply(expr:Expr):Option[Boolean] =
    instanceOf[ConstBool](expr).map(_.isValue)
}
object Plus {
  def unapply(expr:Expr):Option[(Expr,Expr)] =
    instanceOf[Plus](expr).map(p => (p.getLeft, p.getRight))
}
object Minus {
  def unapply(expr:Expr):Option[(Expr, Expr)] =
    instanceOf[Minus](expr).map(op => (op.getLeft, op.getRight))
}
object Mult {
  def unapply(expr:Expr):Option[(Expr, Expr)] =
    instanceOf[Mult](expr).map(op => (op.getLeft, op.getRight))
}
object Div {
  def unapply(expr:Expr):Option[(Expr, Expr)] =
    instanceOf[Div](expr).map(op => (op.getLeft, op.getRight))
}
object Eq {
  def unapply(expr:Expr):Option[(Expr, Expr)] =
    instanceOf[Eq](expr).map(op => (op.getLeft, op.getRight))
}
object And {
  def unapply(expr:Expr):Option[(Expr, Expr)] =
    instanceOf[And](expr).map(op => (op.getLeft, op.getRight))
}
object Or {
  def unapply(expr:Expr):Option[(Expr, Expr)] =
    instanceOf[Or](expr).map(op => (op.getLeft, op.getRight))
}
object Leq {
  def unapply(expr:Expr):Option[(Expr, Expr)] =
    instanceOf[Leq](expr).map(op => (op.getLeft, op.getRight))
}
object Lt {
  def unapply(expr:Expr):Option[(Expr, Expr)] =
    instanceOf[Lt](expr).map(op => (op.getLeft, op.getRight))
}
object Geq {
  def unapply(expr:Expr):Option[(Expr, Expr)] =
    instanceOf[Geq](expr).map(op => (op.getLeft, op.getRight))
}
object Gt {
  def unapply(expr:Expr):Option[(Expr, Expr)] =
    instanceOf[Gt](expr).map(op => (op.getLeft, op.getRight))
}
object Var {
  def unapply(expr:Expr):Option[Param] =
    instanceOf[Var](expr).map(_.getParam)
}

object ParamGroup {
  def unapply(pc:ProductChild):Option[String] =
    instanceOf[ParamGroup](pc).map(_.getLabel)
}

object PrimParam {
  // cannot use Util.instanceOf here for some reason - it makes an incorrect cast
  // swapping the cases in paramToJson makes the EnumParam extractor behave the
  // same way... very strange
  def unapply(param:Param):Option[(String,String,PrimitiveType)] = {
    if (param.isInstanceOf[PrimParam]) {
      val p = param.asInstanceOf[PrimParam]
      Some((p.getName, p.getLabel, p.getType))
    }
    else None
  }
}
object EnumParam {
  def unapply(param:Param):Option[(String,String,EnumType)] = {
    instanceOf[EnumParam](param).map(p =>
      (p.getName, p.getLabel, p.getType)
    )
  }
}
object EnumType {
  def unapply(t:EnumType):Option[(String,String,List[EnumVal])] = {
    Some((t.getName, t.getLabel, eListToList(t.getValues)))
  }
}

object EnumVal {
  def unapply(v:EnumVal):Option[(String,String)] = {
    Some((v.getName, v.getLabel))
  }
}


object Chomsky {


  def pleaseWork():Unit = {
    println("Please work")
  }

  private def checkOpOfTy(ty:ExprTy, op:BinOp, result:ExprTy):Option[ExprTy] = {
    for {
      l <- checkExpr(op.getLeft)  if l == ty
      r <- checkExpr(op.getRight) if r == ty
    } yield result
  }

  private def primToTy(t:PrimitiveType):ExprTy = {
    if (t == PrimitiveType.INT_TY)
      TyInt
    else if (t == PrimitiveType.BOOL_TY)
      TyBool
    else throw new NotImplementedError("not implemented") // TODO: This should obviously be implemented
  }


  def checkExpr(expr:Expr):Option[ExprTy] = expr match {
    case ConstInt(_)   => Some(TyInt)
    case ConstBool(_)  => Some(TyBool)
    case Var(param)    => param match {
      case PrimParam(_,_,ty) => Some(primToTy(ty))
      case EnumParam(_)  => Some(TyInt)
    }
    case op:Plus  => checkOpOfTy(TyInt, op, TyInt)
    case op:Minus => checkOpOfTy(TyInt, op, TyInt)
    case op:Mult  => checkOpOfTy(TyInt, op, TyInt)
    case op:Div   => checkOpOfTy(TyInt, op, TyInt)
    case op:Eq    =>
      for {
        l <- checkExpr(op.getLeft)
        r <- checkExpr(op.getRight) if r == l
      } yield r
    case op:And   => checkOpOfTy(TyBool, op, TyBool)
    case op:Or    => checkOpOfTy(TyBool, op, TyBool)
    case op:Leq   => checkOpOfTy(TyInt, op, TyBool)
    case op:Lt    => checkOpOfTy(TyInt, op, TyBool)
    case op:Geq   => checkOpOfTy(TyInt, op, TyBool)
    case op:Gt    => checkOpOfTy(TyInt, op, TyBool)
  }

  def generateJson(model:Model):String = {

    import JSON.implicits._

    implicit def el2l[A](el:EList[A]) = eListToList(el)

    val types:JArray = eListToList(model.getTypes).map({
      case EnumType(name,label,values) => {
        val valueObjs = values.map({
          case EnumVal(name,label) => JObject("name" -> name, "label" -> label)
        })
        JObject("name" -> name, "label" -> label, "values" -> valueObjs)
      }
    })

    def enumValsToJson(values:List[EnumVal]):JSON =
      values.map({case EnumVal(name,label) => JObject("name" -> name, "label" -> label)})

    def paramToJson(param:Param):JSON = param match {
      case PrimParam(name, label, t) => JObject(
        "name" -> name, "label" -> label, "type" -> JString(t.toString)
      )
      case EnumParam(name, label, EnumType(ename,elabel,values)) => JObject(
        "name" -> name, "label" -> label, "type" -> ename
      )
    }

    def productChildToJson(child:ProductChild):JSON = child match {
      case c:ParamGroup => JObject(
        "label" -> c.getLabel,
        "children" -> JArray(c.getChildren.map(productChildToJson))
      )
      case c:Param => paramToJson(c)
    }

    def productToJson(product:Product):JSON = JObject(
      "label" -> product.getLabel,
      "params" -> product.getChildren.map(productChildToJson(_))
    )

    def modelChildrenToJson(child:ModelChild):JSON = child match {
      case c:ProductGroup => JObject(
        "label" -> c.getLabel,
        "children" -> JArray(c.getChildren.map(modelChildrenToJson))
      )
      case c:Product => productToJson(c)
    }

    // types.serialize(0)
    val children:JArray = model.getChildren.map(modelChildrenToJson(_))

    val json = JObject("types" -> types, "children" -> children)
    json.serialize(0)
    // val types = eListToList(model.getTypes).map({
    //   case EnumType(name,label,values) => {
    //     val valueObjs =
    //       values.map({case EnumVal(name,label) => s"""{"name":"$name","label":"$label"}"""})
    //             .mkString(",")
    //     s"""{"name":"$name","label":"$label","values":[$valueObjs]}"""
    //   }
    // }).mkString(",\n")

    // val children = ""

    // s"""{
    //   "types": [$types],
    //   "children": [$children]
    // }"""
  }
}