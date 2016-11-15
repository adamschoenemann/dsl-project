package dk.itu.chomsky.configurator;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

public class ArchitectureActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_architecture);



        //setup the button
        Button buttonMonitor     = (Button) findViewById(R.id.buttonMonitor);
        Button buttonMotherboard = (Button) findViewById(R.id.buttonMotherboard);

        buttonMonitor.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent arch = new Intent(ArchitectureActivity.this,MainActivity.class);
                startActivity(arch);
            }
        });

        buttonMotherboard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent arch = new Intent(ArchitectureActivity.this,MotherboardActivity.class);
                startActivity(arch);
            }
        });


        //set up architecture
        RadioButton rb32 = (RadioButton) findViewById(R.id.radioButton32);
        RadioButton rb64 = (RadioButton) findViewById(R.id.radioButton64);
        RadioGroup selection = (RadioGroup) findViewById(R.id.radioGroupArchitecture);

        selection.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener(){

            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
               // Context context = getApplicationContext();
               // int duration = Toast.LENGTH_SHORT;

                //Toast toast = Toast.makeText(context,"selected : "+ i,duration);
                //toast.show();

                switch (i) {
                    case R.id.radioButton32:

                        MyApp.constraint_is64 = false;
                        break;
                    case R.id.radioButton64:
                        MyApp.constraint_is64 = true;
                        break;
                }
            }
        });



    }


}
