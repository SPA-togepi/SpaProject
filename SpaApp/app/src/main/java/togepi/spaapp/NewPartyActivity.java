package togepi.spaapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class NewPartyActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_party);

        Button createPartyIdButton = (Button) findViewById(R.id.createPartyIdButton);
        createPartyIdButton.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {
                Intent intent = new Intent(NewPartyActivity.this, AdminActivity.class);
                startActivity(intent);
            }
        });
    }
}
