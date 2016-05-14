package togepi.spaapp.SQLite;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.LinearLayout;
import android.widget.TextView;

import togepi.spaapp.R;

public class ShowDbActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_db);

        LinearLayout layout = new LinearLayout(this);
        layout.setOrientation(LinearLayout.VERTICAL);

        setContentView(layout);
        DatabaseOpenHelper helper = new DatabaseOpenHelper(this);
        SQLiteDatabase db = helper.getReadableDatabase();

        // queryメソッドの実行例
        Cursor c = db.query("users", new String[] { "_id", "donationAmount"}, null, null, null, null, null);

        boolean mov = c.moveToFirst();

        while (mov) {
            TextView textView = new TextView(this);
            textView.setText(String.format("%d : 名前 %s", c.getInt(0), c.getString(1)));

            mov = c.moveToNext();

            layout.addView(textView);
        }

        c.close();
        db.close();
    }
}
