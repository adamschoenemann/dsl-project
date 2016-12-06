
package dk.itu.chomsky.configurator.scala.generators.json;

import dk.itu.chomsky.configurator.model._
import dk.itu.chomsky.configurator.scala.Utils._
import dk.itu.chomsky.configurator.scala.{Extractors => E}
import dk.itu.chomsky.configurator.scala.generators.common.ExprGen.genExpr
import org.eclipse.emf.common.util.EList

object JSONGenerator {

 def generate(model:Model):String = {

   import JSON.implicits._
   import JSON._

   implicit def el2l[A](el:EList[A]) = eListToList(el)

   val types:JArray = eListToList(model.getTypes).map({
     case E.EnumType(name,label,values) => {
       val valueObjs = values.map({
         case E.EnumVal(name,label) => JObject("name" -> name, "label" -> label)
       })
       JObject("name" -> name, "label" -> label, "values" -> valueObjs)
     }
   })

   def enumValsToJson(values:List[EnumVal]):JSON =
     values.map({case E.EnumVal(name,label) => JObject("name" -> name, "label" -> label)})

   def paramToJson(param:Param):JSON = param match {
     case E.PrimParam(name, label, t) => JObject(
       "name" -> name, "label" -> label, "type" -> JString(t.toString)
     )
     case E.EnumParam(name, label, E.EnumType(ename,elabel,values)) => JObject(
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

   def constraintToJson(cons:Constraint):JSON = cons match {
     case E.Constraint(lbl, expr, param) => JObject(
       "label" -> lbl,
       "param" -> param.map((p:Param) => JString(p.getName)).getOrElse(JNull),
       "expr"  -> genExpr(expr)
     )
   }

   def productToJson(product:Product):JSON = JObject(
     "label" -> product.getLabel,
     "params" -> product.getChildren.map(productChildToJson(_)),
     "constraints" -> product.getConstraints.map(constraintToJson(_))
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
}