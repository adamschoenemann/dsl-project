
package dk.itu.chomsky.configurator.scala.types

sealed trait ExprTy
case object TyNum extends ExprTy
case object TyBool extends ExprTy
case object TyString extends ExprTy
case object TyValueRef extends ExprTy
case object TyParamRef extends ExprTy