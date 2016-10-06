

import implicits._

object CompConf {

  val archType = new Type {
    val name = "Arc"
    val fields = pairsToFields(List(("gigs", PNum)))

  }

  val mbType = new Type {
    val name = "Motherboard"
    val fields = pairsToFields(List(("brand", PText), ("sli", PBool)))
  }

  val cpuType = new Type {
    val name = "CPU"
    val fields = pairsToFields(List(("brand", PText), ("model", PText), ("Ghz", PNum)))
  }

  val gpuType = new Type {
    val name = "GPU"
    val fields = pairsToFields(List(("brand", PText), ("model", PText), ("sli", PBool)))
  }

  // arch parameter
  val x86 = new Value {
    val _type = archType
    val fields = List(("bits", "32"))
  }
  val x64 = new Value {
    val _type = archType
    val fields = List(("bits", "64"))
  }

  val arch = SimpleParam (
    name = "Architecture",
    _type = archType,
    values = List(x86, x64),
    selected = List(0)
  )

  // motherboard parameter

  val asus = new Value {
    val _type = mbType
    val fields = List(("brand", "Asus"), ("sli", "false"))
  }
  val intel = new Value {
    val _type = mbType
    val fields = List(("brand", "Intel"), ("sli", "false"))
  }
  val gigabit = new Value {
    val _type = mbType
    val fields = List(("brand", "Gigabit"), ("sli", "true"))
  }

  val motherboard = SimpleParam (
    name = "Motherboard",
    _type = mbType,
    values = List(asus, intel, gigabit),
    selected = List(1)
  )


  // cpu parameter
  val i5 = new Value {
    val _type = cpuType
    val fields = List(("brand", "Intel"), ("model", "i5"), ("Ghz", "2.3"))
  }
  val i7 = new Value {
    val _type = cpuType
    val fields = List(("brand", "Intel"), ("model", "i7"), ("Ghz", "2.2"))
  }
  val athlon = new Value {
    val _type = cpuType
    val fields = List(("brand", "AMD"), ("model", "Athlon X4"), ("Ghz", "2.8"))
  }

  val cpu = SimpleParam (
    name = "CPU",
    _type = cpuType,
    values = List(i5, i7, athlon)
  )

  // gpu parameter
  val asusGpu = new Value {
    val _type = gpuType
    val fields = List(("brand", "Asus"), ("model", "Geforce GTX 970"))
  }
  val msi = new Value {
    val _type = gpuType
    val fields = List(("brand", "MSI"), ("model", "Geforce GTX 980"))
  }
  val sapphire = new Value {
    val _type = gpuType
    val fields = List(("brand", "Sapphire"), ("model", "Radeon RX 480 NITRO+"))
  }

  val gpu = new SimpleParam (
    name = "GPU",
    _type = gpuType,
    values = List(asusGpu, msi, sapphire),
    count = IfThenElse(FieldIs("Computer", "Motherboard", "sli")("true"), 2, 1)
  )

  val computer = new SimpleProduct("Computer", List(arch, motherboard, cpu, gpu))




  def main(args:Array[String]):Unit = {

    var model:Model = SimpleModel("Computer Model", List(computer))

    import Console._
    println("Welcome to the configurator")
    println("This is the model:")
    println(model)

    while (true) {
      println("Type a parameter name to update, or type \"quit\" to exit")
      val pname = readLine()
      if (pname.length == 0 | pname == "quit") {
        return ()
      }
      println(pname + " selected")
      println("Pick an index to select it. Choose 0 to deselect")
      val index = readInt()
      val model2 = model.updateParam("Computer", pname, index - 1)
      if (model2.isEmpty) {
        println("Updated failed! :(")
      } else {
        println("Update succeeded!")
        model = model2.get
        println(model)
      }
    }

  }
}