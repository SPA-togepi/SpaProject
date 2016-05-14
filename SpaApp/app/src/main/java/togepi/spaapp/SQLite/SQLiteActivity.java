package togepi.spaapp.SQLite;

import android.content.ContentValues;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import togepi.spaapp.R;

public class SQLiteActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sqlite);


        final DatabaseOpenHelper databaseOpenHelper = new DatabaseOpenHelper(this);

        final EditText nameText = (EditText) findViewById(R.id.editName);
        final EditText roleText = (EditText) findViewById(R.id.editRole);
        final EditText editId = (EditText) findViewById(R.id.editId);

        Button entryButton = (Button) findViewById(R.id.insert);
        entryButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name = nameText.getText().toString();
                String role = roleText.getText().toString();

                ContentValues insertValues = new ContentValues();
                insertValues.put("name", name);
                insertValues.put("role", role);

                SQLiteDatabase db = null;
                try {
                    db = databaseOpenHelper.getWritableDatabase();
                    long id = db.insert("person", name, insertValues);
                } finally {
                    if(db != null){
                        db.close();
                    }
                }
            }
        });

        Button showButton = (Button) findViewById(R.id.show);
        showButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent dbIntent = new Intent(SQLiteActivity.this, ShowDbActivity.class);
                startActivity(dbIntent);
            }
        });

        Button updateButton = (Button) findViewById(R.id.update);
        updateButton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                String id = editId.getText().toString();

                if (id.isEmpty()) {
                    Toast.makeText(SQLiteActivity.this, "idを入力してください", Toast.LENGTH_SHORT).show();
                }else{
                    Intent updateIntent = new Intent(SQLiteActivity.this, SQliteEditActivity.class);
                    updateIntent.putExtra("editId", id);
                    startActivity(updateIntent);
                }
            }
        });

        Button deleteButton = (Button) findViewById(R.id.delete);
        deleteButton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                String id = editId.getText().toString();

                SQLiteDatabase db = null;
                try {
                    if (id.isEmpty()) {
                        Toast.makeText(SQLiteActivity.this, "idを入力してください", Toast.LENGTH_SHORT).show();
                    } else {
                        db = databaseOpenHelper.getWritableDatabase();
                        db.delete("person", "_id=?", new String[]{id});
                    }
                } finally {
                    if(db != null){
                        db.close();
                    }
                }
            }
        });
    }

    private boolean idEmptyCheck() {
        return true;
    }
}
