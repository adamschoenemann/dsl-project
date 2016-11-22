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

        //Monitor
        Spinner spinnerMonitor = (Spinner) findViewById(R.id.spinnerMonitor);
        String[] monitorArray = {"23 HP curved2000", "22 Asus 1000", "19 Asus Widescreen1000", "19 Asus 800"};


        ArrayAdapter<CharSequence> adapterMonitor = new ArrayAdapter (this, R.layout.support_simple_spinner_dropdown_item, monitorArray);
        adapterMonitor.setDropDownViewResource(R.layout.support_simple_spinner_dropdown_item);
        spinnerMonitor.setAdapter(adapterMonitor);

        //Architecture
        Spinner spinnerArchitecture = (Spinner) findViewById(R.id.spinnerArchitecture);
        String[] architectureArray = {"64 bit", "32 bit"};
        ArrayAdapter<CharSequence> adapterArchitecture = new ArrayAdapter (this, R.layout.support_simple_spinner_dropdown_item, architectureArray);
        adapterArchitecture.setDropDownViewResource(R.layout.support_simple_spinner_dropdown_item);
        spinnerArchitecture.setAdapter(adapterArchitecture);

        //CPU
        Spinner spinnerCpu = (Spinner) findViewById(R.id.spinnerCpu);
        String[] cpuArray = {"64 bit", "32 bit"};
        ArrayAdapter<CharSequence> adapterCpu = new ArrayAdapter (this, R.layout.support_simple_spinner_dropdown_item, cpuArray);
        adapterCpu.setDropDownViewResource(R.layout.support_simple_spinner_dropdown_item);
        spinnerCpu.setAdapter(adapterCpu);


    }
}
