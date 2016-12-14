
package dk.itu.chomsky.configurator.scala

import dk.itu.chomsky.configurator.model._
import Utils._
import dk.itu.chomsky.configurator.scala.generators.html.HTMLGenerator
import dk.itu.chomsky.configurator.scala.generators.json.JSONGenerator
import dk.itu.chomsky.configurator.scala.generators.common.ExprGen.genExpr
import dk.itu.chomsky.configurator.scala.generators.android.AndroidGenerator
import dk.itu.chomsky.configurator.scala.{Extractors => E}


sealed trait ExprTy
case object TyNum extends ExprTy
case object TyBool extends ExprTy
case object TyString extends ExprTy
case object TyValueRef extends ExprTy
case object TyParamRef extends ExprTy



object Chomsky {


  class FunDef(name:String, paramTys:List[ExprTy], retTy:ExprTy) {

    def checkArgs(args:List[Expr]):Boolean = {
      args.zip(paramTys).map({case (expr, expectTy) => {
        for {
          resTy <- checkExpr(expr) if resTy == expectTy
        } yield expectTy
      }}).forall(!_.isEmpty)
    }

    def getRetTy(argTys:List[Expr]):ExprTy = retTy

  }

  val valueFunDef =
    new FunDef("value", List(TyParamRef), TyValueRef) {
      override def getRetTy(argTys:List[Expr]) = argTys match {
        case Nil => sys.error("should never happen")
        case List(E.ParamRef(param)) => param match {
          case E.PrimParam(_,_,ty) => primToTy(ty)
          case E.EnumParam(_)  => TyValueRef
        }
        case _ => sys.error("should never happen")
      }
    }

  val stdLib = Map[String, FunDef](
    "value"    -> valueFunDef,
    "contains" -> new FunDef("contains", List(TyString, TyString), TyBool),
    "label"    -> new FunDef("label", List(TyParamRef), TyString)
  )


  private def checkOpOfTy(ty:ExprTy, op:BinOp, result:ExprTy):Option[ExprTy] = {
    for {
      l <- checkExpr(op.getLeft)  if l == ty
      r <- checkExpr(op.getRight) if r == ty
    } yield result
  }

  private def primToTy(ty:PrimitiveType):ExprTy = {
    if (ty == PrimitiveType.INT_TY || ty == PrimitiveType.DOUBLE_TY)
      TyNum
    else if (ty == PrimitiveType.BOOL_TY)
      TyBool
    else if (ty == PrimitiveType.TEXT_TY)
      TyString
    else throw new NotImplementedError("unkown primitive type")
  }

  def checkFun(name:String, args:List[Expr]):Option[ExprTy] = {
    stdLib.get(name).flatMap(fundef => {
      if (fundef.checkArgs(args))
        Some(fundef.getRetTy(args))
      else None
    })
  }

  def checkExpr(expr:Expr):Option[ExprTy] = expr match {
    case E.ConstNum(_)   => Some(TyNum)
    case E.ConstBool(_)  => Some(TyBool)
    case E.ConstString(_)  => Some(TyString)
    case E.ParamRef(param)    => Some(TyParamRef)
    case E.ValueRef(enumVal) => Some(TyValueRef)
    case E.Not(expr) =>
      for {
        ty <- checkExpr(expr) if ty == TyBool
      } yield TyBool
    case E.Neg(expr) =>
      for {
        ty <- checkExpr(expr) if ty == TyNum
      } yield TyNum
    case E.ITE(guard, tbranch, fbranch) =>
      for {
        gty <- checkExpr(guard) if gty == TyBool
        tty <- checkExpr(tbranch)
        fty <- checkExpr(fbranch) if tty == fty
      } yield tty
    case E.FunApp(name, args) => checkFun(name, args)
    case op:Plus  => checkOpOfTy(TyNum, op, TyNum)
    case op:Minus => checkOpOfTy(TyNum, op, TyNum)
    case op:Mult  => checkOpOfTy(TyNum, op, TyNum)
    case op:Div   => checkOpOfTy(TyNum, op, TyNum)
    case op:Eq    =>
      for {
        l <- checkExpr(op.getLeft)
        r <- checkExpr(op.getRight) if r == l
      } yield TyBool
    case op:And   => checkOpOfTy(TyBool, op, TyBool)
    case op:Or    => checkOpOfTy(TyBool, op, TyBool)
    case op:Leq   => checkOpOfTy(TyNum, op, TyBool)
    case op:Lt    => checkOpOfTy(TyNum, op, TyBool)
    case op:Geq   => checkOpOfTy(TyNum, op, TyBool)
    case op:Gt    => checkOpOfTy(TyNum, op, TyBool)
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

 def generateJson(model:Model):String = JSONGenerator.generate(model)
 def generateHtml(model:Model):String = HTMLGenerator.generate(model)
 def genJSExpr(expr:Expr):String = genExpr(expr)
 def testHtmlGen(model:Model):Unit = HTMLGenerator.test(model)

 //Android
 def generateAndroidMainView(model: Model) : String  = AndroidGenerator.generateXmlLayout(model)
 def generateAndroidMainActivity(model:Model):String = AndroidGenerator.generateMainActivity(model)

}