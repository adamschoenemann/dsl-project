package dk.itu.chomsky.configurator;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class CPUActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cpu);

        //setup the button
        Button buttonMotherboard     = (Button) findViewById(R.id.buttonCpuMb);
        Button buttonRam = (Button) findViewById(R.id.buttonCpuRam);

        buttonMotherboard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent arch = new Intent(CPUActivity.this,ArchitectureActivity.class);
                startActivity(arch);
            }
        });

        buttonRam.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent arch = new Intent(CPUActivity.this,RamActivity.class);
                startActivity(arch);
            }
        });
    }
}
