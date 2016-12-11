package configurator.chomsky.dsl.itu.dk.configurator5;

import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutCompat;
import android.text.InputType;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.ScrollView;
import android.widget.Spinner;
import android.widget.TextView;


import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

public class MainActivity extends AppCompatActivity {

    /**
     * ATTENTION: This was auto-generated to implement the App Indexing API.
     * See https://g.co/AppIndexing/AndroidStudio for more information.
     */


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        ScrollView sv=(ScrollView)  findViewById(R.id.scrollView1);

        LinearLayout l1 = (LinearLayout) findViewById(R.id.linearLayout8);
        LinearLayout.LayoutParams lp = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT);



        List<String[]> værdier = new ArrayList<>();
        List<String> objtype=new ArrayList<>() ;

        //tekstObjects.add(0, "Monitor");
        værdier.add(0, new String[]{"Monitor"});
        objtype.add(0,"TextView");
        værdier.add(1, new String[]{"23 HP curved2000", "22 Asus 1000", "19 Asus Widescreen1000", "19 Asus 800"});
        objtype.add(1,"Spinner");
        værdier.add(2, new String[]{"Architecture"});
        objtype.add(2,"TextView");
        værdier.add(3, new String[]{"64 bit", "32 bit"});
        objtype.add(3,"Spinner");
        værdier.add(4, new String[]{"CPU"});
        objtype.add(4,"TextView");
        værdier.add(5, new String[]{"64 bit", "32 bit"});
        objtype.add(5,"Spinner");
        værdier.add(6, new String[]{"GPU"});
        objtype.add(6,"TextView");
        værdier.add(7, new String[]{"Nvidia", "amd"});
        objtype.add(7,"Spinner");
        værdier.add(8, new String[]{"Mouse"});
        objtype.add(8,"TextView");
        værdier.add(9, new String[]{"Deathadder", "logitec G19"});
        objtype.add(9,"Spinner");
        værdier.add(10, new String[]{"RAM"});
        objtype.add(10,"TextView");
        værdier.add(11, new String[]{""});
        objtype.add(11,"EditText");
        værdier.add(12, new String[]{"Deliver"});
        objtype.add(12,"TextView");
        værdier.add(13, new String[]{""});
        objtype.add(13,"CheckBox");

        // List<TextView> txtViews = new ArrayList<TextView>();
        //      List<Object> txtViews = new ArrayList<Object>();
        List<Object> _objects = new ArrayList<Object>();

        //List<Spinner> _objects = new ArrayList<Spinner>();
        Map<Integer,ArrayAdapter<CharSequence>>_adapters = new HashMap<Integer,ArrayAdapter<CharSequence>>();
       // List<ArrayAdapter<CharSequence>> _adapters = new ArrayList<ArrayAdapter<CharSequence>>();
        //    String[] strvalues = {"testværdi1", "testværdi2"};

        int i = 0;

        for (String o : objtype) {


            if(objtype.get(i) == "TextView"){
                _objects.add( new TextView(this));
                ((TextView)_objects.get(i)).setText(værdier.get(i)[0]); //so it is  a text therefore should be the 0 element of the array
                l1.addView((TextView)_objects.get(i));

            }else if (objtype.get(i)=="Spinner")
            {

                _objects.add(new Spinner(this));
                _adapters.put(i, new ArrayAdapter(this, R.layout.support_simple_spinner_dropdown_item, værdier.get(i)));
                _adapters.get(i).setDropDownViewResource(R.layout.support_simple_spinner_dropdown_item);
                ((Spinner)_objects.get(i)).setAdapter(_adapters.get(i));
                l1.addView((Spinner)_objects.get(i),lp);

            } else if (objtype.get(i)=="EditText")
            {
                _objects.add(i, new EditText(this));
                ((EditText)_objects.get(i)).setInputType(InputType.TYPE_CLASS_NUMBER);
                l1.addView((EditText)_objects.get(i),lp);

            }else if (objtype.get(i)=="CheckBox")
            {
                _objects.add(i,new CheckBox(this));
                l1.addView((CheckBox)_objects.get(i),lp);


            }


            i++;
        }

        Button myButton = new Button(this);
        myButton.setText("push me");
        l1.addView(myButton, lp);

    }




}