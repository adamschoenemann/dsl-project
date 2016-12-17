package dk.itu.chomsky.configurator.scala.generators.android;

import dk.itu.chomsky.configurator.model._
import dk.itu.chomsky.configurator.scala.Utils._
import java.io.PrintWriter
import org.eclipse.emf.common.util.EList
import dk.itu.chomsky.configurator.scala.{Extractors => E}
import dk.itu.chomsky.configurator.scala.generators.common.ExprGen.genExpr

object AndroidGenerator {

  def genConstraints(constraints:List[Constraint]):String = {
    constraints.map({
      case E.Constraint(label, expr, optParam) => {
        val egen = genExpr(expr)
        s"""
        if (${egen} == false) {
          errorView.append("${label}\\n");
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

  def generateMainActivity(model:Model):String = model match {
    case E.Model(types, children) => {
      val typesJava = genTypes(types)
      val childrenJava = children.map(genModelChild(_)).mkString("\n")
      val constraintsJava = genConstraints(children.map(getConstraints(_)).flatten)
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
import android.widget.Toast;
import android.graphics.Typeface;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import configurator5.dk.itu.dsl.chomsky.configurator.configurator.R;

public class MainActivity extends AppCompatActivity {

  // this will be a map from paramName to index in the _objects array
  Map<String, EnumType> types = new HashMap<>();
  Map<String, ParamView> paramViews = new HashMap<>();
  TextView errorView = null;

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

    ${childrenJava}

    errorView = new TextView(this);
    errorView.setTextColor(Color.RED);
    l1.addView(errorView, lp);

    Button submitBtn = new Button(this);
    submitBtn.setText("Submit");

    submitBtn.setOnClickListener(new View.OnClickListener() {
      public void onClick(View v) {
        errorView.setText("");
        checkConstraints();
      }
    });
    l1.addView(submitBtn, lp);
  }

  // UI helper functions

  private TextView newParamLabel(String label) {
    TextView tv = new TextView(this);
    tv.setText(label);
    return tv;
  }

  private TextView newGroupHeader(String name) {
    TextView tv = new TextView(this);
    tv.setTextSize(1.05f * tv.getTextSize());
    tv.setText(name);
    return tv;
  }

  private TextView newProductHeader(String name) {
    TextView tv = new TextView(this);
    tv.setTextSize(1.1f * tv.getTextSize());
    tv.setTypeface(Typeface.defaultFromStyle(Typeface.BOLD));
    tv.setText(name);
    return tv;
  }
  private View newBoolTyParam(String name, String label) {
    CheckBox cb = new CheckBox(this);
    paramViews.put(name, new ParamView(label, cb));
    return cb;
  }

  private View newTextTyParam(String name, String label) {
    EditText et = new EditText(this);
    paramViews.put(name, new ParamView(label, et));
    return et;
  }

  private View newIntTyParam(String name, String label) {
    EditText et = new EditText(this);
    et.setInputType(InputType.TYPE_CLASS_NUMBER);
    et.setText("0");
    paramViews.put(name, new ParamView(label, et));
    return et;
  }

  private View newDoubleTyParam(String name, String label) {
    return newIntTyParam(name, label);
  }

  private View newEnumParam(String name, String label, EnumType type) {
    Spinner spinner = new Spinner(this);
    paramViews.put(name, new ParamView(label, spinner));
    EnumAdapter adapter =
            new EnumAdapter(this, R.layout.support_simple_spinner_dropdown_item, type.values);
    adapter.setDropDownViewResource(R.layout.support_simple_spinner_dropdown_item);
    spinner.setAdapter(adapter);
    return spinner;
  }

  // runtime-system
  String __prim__value_ref(String valName) {
    return valName;
  }

  boolean __prim__equals(Object a, Object b) {
    return a.equals(b);
  }

  static class ParamRef<T> {
    public final T value;
    public final String label;
    public ParamRef(T value, String label) {
      this.value = value;
      this.label = label;
    }
    T getValue() { return value; }
    String getLabel() { return label; }
  }

  static class ParamView {
    public final String label;
    public final View view;
    public ParamView(String label, View view) {
      this.label = label;
      this.view  = view;
    }
  }

  ParamRef<Integer> __prim__IntTy_param_ref(String name) {
    ParamView pv = paramViews.get(name);
    EditText et = (EditText)pv.view;
    Integer value = Integer.parseInt(et.getText().toString());
    return new ParamRef<Integer>(value, pv.label);
  }

  ParamRef<Double> __prim__DoubleTy_param_ref(String name) {
    ParamView pv = paramViews.get(name);
    EditText et = (EditText)pv.view;
    Double value = Double.parseDouble(et.getText().toString());
    return new ParamRef<Double>(value, pv.label);
  }

  ParamRef<Boolean> __prim__BoolTy_param_ref(String name) {
    ParamView pv = paramViews.get(name);
    CheckBox cb = (CheckBox)pv.view;
    Boolean value = cb.isEnabled();
    return new ParamRef<Boolean>(value, pv.label);
  }

  ParamRef<String> __prim__TextTy_param_ref(String name) {
    ParamView pv = paramViews.get(name);
    EditText et = (EditText)pv.view;
    String value = et.getText().toString();
    return new ParamRef<String>(value, pv.label);
  }

  ParamRef<String> __prim__enum_param_ref(String name) {
    ParamView pv = paramViews.get(name);
    Spinner spinner = (Spinner)pv.view;
    EnumVal value = (EnumVal)spinner.getSelectedItem();
    return new ParamRef<String>(value.getName(), value.getLabel());
  }

  // standard library
  public <T> T __prim__value(ParamRef<T> pref) {
    return pref.value;
  }
  boolean __prim__contains(String input, String query) {
    return input.indexOf(query) > -1;
  }
  String __prim__label(ParamRef pref) {
    return pref.label;
  }



  void checkConstraints() {
    ${constraintsJava}
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
  }

  def getConstraints(mc:ModelChild):List[Constraint] = mc match {
    case E.ProductGroup(_, children) => children.map(getConstraints(_)).flatten
    case E.Product(_,_,_,constraints) => constraints
  }

}