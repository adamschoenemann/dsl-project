

trait Dynamic[+A] {

  def get(model:Model):A
  def focus(prodn:String, paramn:String, fieldn:String)(model:Model):Option[String] = {
    val opt:Option[String] = for {
      prod  <- model.getProduct(prodn)
      param <- prod.getParam(paramn)
      value <- param.getValue(model)
      field <- value.getField(fieldn)
    } yield {
      field
    }
    opt
  }

}

case class Constant[A](value:A) extends Dynamic[A] {
  def get(model:Model) = value
}

trait Predicate extends Dynamic[Boolean] {

  def get(model:Model):Boolean = test(model)
  def test(model:Model):Boolean
}

case class FieldIs(prod:String, param:String, field:String)(expect:String) extends Predicate {
  def test(model:Model):Boolean = {
    focus(prod, param, field)(model).map(_ == expect).getOrElse(false)
  }
}

case class HasField(prod:String, param:String, field:String) extends Predicate {
  def test(model:Model):Boolean = {
    ! focus(prod, param, field)(model).isEmpty
  }
}

case class IfThenElse[A](pred:Predicate, yes:A, no:A) extends Dynamic[A] {

  def get(model:Model):A = {
    if (pred.test(model))
      yes
    else no
  }
}