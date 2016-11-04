
package dk.itu.chomsky.configurator.scala.generators.js;
import dk.itu.chomsky.configurator.model.Expr
import dk.itu.chomsky.configurator.scala.{Extractors => E}

object JSGenerator {

  def genJSExpr(expr:Expr):String = expr match {
    case E.ConstNum(x)    => x.toString
    case E.ConstBool(x)   => x.toString
    case E.ConstString(x) => "\"" + x + "\""
    case E.ValueRef(E.EnumVal(name,_))    => s"""values["$name"]"""
    case E.ParamValueRef(param)    => param match {
      case E.PrimParam(name,label,ty) => "$(\"#" + name + " input\").val()"
      case E.EnumParam(name,label,E.EnumType(ename,elabel,_))  =>
        "$(\"#" + name + " select\").val()"
    }
    case E.Not(e)  => "!(" + genJSExpr(e) + ")"
    case E.ITE(g, t, f) => s"(${genJSExpr(g)} ? (${genJSExpr(t)}) : (${genJSExpr(f)}))"
    case E.FunApp(name, args) => "a function definition"
    case E.Plus(l,r)  => genJSExpr(l) + " + "  + genJSExpr(r)
    case E.Minus(l,r) => genJSExpr(l) + " - "  + genJSExpr(r)
    case E.Mult(l,r)  => genJSExpr(l) + " * "  + genJSExpr(r)
    case E.Div(l,r)   => genJSExpr(l) + " / "  + genJSExpr(r)
    case E.Eq(l,r)    => genJSExpr(l) + " == " + genJSExpr(r)
    case E.And(l,r)   => genJSExpr(l) + " && " + genJSExpr(r)
    case E.Or(l,r)    => genJSExpr(l) + " || " + genJSExpr(r)
    case E.Leq(l,r)   => genJSExpr(l) + " <= " + genJSExpr(r)
    case E.Lt(l,r)    => genJSExpr(l) + " < "  + genJSExpr(r)
    case E.Geq(l,r)   => genJSExpr(l) + " >= " + genJSExpr(r)
    case E.Gt(l,r)    => genJSExpr(l) + " > "  + genJSExpr(r)
  }
}