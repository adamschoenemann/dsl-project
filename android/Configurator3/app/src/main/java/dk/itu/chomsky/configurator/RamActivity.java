package dk.itu.chomsky.configurator;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;

public class RamActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ram);

        Button buttonCpu = (Button) findViewById(R.id.buttonRamCpu);


        buttonCpu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent arch = new Intent(RamActivity.this,CPUActivity.class);
                startActivity(arch);


            }


        });

        RadioButton ram8 = (RadioButton) findViewById(R.id.radioButton13);
        RadioButton ram16 = (RadioButton) findViewById(R.id.radioButton14);

        if (MyApp.constraint_is64){
            ram8.setVisibility((View.VISIBLE));
            ram16.setVisibility((View.VISIBLE));


        }else {

            ram8.setVisibility((View.INVISIBLE));
            ram16.setVisibility((View.INVISIBLE));

        }
    }
}
