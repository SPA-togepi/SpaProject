package togepi.spaapp.SQLite;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

/**
 * Created by SuzukiRikuro on 2016/05/12.
 */
public class DatabaseOpenHelper extends SQLiteOpenHelper{

    private static final String DATABASE_NAME = "togepi_DB";
    private static final int DATABASE_VERSION = 1;

    public DatabaseOpenHelper(Context context){
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String query =  " create table users(" + "_id text primary key," +
                        " donationAmount integer, " + "Bitmap blob " + ");" +
                        " create table partySettings(" + "hostID text primary key," +
                        " initialMoney integer, " + "prizeNumber integer, " +
                        " RankingFlag integer " + ");" +
                        " create table prizes(" + "_id integer primary key autoincrement," +
                        " url text," + "image blob, " + " name text," + "Genre text" + ");" +
                        " create table admins(" + "_id integer primary key autoincrement," +
                        " initialMoney integer, " + "currentMoney integer, " + "prizeNumber integer," +
                        " leftItemNum integer" + ");" +
                        " create table networks(" + "hostId text" + ");";

        Log.v("oraora","execute query");
        db.execSQL(query);
        Log.v("oraora","success!!");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
