
package dk.itu.chomsky.configurator.scala

import dk.itu.chomsky.configurator.model._
import org.eclipse.emf.common.util.EList
import scala.collection.mutable.MutableList
import java.util.function.Consumer
import Utils._

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
case object TyNum extends ExprTy
case object TyBool extends ExprTy
case object TyString extends ExprTy

object ConstNum {
  def unapply(expr:Expr):Option[Double] =
    if (expr.isInstanceOf[ConstNum])
      Some(expr.asInstanceOf[ConstNum]).map(_.getValue)
    else None
}
object ConstBool {
  def unapply(expr:Expr):Option[Boolean] =
    if (expr.isInstanceOf[ConstBool])
      Some(expr.asInstanceOf[ConstBool]).map(_.isValue)
    else None
}
object Plus {
  def unapply(expr:Expr):Option[(Expr,Expr)] =
    if (expr.isInstanceOf[Plus])
      Some(expr.asInstanceOf[Plus]).map(p => (p.getLeft, p.getRight))
    else None
}
object Minus {
  def unapply(expr:Expr):Option[(Expr, Expr)] =
    if (expr.isInstanceOf[Minus])
      Some(expr.asInstanceOf[Minus]).map(op => (op.getLeft, op.getRight))
    else None
}
object Mult {
  def unapply(expr:Expr):Option[(Expr, Expr)] =
    if (expr.isInstanceOf[Mult])
      Some(expr.asInstanceOf[Mult]).map(op => (op.getLeft, op.getRight))
    else None
}
object Div {
  def unapply(expr:Expr):Option[(Expr, Expr)] =
    if (expr.isInstanceOf[Div])
      Some(expr.asInstanceOf[Div]).map(op => (op.getLeft, op.getRight))
    else None
}
object Eq {
  def unapply(expr:Expr):Option[(Expr, Expr)] =
    if (expr.isInstanceOf[Eq])
      Some(expr.asInstanceOf[Eq]).map(op => (op.getLeft, op.getRight))
    else None
}
object And {
  def unapply(expr:Expr):Option[(Expr, Expr)] =
    if (expr.isInstanceOf[And])
      Some(expr.asInstanceOf[And]).map(op => (op.getLeft, op.getRight))
    else None
}
object Or {
  def unapply(expr:Expr):Option[(Expr, Expr)] =
    if (expr.isInstanceOf[Or])
      Some(expr.asInstanceOf[Or]).map(op => (op.getLeft, op.getRight))
    else None
}
object Leq {
  def unapply(expr:Expr):Option[(Expr, Expr)] =
    if (expr.isInstanceOf[Leq])
      Some(expr.asInstanceOf[Leq]).map(op => (op.getLeft, op.getRight))
    else None
}
object Lt {
  def unapply(expr:Expr):Option[(Expr, Expr)] =
    if (expr.isInstanceOf[Lt])
      Some(expr.asInstanceOf[Lt]).map(op => (op.getLeft, op.getRight))
    else None
}
object Geq {
  def unapply(expr:Expr):Option[(Expr, Expr)] =
    if (expr.isInstanceOf[Geq])
      Some(expr.asInstanceOf[Geq]).map(op => (op.getLeft, op.getRight))
    else None
}
object Gt {
  def unapply(expr:Expr):Option[(Expr, Expr)] =
    if (expr.isInstanceOf[Gt])
      Some(expr.asInstanceOf[Gt]).map(op => (op.getLeft, op.getRight))
    else None
}

object ParamValueRef {
  def unapply(expr:Expr):Option[Param] =
    if (expr.isInstanceOf[ParamValueRef])
      Some(expr.asInstanceOf[ParamValueRef]).map(_.getParam)
    else None
}

object ValueRef {
  def unapply(expr:Expr):Option[EnumVal] =
    if (expr.isInstanceOf[ValueRef])
      Some(expr.asInstanceOf[ValueRef]).map(_.getEnumVal)
    else None
}

object ParamGroup {
  def unapply(pc:ProductChild):Option[String] =
    if (pc.isInstanceOf[ParamGroup])
      Some(pc.asInstanceOf[ParamGroup]).map(_.getLabel)
    else None
}

object PrimParam {
  def unapply(param:Param):Option[(String,String,PrimitiveType)] =
    if (param.isInstanceOf[PrimParam])
      Some(param.asInstanceOf[PrimParam]).map(p => (p.getName, p.getLabel, p.getType))
    else None
}
object EnumParam {
  def unapply(param:Param):Option[(String,String,EnumType)] =
    if (param.isInstanceOf[EnumParam])
      Some(param.asInstanceOf[EnumParam]).map(p => (p.getName, p.getLabel, p.getType))
    else None
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
    if (t == PrimitiveType.INT_TY || t == PrimitiveType.BOOL_TY)
      TyNum
    else if (t == PrimitiveType.BOOL_TY)
      TyBool
    else if (t == PrimitiveType.TEXT_TY)
      TyString
    else throw new NotImplementedError("unkown primitive typ")
  }

  // def genJSConstraint(constraint:Constraint):String = {

  //   val comment = "// " + constraint.getLabel


  // }

  def genJSExpr(expr:Expr):String = expr match {
    case ConstNum(x)   => x.toString
    case ConstBool(x)  => x.toString
    case ValueRef(_)   => ???
    case ParamValueRef(param)    => param match {
      case PrimParam(name,label,ty) => "$(\"#" + name + " input\").val()"
      case EnumParam(name,label,EnumType(ename,elabel,_))  =>
        "$(\"#" + name + " select\").val()"
    }
    case Plus(l,r)  => genJSExpr(l) + " + "  + genJSExpr(r)
    case Minus(l,r) => genJSExpr(l) + " - "  + genJSExpr(r)
    case Mult(l,r)  => genJSExpr(l) + " * "  + genJSExpr(r)
    case Div(l,r)   => genJSExpr(l) + " / "  + genJSExpr(r)
    case Eq(l,r)    => genJSExpr(l) + " == " + genJSExpr(r)
    case And(l,r)   => genJSExpr(l) + " && " + genJSExpr(r)
    case Or(l,r)    => genJSExpr(l) + " || " + genJSExpr(r)
    case Leq(l,r)   => genJSExpr(l) + " <= " + genJSExpr(r)
    case Lt(l,r)    => genJSExpr(l) + " < "  + genJSExpr(r)
    case Geq(l,r)   => genJSExpr(l) + " >= " + genJSExpr(r)
    case Gt(l,r)    => genJSExpr(l) + " > "  + genJSExpr(r)
  }


  def checkExpr(expr:Expr):Option[ExprTy] = expr match {
    case ConstNum(_)   => Some(TyNum)
    case ConstBool(_)  => Some(TyBool)
    case ParamValueRef(param)    => param match {
      case PrimParam(_,_,ty) => Some(primToTy(ty))
      case EnumParam(_)  => Some(TyString)
    }
    case ValueRef(enumVal) => Some(TyString)
    case op:Plus  => checkOpOfTy(TyNum, op, TyNum)
    case op:Minus => checkOpOfTy(TyNum, op, TyNum)
    case op:Mult  => checkOpOfTy(TyNum, op, TyNum)
    case op:Div   => checkOpOfTy(TyNum, op, TyNum)
    case op:Eq    =>
      for {
        l <- checkExpr(op.getLeft)
        r <- checkExpr(op.getRight) if r == l
      } yield r
    case op:And   => checkOpOfTy(TyBool, op, TyBool)
    case op:Or    => checkOpOfTy(TyBool, op, TyBool)
    case op:Leq   => checkOpOfTy(TyNum, op, TyBool)
    case op:Lt    => checkOpOfTy(TyNum, op, TyBool)
    case op:Geq   => checkOpOfTy(TyNum, op, TyBool)
    case op:Gt    => checkOpOfTy(TyNum, op, TyBool)
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

    val children:JArray = model.getChildren.map(modelChildrenToJson(_))

    val json = JObject("types" -> types, "children" -> children)
    json.serialize(0)
  }

  def testTemplates():Unit = {
    val c1 = """ "c1" p2 > 0"""
    val out = template(s"""
     |model computer_model "Computer Model" {
     |  types {
     |    t1 "Type 1" {
     |      v1 "Value 1"
     |      v2 "Value 2"
     |    }
     |  }
     lines without bars will become newlines or skipped if empty
     |  product computer "Computer" {
     |    param p1 "Param 1" t1
     |    param p2 "Param 2" Int
     |    constraints {
     |      $c1
     |    }
     |  }
     |}
    """)

    println(out)
  }
}