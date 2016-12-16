package dk.itu.chomsky.configurator.scala.generators.android;

import dk.itu.chomsky.configurator.model._
import dk.itu.chomsky.configurator.scala.Utils._
import java.io.PrintWriter
import org.eclipse.emf.common.util.EList
import dk.itu.chomsky.configurator.scala.{Extractors => E}
import dk.itu.chomsky.configurator.scala.generators.common.ExprGen.genExpr

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
        android:id="@+id/scrollView1"
        android:layout_alignParentTop="true"
        android:layout_alignParentLeft="true"
        android:layout_alignParentStart="true">


        <LinearLayout
            android:orientation="vertical"
            android:layout_width="match_parent"
            android:layout_height="match_parent"
            android:id="@+id/linearLayoutHolder">


        </LinearLayout>
    </ScrollView>
    </RelativeLayout>
    """
  }
  def generateManifest(model: Model) : String = {
    s"""<?xml version="1.0" encoding="utf-8"?>
    <manifest xmlns:android="http://schemas.android.com/apk/res/android"
    package="configurator.chomsky.dsl.itu.dk.configurator">

    <application
        android:allowBackup="true"
        android:icon="@mipmap/ic_launcher"
        android:label="${model.getLabel}"
        android:supportsRtl="true"
        android:theme="@style/AppTheme">
        <activity android:name=".${model.getName}Activity">
            <intent-filter>
                <action android:name="android.intent.action.MAIN" />

                <category android:name="android.intent.category.LAUNCHER" />
            </intent-filter>
        </activity>
    </application>

    </manifest>
    """
  }

  def genConstraints(constraints:List[Constraint]):String = {
    constraints.map({
      case E.Constraint(label, expr, optParam) => {
        val egen = genExpr(expr)
        s"""
        if (${egen} == false) {
          // display error
        }
        """
      }
    }).mkString("\n")
  }

  def genTypes(types:List[EnumType]):String = {
    val in = "        "
    types.map({
      case E.EnumType(name, label, values) => {
        val vals = values.map({
          case E.EnumVal(name, label) => s"""new EnumVal("${name}", "${label}")"""
        }).mkString(s",\n${in}")
        val valArray = s"new EnumVal[] { ${vals} }"
        s"""types.put("${name}", new EnumType("${name}", "${label}", \n${in}${valArray}));"""
      }
    }).mkString("\n")
  }

  def genParam(p:Param):String = {
    val label = p.getLabel
    val labelView = s"""l1.addView(newParamLabel("${label}"), lp);"""
    val paramView = p match {
      case E.EnumParam(name, label, E.EnumType(ename, _, _)) => {
        s"""l1.addView(newEnumParam("${name}", "${label}", types.get("${ename}")), lp);"""
      }
      case E.PrimParam(name, label, ty) => {
        s"""l1.addView(new${ty}Param("${name}", "${label}"), lp);"""
      }
    }
    s"${labelView}\n${paramView}"
  }

  def genParamGroup(pg:ParamGroup):String = pg match {
    case E.ParamGroup(label, children) => {
      val childJava = children.map(genProductChild(_)).mkString("\n")
      s"""
      l1.addView(newGroupHeader("${label}"), lp);
      ${childJava}
      """
    }
  }

  def genProductChild(pc:ProductChild):String = pc match {
    case p:Param => genParam(p)
    case pg:ParamGroup => genParamGroup(pg)
  }

  def genProduct(p:Product):String = p match {
    case E.Product(name, label, children, constraints) => {
      val childJava = children.map(genProductChild(_)).mkString("\n")
      s"""
      l1.addView(newProductHeader("${label}"), lp);
      ${childJava}
      """
    }
  }

  def genModelChild(child:ModelChild):String = child match {
    case p:Product => genProduct(p)
    case pg:ProductGroup => genProductGroup(pg)
  }

  def genProductGroup(pg:ProductGroup):String = pg match {
    case E.ProductGroup(label, children) => {
      val childJava = children.map(genModelChild(_)).mkString("\n")
      s"""
      l1.addView(newGroupHeader("${label}"), lp);
      ${childJava}
      """
    }
  }

  def generateMainActivity(model:Model):String = {
    val types = eListToList[EnumType](model.getTypes)
    val product = model.getChildren.get(0).asInstanceOf[Product] // get first modelChild as Product ...
    val pChildren = eListToList[ProductChild](product.getChildren)

    val params = genProduct(product)
    val enumVals = types.map(t => eListToList(t.getValues)).flatten
    val constraints = genConstraints(eListToList(product.getConstraints))
    val typesJava = genTypes(types)
    s"""
package configurator.chomsky.dsl.itu.dk.configurator5;

import android.content.Context;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.InputType;
import android.view.ViewGroup;
import android.view.Gravity;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.view.View;
import android.widget.ScrollView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.FrameLayout;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import configurator.chomsky.dsl.itu.dk.dsl_android.R;

public class MainActivity extends AppCompatActivity {

  // this will be a map from paramName to index in the _objects array
  Map<String,Integer> parNameToIndex = new HashMap<>();
  Map<String,EnumType> types = new HashMap<>();
  Map<String,View> paramViews = new HashMap<>();

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);

    ${typesJava}

    ScrollView sv = (ScrollView) findViewById(R.id.scrollView1);

    LinearLayout l1 = (LinearLayout) findViewById(R.id.linearLayoutHolder);
    LinearLayout.LayoutParams lp =
      new LinearLayout.LayoutParams(
        LinearLayout.LayoutParams.MATCH_PARENT,
        LinearLayout.LayoutParams.WRAP_CONTENT
      );

    List<String[]> values    = new ArrayList<>();
    List<String> objectTypes = new ArrayList<>();

    ${params}

    List<Object> _objects = new ArrayList<Object>();
    Map<Integer,ArrayAdapter<CharSequence>> _adapters = new HashMap<Integer,ArrayAdapter<CharSequence>>();

    int i = 0;

    for (String o : objectTypes) {

      if (objectTypes.get(i) == "TextView") {
        TextView tv = new TextView(this);
        tv.setText(values.get(i)[0]); //it is a text, therefore should be the 0 element of the array
        _objects.add(tv);
        l1.addView((TextView)_objects.get(i));

      } else if (objectTypes.get(i) == "Spinner") {
        Spinner spinner = new Spinner(this);
        ArrayAdapter adapter =
            new ArrayAdapter(this, R.layout.support_simple_spinner_dropdown_item, values.get(i));
        adapter.setDropDownViewResource(R.layout.support_simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);

        _adapters.put(i, adapter);
        _objects.add(spinner);
        l1.addView(spinner,lp);

      } else if (objectTypes.get(i)=="EditText") {
        EditText et = new EditText(this);
        et.setInputType(InputType.TYPE_CLASS_NUMBER);
        _objects.add(i, et);
        l1.addView(et,lp);
      } else if (objectTypes.get(i)=="CheckBox") {
        CheckBox cb = new CheckBox(this);
        _objects.add(i,cb);
        l1.addView(cb,lp);

        i++;
      }

      Button submitBtn = new Button(this);
      submitBtn.setText("Submit");

      submitBtn.setOnClickListener(new View.OnClickListener() {
        public void onClick(View v) {
          checkConstraints();
        }
      });
      l1.addView(submitBtn, lp);
    }
  }

  // UI helper functions

  private TextView newParamLabel(String label) {
    TextView tv = new TextView(this);
    tv.setText(label);
    return tv;
  }

  private TextView newGroupHeader(String name) {
    TextView tv = new TextView(this);
    tv.setText(name);
    return tv;
  }

  private TextView newProductHeader(String name) {
    return newGroupHeader(name);
  }
  private View newBoolTyParam(String name, String label) {
    CheckBox cb = new CheckBox(this);
    return cb;
  }

  private View newTextTyParam(String name, String label) {
    EditText et = new EditText(this);
    return et;
  }

  private View newIntTyParam(String name, String label) {
    EditText et = new EditText(this);
    et.setInputType(InputType.TYPE_CLASS_NUMBER);
    return et;
  }

  private View newDoubleTyParam(String name, String label) {
    return newIntTyParam(name, label);
  }

  private View newEnumParam(String name, String label, EnumType type) {
    Spinner spinner = new Spinner(this);
    EnumAdapter adapter =
        new EnumAdapter(this, R.layout.support_simple_spinner_dropdown_item, type.values);
    adapter.setDropDownViewResource(R.layout.support_simple_spinner_dropdown_item);
    spinner.setAdapter(adapter);

    return spinner;
  }

  // runtime-system
  String __prim__value_ref(String valName) {
    return "value";
  }

  class ParamRef<T> {
    public final T value;
    public final String label;
    public ParamRef(T value, String label) {
      this.value = value;
      this.label = label;
    }
    T getValue() { return value; }
    String getLabel() { return label; }
  }

  ParamRef<Integer> __prim__IntTy_param_ref(String name) {
    throw new RuntimeException("not implemented");
  }

  ParamRef<Double> __prim__DoubleTy_param_ref(String name) {
    throw new RuntimeException("not implemented");
  }

  ParamRef<Boolean> __prim__BoolTy_param_ref(String name) {
    throw new RuntimeException("not implemented");
  }

  ParamRef<String> __prim__TextTy_param_ref(String name) {
    throw new RuntimeException("not implemented");
  }



  ParamRef __prim__enum_param_ref(String name) {
      throw new RuntimeException("not implemented");
  }

  // standard library
  public <T> T __prim__value(ParamRef<T> pref) {
    throw new RuntimeException("not implemented");
  }
  boolean __prim__contains(String input, String query) {
    return false;
  }
  String __prim__label(ParamRef pref) {
    return "";
  }



  void checkConstraints() {
    ${constraints}
  }
}

class EnumType {
  public final String name,label;
  public final EnumVal[] values;
  public EnumType(String name, String label, EnumVal[] values) {
    this.name = name;
    this.label = label;
    this.values = values;
  }
}

class EnumVal {
  private final String name;
  private final String label;

  public EnumVal(String name, String label) {
    this.name = name;
    this.label = label;
  }

  public String getLabel() {
    return label;
  }

  public String getName() {
    return name;
  }
}

class EnumAdapter extends ArrayAdapter<EnumVal> {

  private Context context;
  private EnumVal[] values;

  public EnumAdapter(Context context, int textViewResourceId,
                     EnumVal[] values) {
    super(context, textViewResourceId, values);
    this.context = context;
    this.values = values;
  }

  public int getCount() {
    return values.length;
  }

  public EnumVal getItem(int position) {
    return values[position];
  }

  public long getItemId(int position) {
    return position;
  }


  // And the "magic" goes here
  // This is for the "passive" state of the spinner
  @Override
  public View getView(int position, View convertView, ViewGroup parent) {
    TextView label = new TextView(context);
    label.setTextColor(Color.BLACK);
    label.setText(values[position].getLabel());

    return label;
  }

  // And here is when the "chooser" is popped up
  // Normally is the same view, but you can customize it if you want
  @Override
  public View getDropDownView(int position, View convertView,
                              ViewGroup parent) {
    TextView label = new TextView(context);
    label.setTextColor(Color.BLACK);
    label.setText(values[position].getLabel());

    return label;
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
           parNameToIndex.put("${name}", ${i+1});
         """
         (str, i+2)
       }
       case E.EnumParam(name,label, E.EnumType(ename,elabel,values)) => {
         val list = values.map(v => "\""+ v.getName+"\"" ).mkString(",")
         val str = s"""
           values.add(${i}, new String[]{"${label}"});
           objectTypes.add(${i},"TextView");
           values.add(${i+1}, new String[]{${list}});
           objectTypes.add(${i+1},"Spinner");
           parNameToIndex.put("${name}", ${i+1});
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

  // def paramToJava[Param](param:Param): String = param match{
  //   case E.PrimParam(name,label,t) => //textViews
  //     val inputType = primToType(t)

  //     s"""TextView group1Text = new TextView(this);
  //         group1Text.setText("${label}");


  //               <EditText
  //                   android:layout_width="match_parent"
  //                   android:layout_height="wrap_content"
  //                   android:inputType="$inputType"
  //                   android:ems="10"
  //                   android:id="@+id/editText$label"
  //                   android:layout_marginTop="16dp" />
  //      """
  //   case E.EnumParam(name,label, E.EnumType(ename,elabel,values)) => //
  //     val options = values.map(convertOption _).mkString("\n")

  //     s"""TextView group1Text = new TextView(this);
  //         group1Text.setText("${elabel}");


  //        <Spinner
  //             android:layout_width="match_parent"
  //             android:layout_height="wrap_content"
  //             android:id="@+id/spinner$elabel"
  //             android:layout_marginTop="16dp"/>
  //     """
  // }


  //TODO:
  //generate TextView for labels -done
  //generate Spinners  -done
  //generate groups
  //generate text field
 def pGroupToJava(c: ProductChild):String = {
    val group = c.asInstanceOf[ParamGroup]
    val children = eListToList(group.getChildren).map(childToJava _).mkString("\n")

    s"""
       //groups
        FrameLayout groupFl  = new FrameLayout(this);

        //linear layout
        LinearLayout groupLl = new LinearLayout(this);
        groupLl.setOrientation(LinearLayout.VERTICAL);
       // llgroup.setLayoutParams(new FrameLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT,50));
        TextView groupTitle  = new TextView(this);

        //title of group
        groupTitle.setText("Peripherals");
        groupTitle.setFocusable(true);


        groupTitle.setGravity(Gravity.CENTER_HORIZONTAL);
        groupTitle.setPadding(15,0,0,15);
        $children


"""
  }

 private def childToJava(c: ProductChild): String =
//   TODO: FIX PARAMTOXML HERE
    if (c.isInstanceOf[Param]) "" else pGroupToJava(c.asInstanceOf[ParamGroup])



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