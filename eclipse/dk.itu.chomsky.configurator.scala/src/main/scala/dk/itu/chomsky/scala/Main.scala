// (c) mddbook, wasowski, tberger
// Example constraints implemented for the FSM models in Scala
// This is the main runner for the constraints example
// Run using 'sbt run'
package dk.itu.chomsky.configurator.scala

import mdsebook.scala.EMFScala._
// import dk.itu.chomsky.configurator.FiniteStateMachine
import dk.itu.chomsky.configurator.model.ModelPackage
import org.eclipse.emf.common.util.URI
import org.eclipse.emf.ecore.EObject
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl
import org.eclipse.emf.ecore.resource.Resource
import org.eclipse.emf.ecore.util.EcoreUtil
import org.eclipse.emf.ecore.xmi.impl.XMIResourceFactoryImpl



object Main extends App {

  // register a resource factory for XMI files
  Resource.Factory.Registry.INSTANCE.
    getExtensionToFactoryMap.put("xmi", new XMIResourceFactoryImpl)

  // register the package magic (impure)
  ModelPackage.eINSTANCE.eClass

  println("wooow!")
  // load the XMI file
  // val uri: URI = URI.createURI ("../dk.itu.chomsky.configurator/test-files/test-02.xmi") // <-- change file name here
  // val resource: Resource = (new ResourceSetImpl).getResource (uri, true)

  // http://download.eclipse.org/modeling/emf/emf/javadoc/2.11/org/eclipse/emf/ecore/util/EcoreUtil.html#getAllProperContents%28org.eclipse.emf.ecore.resource.Resource,%20boolean%29
  // val content :Iterator[EObject] =
    // EcoreUtil.getAllProperContents[EObject] (resource, false)

  // if (content.forall { eo => Constraints.invariants.forall (_ check eo) })
  //   println ("All constraints are satisfied!")
  // else
  //   println ("Some constraint is violated!")
}
