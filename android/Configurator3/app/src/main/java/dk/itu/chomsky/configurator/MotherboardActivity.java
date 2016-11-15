package dk.itu.chomsky.configurator;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import android.widget.RadioGroup;

import java.util.ArrayList;

//buttons from the ui
import static dk.itu.chomsky.configurator.R.id.radioButtonAsus;
import static dk.itu.chomsky.configurator.R.id.radioButtonGigaBit;
import static dk.itu.chomsky.configurator.R.id.radioButtonIntel;

public class MotherboardActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_motherboard);

        //setup the button
        Button buttonArchitecture     = (Button) findViewById(R.id.buttonMbArch);
        Button buttonCpu = (Button) findViewById(R.id.buttonMbCPU);
        //get radio button data
        RadioGroup radioGroup = (RadioGroup) findViewById(R.id.RadioGroupMotherBoard);
        //final String rgValue = ((RadioButton)findViewById(radioGroup.getCheckedRadioButtonId() )).getText().toString();
        //selected radio button
        final int rgVal = radioGroup.getCheckedRadioButtonId();

        buttonArchitecture.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent arch = new Intent(MotherboardActivity.this,ArchitectureActivity.class);
                arch.putExtra("monitor",rgVal);
                startActivity(arch);
            }
        });

        buttonCpu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent arch = new Intent(MotherboardActivity.this,CPUActivity.class);
                startActivity(arch);
            }
        });



    }
}
