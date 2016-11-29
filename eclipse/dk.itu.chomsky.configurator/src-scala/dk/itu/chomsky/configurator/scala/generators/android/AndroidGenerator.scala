package dk.itu.chomsky.configurator.scala.generators.android;

import dk.itu.chomsky.configurator.model._
import dk.itu.chomsky.configurator.scala.Utils._
import java.io.PrintWriter
import org.eclipse.emf.common.util.EList
import dk.itu.chomsky.configurator.scala.{Extractors => E}

object AndroidGenerator {
    // get first modelChild as Product ...
   
  
  def generateStringXml(model: Model): String = {
    
    s"""
    <resources>
    </resources>
    """
  }
  def generateView(model:Model):String = {
    val types = eListToList[EnumType](model.getTypes)
    val product = model.getChildren.get(0).asInstanceOf[Product] // get first modelChild as Product ...
    val pChildren = eListToList[ProductChild](product.getChildren)
    
    val params = pChildren
     .filter(_.isInstanceOf[Param])
     .map(paramToXml _)
     .mkString("\n")
     
    val groups = pChildren
     .filter(_.isInstanceOf[ParamGroup])
     .map { pGroupToXml(_) }
     .mkString("\n")
    val enumVals = types.map(t => eListToList(t.getValues)).flatten

    //val constraints = genConstraints(eListToList(product.getConstraints))

    s"""<?xml version="1.0" encoding="utf-8"?>
    <RelativeLayout xmlns:android="http://schemas.android.com/apk/res/android"
        xmlns:tools="http://schemas.android.com/tools"
        android:id="@+id/activity_main"
        android:layout_width="match_parent"
        android:layout_height="match_parent"
        android:paddingBottom="@dimen/activity_vertical_margin"
        android:paddingLeft="@dimen/activity_horizontal_margin"
        android:paddingRight="@dimen/activity_horizontal_margin"
        android:paddingTop="@dimen/activity_vertical_margin"
        tools:context="configurator.chomsky.dsl.itu.dk.configurator4.MainActivity">
    

     <ScrollView
        android:layout_width="match_parent"
        android:layout_height="match_parent"
        tools:ignore="UselessParent"
        android:layout_centerHorizontal="true"
        android:layout_alignParentBottom="true">

        <LinearLayout
            android:orientation="vertical"
            android:layout_width="match_parent"
            android:layout_height="wrap_content">
         
           <TextView
               android:text= "${model.getLabel}"
               android:layout_width="match_parent"
               android:layout_height="wrap_content"
               android:id="@+id/Title"
               android:textAlignment="center" />
          $params
          $groups
        
          <Button
                 android:text="@string/submit"
                 android:layout_width="match_parent"
                 android:layout_height="match_parent"
                 android:id="@+id/button_submit"
                 android:textAlignment="center" />
       </LinearLayout>
    </ScrollView>
   </RelativeLayout>
   """
  }
  
  def paramToXml[Param](param:Param): String = param match{
    case E.PrimParam(name,label,t) => //textViews
      val inputType = primToType(t)
   
      s"""
           <TextView
                    android:text="@string/textView$label"
                    android:layout_width="match_parent"
                    android:layout_height="wrap_content"
                    android:id="@+id/subTitle$label"
                    android:textAppearance="@style/TextAppearance.AppCompat"
                    android:layout_marginTop="16dp" />
    
                <EditText
                    android:layout_width="match_parent"
                    android:layout_height="wrap_content"
                    android:inputType="$inputType"
                    android:ems="10"
                    android:id="@+id/editText$label"
                    android:layout_marginTop="16dp" />
       """  
    case E.EnumParam(name,label, E.EnumType(ename,elabel,values)) => // 
      val options = values.map(convertOption _).mkString("\n")
      
      s"""
          <TextView
              android:text="@string/textView$elabel"
              android:layout_width="match_parent"
              android:layout_height="wrap_content"
              android:id="@+id/subTitle$elabel"
              android:layout_marginTop="16dp"
              android:textAppearance="@style/TextAppearance.AppCompat.Body1"/>
    
         <Spinner
              android:layout_width="match_parent"
              android:layout_height="wrap_content"
              android:id="@+id/spinner$elabel"
              android:layout_marginTop="16dp"/>
      """
  }
  
  
  //TODO:
  //generate TextView for labels -done
  //generate Spinners  -done
  //generate groups
  //generate text field
 def pGroupToXml(c: ProductChild):String = {
    val group = c.asInstanceOf[ParamGroup]
    val children = eListToList(group.getChildren).map(childToXml _).mkString("\n")

    s"""
        <FrameLayout
            android:layout_width="match_parent"
            android:layout_height="match_parent">
    
                <LinearLayout
                    android:orientation="vertical"
                    android:layout_width="match_parent"
                    android:layout_height="match_parent">
        
                    <TextView
                        android:text="@string/textView$group.getLabel"
                        android:layout_width="match_parent"
                        android:layout_height="wrap_content"
                        android:id="@+id/groupTitle"
                        android:textAppearance="@style/TextAppearance.AppCompat"
                        android:textAlignment="center" />
    
                   $children
               </LinearLayout>
        </FrameLayout>
"""
  }
 
 private def childToXml(c: ProductChild): String =
    if (c.isInstanceOf[Param]) paramToXml(c) else pGroupToXml(c.asInstanceOf[ParamGroup])
    
  private def primToType(ty:PrimitiveType):String = ty match {
      case PrimitiveType.INT_TY    => "number"
      case PrimitiveType.DOUBLE_TY => "number"
      case PrimitiveType.BOOL_TY   => "checkbox"
      case PrimitiveType.TEXT_TY   => "text"
      case _ => throw new NotImplementedError("unkown primitive type")
    }
  
  private def convertOption(v: EnumVal): String =
    s"""          <option value="${v.getName}">${v.getLabel}</option>"""
  
  
  
  
}