package configurator.chomsky.dsl.itu.dk.configurator4;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Spinner spinner1 = (Spinner) findViewById(R.id.spinner1);
        String[] monitorArray = {"23 HP curved2000", "22 Asus 1000", "19 Asus Widescreen1000", "19 Asus 800"};


        ArrayAdapter<CharSequence> adapterMonitor = new ArrayAdapter (this, R.layout.support_simple_spinner_dropdown_item, monitorArray);
        adapterMonitor.setDropDownViewResource(R.layout.support_simple_spinner_dropdown_item);
        spinner1.setAdapter(adapterMonitor);



    }
}
