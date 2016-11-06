package mdsebook.fsm.scala.transforms

import org.bitbucket.inkytonik.kiama.rewriting.Rewriter._

import scala.collection.JavaConversions._

import org.eclipse.emf.common.util.Diagnostic
import org.eclipse.emf.common.util.URI
import org.eclipse.emf.ecore.resource.Resource
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl
import org.eclipse.emf.ecore.util.Diagnostician
import org.eclipse.emf.ecore.util.EcoreUtil
import org.eclipse.emf.ecore.xmi.impl.XMIResourceFactoryImpl

import mdsebook.scala.EMFScala._

import mdsebook.fsm
import mdsebook.{ petrinet => pn }
import org.eclipse.emf.ecore.EObject

// Notes for lecture:
// - with rules you copy
// - you need to have a strategy (or scheduling); different kinds of scheduling
// - primarily good for Endotransformations
// - to use it with EMF we switch (slightly) to meta-level

abstract class FsmToPetriNetWithKiama extends CopyingTrafo[fsm.Model, pn.Model] {

  val pFactory = pn.PetrinetFactory.eINSTANCE

  val state2place = rule[EObjectInKiama] {

    case s :fsm.State =>  pFactory.createPlace before { p =>
        p setName s.getName
        p setTokenNo (if (s.getMachine.getInitial == s) 1 else 0) }
  }

  val transition2transition = rule[EObjectInKiama] {

    // scheduling should achieve something like this (bottom up?)
    // places -> transitions -> ned transitions -> petri nets -> models

    case t :fsm.Transition => pFactory.createTransition before { p =>
      p.setInput (t.getInput)
      p.getFromPlace.add (???) // TODO: use a query to find the right place object
      p.getToPlace.add (???) // TODO: use a query to find the right place object
      // TODO: we need to bind somehow the collection of places though ...
    }

  }

//  lazy rule EndState2ThrowAwayTransition{
//	  from s: FMM!State
//	  to st: PMM!Transition(
//		input<-'',
//		fromPlace<-thisModule.resolveTemp( s.machine, 'lrt' ).places->
//			select( e | e.name=s.name ) )
//}

  val machine2petrinet = rule[EObjectInKiama] {
    case m :fsm.FiniteStateMachine => pFactory.createPetriNet
  } // todo: recurse into states

  val model2model = rule[EObjectInKiama] {
    case m :fsm.Model => pFactory.createModel
  } // todo combine with all strategy for children?


}
