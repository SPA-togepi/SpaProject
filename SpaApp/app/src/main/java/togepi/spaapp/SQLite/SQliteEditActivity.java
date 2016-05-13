package togepi.spaapp.SQLite;

import android.content.ContentValues;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import togepi.spaapp.R;

public class SQliteEditActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sqlite_edit);

        Intent intent = getIntent();
        final String editId = intent.getStringExtra("editId");

        final EditText editName = (EditText) findViewById(R.id.editName);
        final EditText editRole = (EditText) findViewById(R.id.editRole);

        final DatabaseOpenHelper databaseOpenHelper = new DatabaseOpenHelper(this);
        SQLiteDatabase db = null;
        Cursor c = null;


        try {
            db = databaseOpenHelper.getReadableDatabase();
            c = db.query("person", new String[]{"name", "role"}, "_id=?", new String[]{editId}, null, null, null, null);

            c.moveToFirst();
            editName.setText(c.getString(0));
            editRole.setText(c.getString(1));
        } finally {
            if(c != null){
                c.close();
            }
            if(db != null){
                db.close();
            }
        }

        final Button submitButton = (Button) findViewById(R.id.submit);
        submitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SQLiteDatabase db2 = null;
                Cursor c2 = null;

                ContentValues cv = new ContentValues();
                cv.put("name", editName.getText().toString());
                cv.put("role", editRole.getText().toString());
                try {
                    db2 = databaseOpenHelper.getReadableDatabase();
                    db2.update("person", cv, "_id=?", new String[] {editId} );
                } finally {
                    if(db2 != null){
                        db2.close();
                    }
                    Intent intent = new Intent(SQliteEditActivity.this, SQLiteActivity.class);
                    startActivity(intent);
                }
            }
        });


    }
}
