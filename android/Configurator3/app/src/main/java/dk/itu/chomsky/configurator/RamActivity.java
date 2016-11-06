package dk.itu.chomsky.configurator;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

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
    }
}
