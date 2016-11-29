
package dk.itu.chomsky.configurator.scala.generators.js;
import dk.itu.chomsky.configurator.model.Expr
import dk.itu.chomsky.configurator.scala.{Extractors => E}

object JSGenerator {

  def genJSExpr(expr:Expr):String = expr match {
    case E.ConstNum(x)    => x.toString
    case E.ConstBool(x)   => x.toString
    case E.ConstString(x) => "\"" + x + "\""
    case E.ValueRef(E.EnumVal(name,_))    => s"""values["$name"].name"""
    case E.ParamValueRef(param)    => param match {
      case E.PrimParam(name,label,ty) => "$(\"#" + name + " input\").val()"
      case E.EnumParam(name,label,E.EnumType(ename,elabel,_))  =>
        "$(\"#" + name + " select\").val()"
    }
    case E.Not(e)  => "!" + genJSExpr(e)
    case E.Neg(e)  => "-" + genJSExpr(e)
    case E.ITE(g, t, f) => s"(${genJSExpr(g)} ? (${genJSExpr(t)}) : (${genJSExpr(f)}))"
    case E.FunApp(name, args) => {
      val fnref = s"""funs["$name"]"""
      val argslist = "[" + args.map(genJSExpr(_)).mkString(", ") + "]"
      s"$fnref.apply(funs, $argslist)"
    }
    case E.Plus(l,r)  => s"(${genJSExpr(l)} + ${genJSExpr(r)})"
    case E.Minus(l,r) => s"(${genJSExpr(l)} - ${genJSExpr(r)})"
    case E.Mult(l,r)  => s"(${genJSExpr(l)} * ${genJSExpr(r)})"
    case E.Div(l,r)   => s"(${genJSExpr(l)} / ${genJSExpr(r)})"
    case E.Eq(l,r)    => s"(${genJSExpr(l)} == ${genJSExpr(r)})"
    case E.And(l,r)   => s"(${genJSExpr(l)} && ${genJSExpr(r)})"
    case E.Or(l,r)    => s"(${genJSExpr(l)} || ${genJSExpr(r)})"
    case E.Leq(l,r)   => s"(${genJSExpr(l)} <= ${genJSExpr(r)})"
    case E.Lt(l,r)    => s"(${genJSExpr(l)} < ${genJSExpr(r)})"
    case E.Geq(l,r)   => s"(${genJSExpr(l)} >= ${genJSExpr(r)})"
    case E.Gt(l,r)    => s"(${genJSExpr(l)} > ${genJSExpr(r)})"
  }
}