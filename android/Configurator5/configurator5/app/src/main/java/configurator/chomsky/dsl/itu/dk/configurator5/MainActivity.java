package configurator.chomsky.dsl.itu.dk.configurator5;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.InputType;
import android.view.Gravity;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.Spinner;
import android.widget.TextView;


import org.w3c.dom.Text;

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


        values.add(0, new String[]{"Architecture"});
        objectTypes.add(0,"TextView");
        values.add(1, new String[]{"x64","x86"});
        objectTypes.add(1,"Spinner");


        values.add(2, new String[]{"CPU"});
        objectTypes.add(2,"TextView");
        values.add(3, new String[]{"i5","i7","x4"});
        objectTypes.add(3,"Spinner");


        values.add(4, new String[]{"GPU"});
        objectTypes.add(4,"TextView");
        values.add(5, new String[]{"gtx970","gtx980","rx480"});
        objectTypes.add(5,"Spinner");


        values.add(6, new String[]{"RAM"});
        objectTypes.add(6,"TextView");
        values.add(7, new String[]{""});
        objectTypes.add(7,"EditText");


        values.add(8, new String[]{"Engraving"});
        objectTypes.add(8,"TextView");
        values.add(9, new String[]{""});
        objectTypes.add(9,"EditText");


        values.add(10, new String[]{"Deliver"});
        objectTypes.add(10,"TextView");
        values.add(11, new String[]{""});
        objectTypes.add(11,"CheckBox");


        values.add(12, new String[]{"GHz"});
        objectTypes.add(12,"TextView");
        values.add(13, new String[]{""});
        objectTypes.add(13,"EditText");

        values.add(14,new String[]{"Peripherals"});
        objectTypes.add(14,"Group");

        values.add(15, new String[]{"CPU2"});
        objectTypes.add(15,"TextView");
        values.add(16, new String[]{"i5","i7","x4"});
        objectTypes.add(16,"Spinner");

        values.add(17, new String[]{"GPU2"});
        objectTypes.add(17,"TextView");
        values.add(18, new String[]{"gtx970","gtx980","rx480"});
        objectTypes.add(18,"Spinner");

        values.add(19,new String[]{"Peripherals"});
        objectTypes.add(19,"Group");

        values.add(20, new String[]{"CPU2"});
        objectTypes.add(20,"TextView");
        values.add(21, new String[]{"i5","i7","x4"});
        objectTypes.add(21,"Spinner");
/*
        values.add(14,new String[]{"Peripherals"});
        objectTypes.add(14,"Group");

        values.add(15, new String[]{"Keyboard"});
        objectTypes.add(15,"TextView");
        values.add(16, new String[]{"Logitec 28364XL","Microsoft Keyboard396","Apple Keyboard rx480"});
        objectTypes.add(16,"Spinner");
        /*
        values.add(17, new String[]{"Mouse"});
        objectTypes.add(17,"TextView");

        /*
        values.add(18, new String[]{"Logitec Mousy325465","Microsoft Mousy24","Apple Mouse 33rx480"});
        objectTypes.add(18,"Spinner");
*/
        List<Object> _objects = new ArrayList<Object>();
        Map<Integer,ArrayAdapter<CharSequence>>_adapters = new HashMap<Integer,ArrayAdapter<CharSequence>>();



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

            }else if(objectTypes.get(i) =="Group")
            {
                //groups
                FrameLayout groupFl  = new FrameLayout(this);

                //linear layout
                LinearLayout groupLl = new LinearLayout(this);
                groupLl.setOrientation(LinearLayout.VERTICAL);
                // llgroup.setLayoutParams(new FrameLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT,50));
                _objects.add(i,new TextView(this));

                ((TextView) _objects.get(i)).setText(values.get(i)[0]);//
                ((TextView) _objects.get(i)).setGravity(Gravity.CENTER_HORIZONTAL);
                ((TextView) _objects.get(i)).setPadding(15,0,0,15);
                //title of group


                groupLl.addView(((TextView) _objects.get(i)));
                groupFl.addView(groupLl);
                l1.addView(groupFl);
            }

            i++;
        }



        //Button
        Button myButton = new Button(this);
        myButton.setText("Submit");
        //myButton.setLayoutParams(new FrameLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT,50));
        l1.addView(myButton, lp);
    }
}

   