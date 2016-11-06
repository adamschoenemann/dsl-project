// (c) mdsebook, wasowski, tberger
//
// Run using 'sbt test'.  The output file is placed in
// 'test-out/CoffeeMachine.java'
//
// We use a minimal subset of Java, and little structure.  Almost the same
// code should be generated for C, to be used on a micro-controller (for example).
//
// The generator is primed with types to be included in the Xtext generation
// from within Eclipse, but the final integration is postponed (see Xtend
// examples).
//
//
// Lack of control-string inversion like in template languages gets in the way
// here and there.

package mdsebook.fsm.scala.transforms

import scala.collection.JavaConversions._
import mdsebook.scala.EMFScala._
import mdsebook.fsm._
import java.io.File

import org.eclipse.emf.ecore.resource.Resource
import org.eclipse.xtext.generator.IFileSystemAccess
import org.eclipse.xtext.generator.IGenerator

trait FsmCodeGenerator extends IGenerator
{
  def fmtInputs (s: State): String =
    (s.getLeavingTransitions map { "<" + _.getInput + ">" }).mkString ("|    \"","","\"")

  def fmtState (state: State): String =
    s"""
        |          case ${state.getName.toUpperCase}:
        |            switch (input) {
                       ${(state.getLeavingTransitions map {
                            fmtTransition (_) }).mkString.dropRight(1)}|            }
        |            break;
        """

  def fmtTransition (t: Transition): String =
    s"""|              case "${t.getInput}":
        |                System.out.println ("machine says: ${t.getOutput}");
        |                current = ${t.getTarget.getName.toUpperCase};
        |                break;
        """

  def compileToJava(it: FiniteStateMachine): String = {

    var i: Int = -1

    List (s"""|import java.util.Scanner;
              |
              |class FSM${it.getName.capitalize} {
              |
              """,
                 (it.getStates map { (s :State) =>
          s"""|  static final int ${s.getName.toUpperCase} = ${i = i+1; i};
          """ }) .mkString,
          s"""|
              |  static int current;

              |  static final String[] stateNames = {
              |    ${it.getStates map {'"' + _.getName + '"'} mkString (", ") }
              |  };
              |
              |  static final String[] availableInputs = {
                   ${it.getStates map { fmtInputs (_) } mkString (",\n") }
              |  };
              |
              |  public static void main (String[] args) {
              |
              |    @SuppressWarnings(value = { "resource" })
              |    Scanner scanner = new Scanner (System.in);
              |    current = ${it.getInitial.getName.toUpperCase};
              |
              |    while (true) {
              |
              |      System.out.print ("[" + stateNames[current] + "] ");
              |      System.out.print ("What is the next event? available: "
              |                           + availableInputs[current]);
              |      System.out.print ("?");
              |      String input = scanner.nextLine();
              |
              |      switch (current) {
                       ${(it.getStates map { fmtState (_) }).mkString}
              |      }
              |    }
              |  }
              |}
              |""").mkString.stripMargin
  }

  // generator of dot files
  // execute with
  // dot -Tpdf CoffeeMachine.dot -o CoffeeMachine.pdf

  def fmtTransitionDot (t: Transition): String =
    s"""|  "${t.getSource.getName}" -> "${t.getTarget.getName}"
        |      [label="${t.getInput} / ${t.getOutput}"];"""

  def fmtStateDot (s: State): String =
    (s.getLeavingTransitions.map { fmtTransitionDot (_) } mkString "\n")

  def compileToDot (it: FiniteStateMachine): String =
    s"""digraph "${it.getName}" {
       |  _init -> "${it.getInitial.getName}";
          ${it.getStates.map { fmtStateDot (_) }  mkString "\n"}
       |  ${it.getInitial.getName} [shape=doublecircle];
       |  _init [shape=point];
       |}
       |""".stripMargin


  // TODO
  override def doGenerate(resource: Resource, fsa: IFileSystemAccess) :Unit = ???

}


object FsmCodeGenerator extends FsmCodeGenerator {}
