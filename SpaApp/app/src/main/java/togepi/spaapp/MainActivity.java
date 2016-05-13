package togepi.spaapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    Button blbtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initView();
        setOnClick();
    }

    private void initView(){
        blbtn = (Button) findViewById(R.id.blactBtn);

    }

    private void setOnClick(){
        blbtn.setOnClickListener(buttonBluetooth);
    }

    View.OnClickListener buttonBluetooth = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Intent intent_bt = new Intent(getApplicationContext(), BluetoothActivity.class);
            startActivity(intent_bt);
        }
    };

}
