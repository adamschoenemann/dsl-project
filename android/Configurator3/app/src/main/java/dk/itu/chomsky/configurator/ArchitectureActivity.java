package dk.itu.chomsky.configurator;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

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
    }


}
