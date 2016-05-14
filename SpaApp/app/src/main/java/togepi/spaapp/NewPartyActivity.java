package togepi.spaapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class NewPartyActivity extends AppCompatActivity {

    EditText partyNameEdit;

    String partyName = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_party);

        initView();

        Button createPartyIdButton = (Button) findViewById(R.id.createPartyIdButton);
        createPartyIdButton.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {
                partyName = partyNameEdit.getText().toString();

                Intent intent = new Intent(NewPartyActivity.this, AdminActivity.class);
                intent.putExtra("partyName", partyName);
                startActivity(intent);
            }
        });
    }

    private void initView(){
        partyNameEdit = (EditText) findViewById(R.id.newPartyID);
    }

    private void setOnClick(){

    }
}
