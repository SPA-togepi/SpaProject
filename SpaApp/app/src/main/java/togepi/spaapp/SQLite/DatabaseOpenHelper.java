package togepi.spaapp.SQLite;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by SuzukiRikuro on 2016/05/12.
 */
public class DatabaseOpenHelper extends SQLiteOpenHelper{

    private static final String DATABASE_NAME = "TeamMemberDB";
    private static final int DATABASE_VERSION = 1;

    public DatabaseOpenHelper(Context context){
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String query = "create table person(" + "_id integer primary key autoincrement," +
                " name text not null," + "role text" + ");";
        db.execSQL(query);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
