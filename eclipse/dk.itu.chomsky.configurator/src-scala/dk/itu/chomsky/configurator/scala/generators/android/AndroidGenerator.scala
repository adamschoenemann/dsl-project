package dk.itu.chomsky.configurator.scala.generators.android;

import dk.itu.chomsky.configurator.model._
import dk.itu.chomsky.configurator.scala.Utils._
import java.io.PrintWriter
import org.eclipse.emf.common.util.EList
import dk.itu.chomsky.configurator.scala.{Extractors => E}

object AndroidGenerator {

   
  //generate layout
  def generateXmlLayout(model: Model): String = {
    
    s"""   
     <?xml version="1.0" encoding="utf-8"?>
<RelativeLayout xmlns:android="http://schemas.android.com/apk/res/android"
    xmlns:tools="http://schemas.android.com/tools"
    android:id="@+id/activity_main"
    android:layout_width="match_parent"
    android:layout_height="match_parent"
    android:paddingBottom="@dimen/activity_vertical_margin"
    android:paddingLeft="@dimen/activity_horizontal_margin"
    android:paddingRight="@dimen/activity_horizontal_margin"
    android:paddingTop="@dimen/activity_vertical_margin"
    tools:context="configurator.chomsky.dsl.itu.dk.configurator5.MainActivity">

    <ScrollView
        android:layout_width="match_parent"
        android:layout_height="match_parent"
        tools:ignore="UselessParent"
        android:layout_centerHorizontal="true"
        android:layout_alignParentBottom="true"
        android:id="@+id/scrollView1">

        <LinearLayout
            android:orientation="vertical"
            android:layout_width="match_parent"
            android:layout_height="match_parent"
            android:id="@+id/linearLayoutHolder">

        </LinearLayout>

        </LinearLayout>
    </ScrollView>
</RelativeLayout>
    """
  }
  def generateManifest(model: Model) : String ={
    s"""
     <?xml version="1.0" encoding="utf-8"?>
    <manifest xmlns:android="http://schemas.android.com/apk/res/android"
    package="configurator.chomsky.dsl.itu.dk.configurator5">

    <application
        android:allowBackup="true"
        android:icon="@mipmap/ic_launcher"
        android:label="${model.getLabel}"
        android:supportsRtl="true"
        android:theme="@style/AppTheme">
        <activity android:name=".MainActivity">
            <intent-filter>
                <action android:name="android.intent.action.MAIN" />

                <category android:name="android.intent.category.LAUNCHER" />
            </intent-filter>
        </activity>
    </application>

    </manifest>
    """
  }
  
  def generateMainActivity(model:Model):String = {
    val types = eListToList[EnumType](model.getTypes)
    val product = model.getChildren.get(0).asInstanceOf[Product] // get first modelChild as Product ...
    val pChildren = eListToList[ProductChild](product.getChildren)
    
    val params = pChildren
     .filter(_.isInstanceOf[Param])
     .foldLeft((List[String](),0)) ((acc, p) => {
       val (str, acc2) = paramToJava(p,acc._2)
       (acc._1 :+ str, acc2)
     })
     ._1
     .mkString("\n")
     
    val groups = pChildren
     .filter(_.isInstanceOf[ParamGroup])
     .map { pGroupToXml(_) }
     .mkString("\n")
    val enumVals = types.map(t => eListToList(t.getValues)).flatten

    //val constraints = genConstraints(eListToList(product.getConstraints))

    s"""
     package configurator.chomsky.dsl.itu.dk.configurator5;

     import android.support.v7.app.AppCompatActivity;
     import android.os.Bundle;
     import android.text.InputType;
     import android.widget.ArrayAdapter;
     import android.widget.Button;
     import android.widget.CheckBox;
     import android.widget.EditText;
     import android.widget.LinearLayout;
     import android.widget.ScrollView;
     import android.widget.Spinner;
     import android.widget.TextView;


     import java.util.ArrayList;
     import java.util.HashMap;
     import java.util.List;
     import java.util.Map;

     public class MainActivity extends AppCompatActivity {
       @Override
       protected void onCreate(Bundle savedInstanceState) {
          super.onCreate(savedInstanceState);
          setContentView(R.layout.activity_main);
  
          ScrollView sv=(ScrollView)  findViewById(R.id.scrollView1);
  
          LinearLayout l1 = (LinearLayout) findViewById(R.id.linearLayoutHolder);
          LinearLayout.LayoutParams lp = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT);
  
  
          List<String[]> values    = new ArrayList<>();
          List<String> objectTypes = new ArrayList<>() ;
          
          $params
          
          int i = 0;

          for (String o : objectTypes) {
  
  
              if(objectTypes.get(i) == "TextView"){
                  _objects.add( new TextView(this));
                  ((TextView)_objects.get(i)).setText(values.get(i)[0]); //it is a text, therefore should be the 0 element of the array
                  l1.addView((TextView)_objects.get(i));
  
              }else if (objectTypes.get(i)=="Spinner")
              {
  
                  _objects.add(new Spinner(this));
                  _adapters.put(i, new ArrayAdapter(this, R.layout.support_simple_spinner_dropdown_item, values.get(i)));
                  _adapters.get(i).setDropDownViewResource(R.layout.support_simple_spinner_dropdown_item);
                  ((Spinner)_objects.get(i)).setAdapter(_adapters.get(i));
                  l1.addView((Spinner)_objects.get(i),lp);
  
              } else if (objectTypes.get(i)=="EditText")
              {
                  _objects.add(i, new EditText(this));
                  ((EditText)_objects.get(i)).setInputType(InputType.TYPE_CLASS_NUMBER);
                  l1.addView((EditText)_objects.get(i),lp);
  
              }else if (objectTypes.get(i)=="CheckBox")
              {
                  _objects.add(i,new CheckBox(this));
                  l1.addView((CheckBox)_objects.get(i),lp);
  
              }
  
              i++;
          }        
  
          Button myButton = new Button(this);
          myButton.setText("Submit");
          l1.addView(myButton, lp);
      }
    }

   """
  }
   def paramToJava[Param](param: Param, i: Int):(String,Int) = {
    
     param match {
     
       case E.PrimParam(name,label,t) => {//textViews
         val (inputType, step) = primToAndroidType(t)
        
         val str = s"""      
           values.add(${i}, new String[]{"${label}"});
           objectTypes.add(${i},"TextView");
           values.add(${i+1}, new String[]{""});
           objectTypes.add(${i+1},"${inputType}");
         """
         (str, i+2)
       }
       case E.EnumParam(name,label, E.EnumType(ename,elabel,values)) => {
         val list = values.map(v => "\"" + v.getName + "\"").mkString(",")
         val str = s"""
           values.add(${i}, new String[]{"${label}"});
           objectTypes.add(${i},"TextView");
           values.add(${i+1}, new String[]{"${list}"});
           objectTypes.add(${i+1},"Spinner");
         """
         (str, i+2)
       }
     }
   }
    
   private def convertToValues(values: List[EnumVal]) : String = {
     val list = values.mkString(",")
     s""" "${list}" """
   } 
   
   private def primToAndroidType(ty:PrimitiveType):(String, String) = ty match {
      case PrimitiveType.INT_TY    => ("EditText", "")
      case PrimitiveType.DOUBLE_TY => ("EditText", " step=\"0.01\"")
      case PrimitiveType.BOOL_TY   => ("CheckBox", "")
      case PrimitiveType.TEXT_TY   => ("EditText", "")
      case _ => throw new NotImplementedError("unkown primitive type")
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