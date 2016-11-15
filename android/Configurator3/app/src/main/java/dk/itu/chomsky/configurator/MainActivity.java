package dk.itu.chomsky.configurator;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //setup the button
        Button buttonNext = (Button) findViewById(R.id.buttonMonitorArch);

        buttonNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent arch = new Intent(MainActivity.this,ArchitectureActivity.class);
                startActivity(arch);
            }
        });

    }

    public void onRadioButtonClicked(View view) {
        // Is the button now checked?
        boolean checked = ((RadioButton) view).isChecked();

        // Check which radio button was clicked
        switch(view.getId()) {
            case R.id.radioButton1:
                if (checked)
                    // One
                    break;
            case R.id.radioButton2:
                if (checked)
                    // Two
                    break;
            case R.id.radioButton3:
                if (checked)
                    // Three
                    break;
            case R.id.radioButton4:
                if (checked)
                    // Four
                    break;
        }
    }




}
