
package dk.itu.chomsky.configurator.scala

import dk.itu.chomsky.configurator.model._
import dk.itu.chomsky.configurator.scala.Utils._
import dk.itu.chomsky.configurator.scala.Utils.implicits._



object Extractors {

  object Model {
    def unapply(model:Model):Option[(List[EnumType], List[ModelChild])] =
      Some((model.getTypes, model.getChildren))
  }

  object ConstNum {
    def unapply(expr:Expr):Option[Double] =
      if (expr.isInstanceOf[ConstNum])
        Some(expr.asInstanceOf[ConstNum]).map(_.getValue)
      else None
  }
  object ConstString {
    def unapply(expr:Expr):Option[String] =
      if (expr.isInstanceOf[ConstString])
        Some(expr.asInstanceOf[ConstString]).map(_.getValue)
      else None
  }
  object ConstBool {
    def unapply(expr:Expr):Option[Boolean] =
      if (expr.isInstanceOf[ConstBool])
        Some(expr.asInstanceOf[ConstBool]).map(_.isValue)
      else None

    def apply(value:Boolean):ConstBool = {
      val instance = ModelFactory.eINSTANCE.createConstBool()
      instance.setValue(value)
      instance
    }
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
  object Neg {
    def unapply(expr:Expr):Option[Expr] =
      if (expr.isInstanceOf[Neg])
        Some(expr.asInstanceOf[Neg].getExpr)
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
  object Implic {
    def unapply(expr:Expr):Option[(Expr, Expr)] =
      if (expr.isInstanceOf[Implic])
        Some(expr.asInstanceOf[Implic]).map(op => (op.getLeft, op.getRight))
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

  object ITE {
    def unapply(expr:Expr):Option[(Expr,Expr,Expr)] =
      if (expr.isInstanceOf[ITE])
        Some(expr.asInstanceOf[ITE])
          .map(v => (v.getGuard, v.getTrueBranch, v.getFalseBranch))
      else None

  }

  object Not {
    def unapply(expr:Expr):Option[Expr] =
      if (expr.isInstanceOf[Not])
        Some(expr.asInstanceOf[Not]).map(_.getExpr)
      else None

  }

  object FunApp {
    def unapply(expr:Expr):Option[(String, List[Expr])] =
      if (expr.isInstanceOf[FunApp])
        Some(expr.asInstanceOf[FunApp])
          .map(app => (app.getName, app.getArgs))
      else None

  }

  object ParamRef {
    def unapply(expr:Expr):Option[Param] =
      if (expr.isInstanceOf[ParamRef])
        Some(expr.asInstanceOf[ParamRef]).map(_.getParam)
      else None
  }

  object ValueRef {
    def unapply(expr:Expr):Option[EnumVal] =
      if (expr.isInstanceOf[ValueRef])
        Some(expr.asInstanceOf[ValueRef]).map(_.getEnumVal)
      else None
  }

  object ParamGroup {
    def unapply(pc:ProductChild):Option[(String, List[ProductChild])] =
      if (pc.isInstanceOf[ParamGroup])
        Some(pc.asInstanceOf[ParamGroup]).map(pg => (pg.getLabel, pg.getChildren))
      else None
  }

  object Product {
    def unapply(mc:ModelChild):Option[(String, String, List[ProductChild], List[Constraint])] =
      if (mc.isInstanceOf[Product])
        Some(mc.asInstanceOf[Product]).map(pg => (pg.getName, pg.getLabel, pg.getChildren, pg.getConstraints))
      else None
  }

  object ProductGroup {
    def unapply(mc:ModelChild):Option[(String, List[ModelChild])] =
      if (mc.isInstanceOf[ProductGroup])
        Some(mc.asInstanceOf[ProductGroup]).map(pg => (pg.getLabel, pg.getChildren))
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
      Some((t.getName, t.getLabel, t.getValues))
    }
  }

  object EnumVal {
    def unapply(v:EnumVal):Option[(String,String)] = {
      Some((v.getName, v.getLabel))
    }
  }


  object Constraint {
    def unapply(v:Constraint):Option[(String,Expr,Option[Param])] = {
      val po = if (v.getParam == null) None else Some(v.getParam)
      Some((v.getLabel, v.getExpr, po))
    }
  }

}