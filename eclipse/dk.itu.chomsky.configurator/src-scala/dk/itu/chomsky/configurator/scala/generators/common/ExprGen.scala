
package dk.itu.chomsky.configurator.scala.generators.common;
import dk.itu.chomsky.configurator.model.Expr
import dk.itu.chomsky.configurator.scala.{Extractors => E}

object ExprGen {

  def genExpr(expr:Expr):String = expr match {
    case E.ConstNum(x)    => x.toString
    case E.ConstBool(x)   => x.toString
    case E.ConstString(x) => "\"" + x + "\""
    case E.ValueRef(E.EnumVal(name,_))    => s"""__prim__value_ref("$name")"""
    case E.ParamRef(param) => param match {
      case E.PrimParam(name,_,ty) => s"""__prim__${ty}_param_ref("$name")"""
      case E.EnumParam(name,_,_) => s"""__prim__enum_param_ref("$name")"""
    }
    case E.Not(e)  => "!" + genExpr(e)
    case E.Neg(e)  => "-" + genExpr(e)
    case E.ITE(g, t, f) => s"(${genExpr(g)} ? (${genExpr(t)}) : (${genExpr(f)}))"
    case E.FunApp(name, args) => {
      val argslist = args.map(genExpr(_)).mkString(", ")
      s"""__prim__$name($argslist)"""
    }
    case E.Plus(l,r)  => s"(${genExpr(l)} + ${genExpr(r)})"
    case E.Minus(l,r) => s"(${genExpr(l)} - ${genExpr(r)})"
    case E.Mult(l,r)  => s"(${genExpr(l)} * ${genExpr(r)})"
    case E.Div(l,r)   => s"(${genExpr(l)} / ${genExpr(r)})"
    case E.Eq(l,r)    => s"__prim__equals(${genExpr(l)}, ${genExpr(r)})"
    case E.And(l,r)   => s"(${genExpr(l)} && ${genExpr(r)})"
    case E.Implic(l,r) => s"(!${genExpr(l)} || ${genExpr(r)})"
    case E.Or(l,r)    => s"(${genExpr(l)} || ${genExpr(r)})"
    case E.Leq(l,r)   => s"(${genExpr(l)} <= ${genExpr(r)})"
    case E.Lt(l,r)    => s"(${genExpr(l)} < ${genExpr(r)})"
    case E.Geq(l,r)   => s"(${genExpr(l)} >= ${genExpr(r)})"
    case E.Gt(l,r)    => s"(${genExpr(l)} > ${genExpr(r)})"
  }
}