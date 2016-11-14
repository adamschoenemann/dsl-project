package dk.itu.chomsky.configurator.scala.generators.html;

import dk.itu.chomsky.configurator.model._
import dk.itu.chomsky.configurator.scala.Utils._
import dk.itu.chomsky.configurator.scala.{Extractors => E}
import org.eclipse.emf.common.util.EList
import scala.collection._

object HTMLGenerator {

  def generate(model:Model):String = {
    val types = eListToList[EnumType](model.getTypes)
    val product = model.getChildren.get(0).asInstanceOf[Product] // get first modelChild as Product ...
    val pChildren = eListToList[ProductChild](product.getChildren)
    val params = pChildren
     .filter(_.isInstanceOf[Param])
     .map(paramToHtml _)
     .mkString("\n")
    val groups = pChildren
     .filter(_.isInstanceOf[ParamGroup])
     .map { pGroupToHtml(_) }
     .mkString("\n")

    s"""<html>
<head>
  <title>${model.getLabel}</title>
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.0/jquery.min.js"></script>
  <link rel="stylesheet" type="text/css" href="model.css"> 
</head>
<body>
  <form class="model">
    <div class="product">
      <h2>${product.getLabel}</h2>
$params
    </div>
$groups
    <input id="submit" type="submit" value="Submit"/>
  </form>
  <script>
    $$(document).ready(function() {
      // constraint 1
      $$("#ram input").on("input change", function (evt) {
        $$this = $$(this);
        var value = $$this.val();
        if (value > 0) {
          $$this.removeClass("invalid");
        } else {
          $$this.addClass("invalid");
        }
      });
      // constraint 2
      // cpu == i5
      $$("#cpu select").on("change change", function(evt) {
        var $$this = $$(this);
        if ($$this.val() == "i5") {
          $$this.removeClass("invalid");
        } else {
          $$this.addClass("invalid");
        }
      });

      // submit logic
      $$("form").submit(function (evt) {
        evt.preventDefault();
        $$("#ram input").change();
        $$("#cpu select").change();
        return false;
      });
    });


  </script>
</body>
</html>
"""
  }

  def pGroupToHtml(c: ProductChild):String = {
    val group = c.asInstanceOf[ParamGroup]
    val children = eListToList(group.getChildren).map(childToHtml _).mkString("\n")
    
    s"""
      <fieldset>
        <legend>${group.getLabel}</legend>
${children}
      </fieldset>
"""
  }

  def paramToHtml[Param](param:Param):String = param match {
    case E.PrimParam(name, label, t) =>
      val inputType = primToType(t)
      s"""
      <div class="param" id="${name}">
        <label>${label}</label>
        <input name="${name}" type="${inputType}" />
      </div>
"""
    case E.EnumParam(name, label, E.EnumType(ename,elabel,values)) =>
      val options = values.map(convertOption _).mkString("\n")
      s"""      <div class="param" id="${ename}">
        <label>${elabel}</label>
        <select name="${ename}">
${options}
        </select>
      </div>
"""
  }

  private def convertOption(v: EnumVal): String =
    s"""          <option value="${v.getName}">${v.getLabel}</option>"""

  private def childToHtml(c: ProductChild): String =
    if (c.isInstanceOf[Param]) paramToHtml(c) else pGroupToHtml(c.asInstanceOf[ParamGroup])
  
  private def primToType(ty:PrimitiveType):String = {
    if (ty == PrimitiveType.INT_TY || ty == PrimitiveType.DOUBLE_TY)
      "number"
    else if (ty == PrimitiveType.BOOL_TY)
      "checkbox"
    else if (ty == PrimitiveType.TEXT_TY)
      "text"
    else throw new NotImplementedError("unkown primitive type")
  }

}