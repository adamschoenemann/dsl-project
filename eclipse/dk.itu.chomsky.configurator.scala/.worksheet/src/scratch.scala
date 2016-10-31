object scratch {;import org.scalaide.worksheet.runtime.library.WorksheetSupport._; def main(args: Array[String])=$execute{;$skip(63); 
  
  println("Welcome to the Scala worksheet");$skip(30); 
  
  val l = List.range (0,7);System.out.println("""l  : List[Int] = """ + $show(l ));$skip(17); 
  
  println (l);$skip(35); 
  
 	val f = l foreach  { x => 1 };System.out.println("""f  : Unit = """ + $show(f ))}
  
  
}
