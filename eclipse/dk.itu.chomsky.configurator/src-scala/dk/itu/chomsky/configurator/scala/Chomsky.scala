
package dk.itu.chomsky.configurator.scala

import dk.itu.chomsky.configurator.model.{Model, Expr}
import Utils._
import dk.itu.chomsky.configurator.scala.generators.html.HTMLGenerator
import dk.itu.chomsky.configurator.scala.generators.json.JSONGenerator
import dk.itu.chomsky.configurator.scala.generators.common.ExprGen.genExpr
import dk.itu.chomsky.configurator.scala.generators.android.AndroidGenerator
import dk.itu.chomsky.configurator.scala.types._




object Chomsky {


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

 def checkExpr(expr:Expr):Option[ExprTy] = TypeChecker.checkExpr(expr)
 def generateJson(model:Model):String = JSONGenerator.generate(model)
 def generateHtml(model:Model):String = HTMLGenerator.generate(model)
 def genJSExpr(expr:Expr):String = genExpr(expr)
 def testHtmlGen(model:Model):Unit = HTMLGenerator.test(model)

 //Android
 def generateAndroidMainView(model: Model) : String  = AndroidGenerator.generateXmlLayout(model)
 def generateAndroidMainActivity(model:Model):String = AndroidGenerator.generateMainActivity(model)

}