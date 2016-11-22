package dk.itu.chomsky.configurator.scala.generators.html;

import dk.itu.chomsky.configurator.model._
import dk.itu.chomsky.configurator.scala.Utils._
import dk.itu.chomsky.configurator.scala.generators.json._
import dk.itu.chomsky.configurator.scala.{Extractors => E}
import dk.itu.chomsky.configurator.scala.generators.js.JSGenerator.{genJSExpr}
import org.eclipse.emf.common.util.EList
import scala.collection._
import java.io.PrintWriter

object HTMLGenerator {

  def test(model:Model):Unit = {
    val generated = generate(model);
    new PrintWriter("./test-out.html") { write(generated); close }
  }

  def genValues(values:List[EnumVal]):String = {
    val vals:List[(String,JSON)] = values.map({
      case E.EnumVal(name, lbl) => {
        import JSON.implicits._
        val obj = JObject("name" -> JString(name), "label" -> JString(lbl))
        (name, obj)
      }
    })
    val jo = JObject(vals.toMap)
    jo.serialize(0)
  }

  def genConstraints(constraints:List[Constraint]):String = {
    val constGen = constraints.map({
      case E.Constraint(l, e, param) => {
        val pname = param.map(p => "\"" + p.getName + "\"").getOrElse("null")
        s"""      if (${genJSExpr(e)} == false) { setError("$l", $pname) }"""
    }}).mkString("\n")
    s"""
    function checkErrs(evt) {
      clearErrors();
      $constGen
    }
    $$(document).ready(function() {
      $$("input").on("input change", checkErrs);
      $$("select").on("change", checkErrs);
    })
    """
  }

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
    val enumVals = types.map(t => eListToList(t.getValues)).flatten

    val constraints = genConstraints(eListToList(product.getConstraints))

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
    <div id="errors">
    </div>
    <input id="submit" type="submit" value="Submit"/>
  </form>
  <script>
    var funs = {
      "contains": function(input, query) {
        return input.indexOf(query) > -1;
      },
      "label": function(param) {
        return $$("#" + param + " select option:selected").text();
      }
    };
    var values = ${genValues(enumVals)};
    function setError(err, pname /*optional*/) {
      $$err = $$("<p>").html(err);
      if (pname !== null) {
        $$("#" + pname).append($$("<div>").addClass("has-error").append($$err));
      } else {
        $$("#errors").append($$err);
      }
      $$("#submit").addClass("has-errors");
      $$("#submit").attr("disabled", "disabled");
    }
    function clearErrors() {
      $$("#errors").empty();
      $$(".has-error").remove();
      $$("#submit").removeClass("has-errors");
      $$("#submit").removeAttr("disabled");
    }
    ${constraints}
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
      val step = formatStep(t)
      s"""
      <div class="param" id="${name}">
        <label>${label}</label>
        <input name="${name}" type="${inputType}"${step} />
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

  private def primToType(ty:PrimitiveType):String = ty match {
      case PrimitiveType.INT_TY    => "number"
      case PrimitiveType.DOUBLE_TY => "number"
      case PrimitiveType.BOOL_TY   => "checkbox"
      case PrimitiveType.TEXT_TY   => "text"
      case _ => throw new NotImplementedError("unkown primitive type")
    }

  private def formatStep(t: PrimitiveType): String =
    if (t == PrimitiveType.DOUBLE_TY) " step=\"0.01\"" else ""

}
